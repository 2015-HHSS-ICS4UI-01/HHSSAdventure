/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
public class UserInterface extends JComponent implements MouseMotionListener {

    private JFrame window;
    private int HIEGHT;
    private int WIDTH;
    private boolean moveForward;
    private Scene currentScene;
    //create variables for centre of the screen
    int centerX;
    int centerY;
    int hDisplacement;

    public UserInterface(Scene s) {
        //sets the current scene to display
        currentScene = s;

        moveForward = false;

        HIEGHT = 945;
        WIDTH = 1265;

        centerX = WIDTH / 2;
        centerY = HIEGHT / 2;
        hDisplacement = 0;

        //sets JFrame settings
        window = new JFrame("HHSS Adventure");
        window.add(this);
        window.setVisible(true);
        this.setPreferredSize(new Dimension(WIDTH, HIEGHT));
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addMouseMotionListener(this);
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

}
