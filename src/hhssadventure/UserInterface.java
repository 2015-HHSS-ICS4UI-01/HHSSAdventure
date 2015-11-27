/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * The window the user sees
 * @author johns6971
 */
public class UserInterface extends JComponent implements MouseMotionListener, KeyListener {

    private final int SCREEN_HEIGHT;
    private final int SCREEN_WIDTH;
    // the height of the image being displayed
    private final int IMAGE_HEIGHT;
    // the center of the screen (for the mouse)
    private final int CENTER_X;
    private final int CENTER_Y;
    // The horizontal view distance (so the player can look left or right)
    private int hDisplacement;

    // if in game, the mouse is hidden and user can look around world, otherwise, can't interact with game
    private boolean inGame;
    // whether or not the escape key is being held down (to avoid flickering the mouse when toggling inGame)
    private boolean escapeDown;
    
    // To keep the mouse in the center of the screen
    private Robot robot;
    // an invisible cursor
    private Cursor invisibleCursor = Toolkit.getDefaultToolkit().createCustomCursor(
            Toolkit.getDefaultToolkit().getImage(""),
            new Point(0, 0),
            "invisible");
    
    private JFrame window;
    
    // The scene the player is facing as forward
    private Scene currentScene;
    
    public UserInterface(Scene s) throws AWTException {
        //sets the current scene to display
        currentScene = s;
        // the game starts as the user being in game
        inGame = true;
        
        SCREEN_HEIGHT = 945;
        SCREEN_WIDTH = 1265;
        //Sets the image size
        IMAGE_HEIGHT = (int)(SCREEN_HEIGHT*0.9);

        // center x and center y are simply the center of the screen
        CENTER_X = SCREEN_WIDTH / 2;
        CENTER_Y = SCREEN_HEIGHT / 2;
        // start the user facing exactly forward
        hDisplacement = 0;
        // initialize window stuff
        window = new JFrame("HHSS Adventure");
        
        window.setVisible(true);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        window.add(this);
        window.pack();
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // add event listeners
        this.addMouseMotionListener(this);
        window.addKeyListener(this);
        
        robot = new Robot();
        //Start off by hiding and entering the mouse
        hideCursor();
        centerMouse();
    }

    
    /**
     * Hides the mouse cursor.
     */
    private void hideCursor()
    {
        // set the current cursor to the invisible cursor image, which is simply an invisible image
        this.setCursor(invisibleCursor);
    }
    
    /**
     * Makes the mouse cursor visible.
     */
    private void showCursor()
    {
        // sets the cursor to the default cursor image (probably the white arrow)
        this.setCursor(Cursor.getDefaultCursor());
    }
    
    /**
     * Puts the mouse cursor to the center of the screen.
     */
    private void centerMouse()
    {
        // sets the mouse location to the middle of the screen but offset due to the actual
            // screen picture being slightly offset due to the window border and actual physical location on the screen
        robot.mouseMove((int)this.getLocationOnScreen().getX() + CENTER_X, (int)this.getLocationOnScreen().getY() + CENTER_Y);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        //checks which color to make the border
            // If the user can go forward, set the color to green
        if (!currentScene.isBlocked())
        {
            g.setColor(Color.GREEN);
        }
            // Otherwise, if the user can't go forward, set the color to red
        else
        {
            g.setColor(Color.RED);
        }
        // Draw red/green border to surround the current scene
        g.fillRect(-hDisplacement, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        // Draw the current scene at an offset y, at the negative of the user's position 
        g.drawImage(currentScene.getImage(), -hDisplacement, CENTER_Y-IMAGE_HEIGHT/2, SCREEN_WIDTH, IMAGE_HEIGHT, null);
        // Draw the left scene to the left of the current scene
        g.drawImage(currentScene.getLeft().getImage(), -hDisplacement-SCREEN_WIDTH, CENTER_Y-IMAGE_HEIGHT/2, SCREEN_WIDTH, IMAGE_HEIGHT, null);
        // Draw the right scene to the right of the current scene
        g.drawImage(currentScene.getRight().getImage(), -hDisplacement+SCREEN_WIDTH, CENTER_Y-IMAGE_HEIGHT/2, SCREEN_WIDTH, IMAGE_HEIGHT, null);
    }
    
    /**
     * Changes the current scene if the user looks too far to the right/left
     */
    public void updateScene()
    {
        // Only do this if the user is in game
        if (inGame)
        {
            // If the user looks past the center of the screen (basically, a new image is now dominating the screen, set the new scene to that image)
            if (Math.abs(hDisplacement) > CENTER_X)
            {
                // if the user was looking left, set the current scene to the left
                if (hDisplacement < 0)
                {
                    setScene(currentScene.getLeft());
                    // The hDisplacement is now inverted (it was negative, now is the positive difference between itself and the SCREEN_WIDTH
                    hDisplacement += SCREEN_WIDTH;
                }
                // if the user was looking right, set the current scene to the right
                else if (hDisplacement > 0)
                {
                    setScene(currentScene.getRight());
                    // the hDisplacement is now inverted (it was positive, now is the negative difference between itself and the SCREEN_WIDTH
                    hDisplacement -= SCREEN_WIDTH;
                }
            }
        }
    }

    /**
     * Updates the current scene
     *
     * @param s scene to change to
     */
    public void setScene(Scene s) {
        currentScene = s;
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // only adjust the view if the user is in game
        if (inGame)
        {
            // the horizontal mouse movement is the difference between the mouse and the center
            hDisplacement += e.getX() - CENTER_X;
            // now center the mouse since it has been moved away from the center
            centerMouse();
        }
    }

    @Override
    public void keyTyped(KeyEvent k) {
    }

    @Override
    public void keyPressed(KeyEvent k) {
        int KeyCode = k.getKeyCode();
        if(KeyCode == KeyEvent.VK_W) {
            // if the user can go forward and the user is in game, go forward
            if (!currentScene.isBlocked() && inGame)
            {
                setScene(currentScene.getForward());
            }
        } else if (KeyCode == KeyEvent.VK_A) {
            // if the scene to the user's left isn't blocked and the user is in game,
                // turn left, go forward, turn right (net result: user moves to the left, while facing forward)
            if (!currentScene.getLeft().isBlocked() && inGame)
            {
                setScene(currentScene.getLeft().getForward().getRight());
            }
        } else if (KeyCode == KeyEvent.VK_S) {
            // if the scene to the user's back isn't blocked and the user is in game,
                // turn left, turn left, go forward, turn right, turn right (net result: user moves backwards while facing forward)
            if (!currentScene.getLeft().getLeft().isBlocked() && inGame)
            {
                setScene(currentScene.getLeft().getLeft().getForward().getRight().getRight());
            }
            
        } else if (KeyCode == KeyEvent.VK_D) {
            // if the scene to the user's right isn't blocked and the user is in game,
                // turn right, go forward, turn left (net result: user moves to the right, while facing forward)
            if (!currentScene.getRight().isBlocked() && inGame)
            {
                setScene(currentScene.getRight().getForward().getLeft());
            }
            // if the user presses escape, toggle the inGame state
        } else if(KeyCode == KeyEvent.VK_ESCAPE) {
            // If the escape key isn't being held down
            if(!escapeDown) 
            {
                // toggle inGame state
                inGame = inGame ? false: true;
                // if the user is now in game, hide the cursor and center the mouse
                if(inGame) {
                    hideCursor();
                    centerMouse();
                    // otherwise, the mouse can now be shown
                } else {
                    showCursor();
                }
            }
            // escapeDown set to true so that if the user holds down the escape key for a while, the inGame doesn't keep toggling
            escapeDown = true;
        } 
    }

    @Override
    public void keyReleased(KeyEvent k) {
        int KeyCode = k.getKeyCode();
        // if the user has let go of the escape key, it is no longer being held down
        if(KeyCode == KeyEvent.VK_ESCAPE) {
            escapeDown = false;
        } 
    }
}
