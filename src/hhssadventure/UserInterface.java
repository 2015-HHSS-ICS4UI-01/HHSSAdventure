/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.AWTException;
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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author johns6971
 */
public class UserInterface extends JComponent implements MouseMotionListener, KeyListener {

    private JFrame window;
    private int HIEGHT;
    private int WIDTH;
    private Scene currentScene;
    //create variables for centre of the screen
    int centerX;
    int centerY;
    int hDisplacement;

    

    
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


        HIEGHT = 945;
        WIDTH = 1265;

        centerX = WIDTH / 2;
        centerY = HIEGHT / 2;
        hDisplacement = 0;

        
        // sets up the mouse
        robot = new Robot();
        hideCursor();
        centerMouse();
        
        //sets JFrame settings
        window = new JFrame("HHSS Adventure");
        window.add(this);
        window.setVisible(true);
        this.setPreferredSize(new Dimension(WIDTH, HIEGHT));
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addMouseMotionListener(this);
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

     * Makes the mouse cursor visible
     */
    private void showCursor()
    {
        // sets the cursor to the default cursor image (probably the white arrow)
        this.setCursor(Cursor.getDefaultCursor());
    }
    
    /**
     * Puts the mouse cursor to the center of the screen
     */
    public void centerMouse()
    {
        // sets the mouse location to the middle of the screen but offset due to the actual
            // screen picture being slightly offset due to the window border and actual physical location on the screen
        robot.mouseMove((int)this.getLocationOnScreen().getX() + centerX, (int)this.getLocationOnScreen().getY() + centerY);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        try {
            g.drawImage(currentScene.getImage(), 0, 0, WIDTH, HIEGHT, this);
        } catch (IOException ex) {
            Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Finds picture in new scene and sets it as the picture to display
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
        hDisplacement = e.getX() - centerX;

    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

}
