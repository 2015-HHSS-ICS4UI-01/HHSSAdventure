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
 *
 * @author johns6971
 */
public class UserInterface extends JComponent implements MouseMotionListener, KeyListener {

    private JFrame window;
    private int SCREEN_HEIGHT;
    private int SCREEN_WIDTH;
    private final int IMAGE_HEIGHT;
    private Scene currentScene;
    //create variables for centre of the screen
    private int centerX;
    private int centerY;
    private int hDisplacement;

    private boolean inGame;
    private boolean escapeDown;
    
    // To keep the mouse in the center of the screen
    private Robot robot;
    // an invisible cursor image
    private Cursor invisibleCursor = Toolkit.getDefaultToolkit().createCustomCursor(
            Toolkit.getDefaultToolkit().getImage(""),
            new Point(0, 0),
            "invisible");
    public UserInterface(Scene s) throws AWTException {
        //sets the current scene to display
        currentScene = s;
        inGame = true;

        SCREEN_HEIGHT = 945;
        SCREEN_WIDTH = 1265;
        
        IMAGE_HEIGHT = (int)(SCREEN_HEIGHT*0.9);

        centerX = SCREEN_WIDTH / 2;
        centerY = SCREEN_HEIGHT / 2;
        hDisplacement = 0;
        // initialize window stuff
        window = new JFrame("HHSS Adventure");
        window.add(this);
        
        window.setVisible(true);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addMouseMotionListener(this);
        window.addKeyListener(this);
        // center cursor
        robot = new Robot();
        hideCursor();
        centerMouse();
        
    }

    
    /**
     * Hides the mouse cursor
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
    public void centerMouse()
    {
        // sets the mouse location to the middle of the screen but offset due to the actual
            // screen picture being slightly offset due to the window border and actual physical location on the screen
        robot.mouseMove((int)this.getLocationOnScreen().getX() + centerX, (int)this.getLocationOnScreen().getY() + centerY);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(-hDisplacement, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        g.drawImage(currentScene.getImage(), -hDisplacement, (SCREEN_HEIGHT-IMAGE_HEIGHT)/2, SCREEN_WIDTH, IMAGE_HEIGHT, null);
        g.drawImage(currentScene.getLeft().getImage(), -hDisplacement-SCREEN_WIDTH, (SCREEN_HEIGHT-IMAGE_HEIGHT)/2, SCREEN_WIDTH, IMAGE_HEIGHT, null);
        g.drawImage(currentScene.getRight().getImage(), -hDisplacement+SCREEN_WIDTH, (SCREEN_HEIGHT-IMAGE_HEIGHT)/2, SCREEN_WIDTH, IMAGE_HEIGHT, null);
    }
    
    public void updateScene()
    {
        if (inGame)
        {
            if (Math.abs(hDisplacement) > centerX)
            {
                if (hDisplacement < 0)
                {
                    setScene(currentScene.getLeft());
                    hDisplacement += SCREEN_WIDTH;
                }
                else if (hDisplacement > 0)
                {
                    setScene(currentScene.getRight());
                    hDisplacement -= SCREEN_WIDTH;
                }
            }
        }
    }

    /**
     * Finds picture in new scene and sets it as the picture to display.
     *
     * @param s scene to change to
     */
    public void setScene(Scene s) {
        currentScene = s;
    }
    
    /**
     * Displays the mouse.
     */
    public void displayMouse() {
        if(inGame) {
            centerMouse();
            System.out.println("plssss");
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (inGame)
        {
            hDisplacement += e.getX() - centerX;
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
            if (!currentScene.isBlocked() && inGame)
            {
                setScene(currentScene.getForward());
            }
        } else if (KeyCode == KeyEvent.VK_A) {
            if (!currentScene.getLeft().isBlocked() && inGame)
            {
                setScene(currentScene.getLeft().getForward().getRight());
            }
        } else if (KeyCode == KeyEvent.VK_S) {
            if (!currentScene.getLeft().getLeft().isBlocked() && inGame)
            {
                setScene(currentScene.getLeft().getLeft().getForward().getRight().getRight());
            }
            
        } else if (KeyCode == KeyEvent.VK_D) {
            if (!currentScene.getRight().isBlocked() && inGame)
            {
                setScene(currentScene.getRight().getForward().getLeft());
            }
        } else if(KeyCode == KeyEvent.VK_ESCAPE) {
            if(!escapeDown) 
            {
                inGame = inGame ? false: true;
                if(inGame) {
                    hideCursor();
                } else {
                    showCursor();
                }
            }
            escapeDown = true;
        } 
    }

    @Override
    public void keyReleased(KeyEvent k) {
        int KeyCode = k.getKeyCode();
        if(KeyCode == KeyEvent.VK_ESCAPE) {
            escapeDown = false;
        } 
    }

}
