/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author johns6971
 */
public class UserInterface extends JComponent implements MouseListener, MouseMotionListener {
    
    private JFrame window;
    private final int HIEGHT = 945;
    private final int WIDTH = 1265;
    
    private boolean moveForward = false;
    
    private BufferedImage picture;
    
    private String image;
    private Robot robot;
    
    public UserInterface(Scene s) throws AWTException, IOException {
        //sets image to scene's image
        image = s.getPicture();
        //gets picture from location
        picture = ImageIO.read(new File("images\\" + image));
        
        this.robot = new Robot();
        
        //sets JFrame settings
        window = new JFrame("HHSS Adventure");
        window.add(this);
        window.setVisible(true);
        this.setPreferredSize(new Dimension(WIDTH, HIEGHT));
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addMouseListener(this);
    }
    
    public void paintComponent(Graphics g) {
        //draws the image is being stored
        g.drawImage(picture, 0, 0, WIDTH, HIEGHT, this);
    }
    
    /**
     * Finds picture in new scene and sets it as the picture to display
     * @param s scene to change to
     * @throws IOException 
     */
    public void setImage(Scene s) throws IOException {
        //sets image to new scene's image
        image = s.getPicture();
        //gets picture with new location
        picture = ImageIO.read(new File("images\\" + image));
        repaint();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            moveForward = true;
        }
        
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            moveForward = false;
        }
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    
}
