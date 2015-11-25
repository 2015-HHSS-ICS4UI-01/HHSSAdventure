/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author johns6971
 */
public class Scene {
    private String imagePath;
    private BufferedImage image;
    private char direction;
    private String location;
    private boolean frontBlocked;
    
    private Scene left;
    private Scene right;
    private Scene forward;
    
    public Scene(String location, String picture, boolean frontBlocked, char direction) {
        this.imagePath = picture;
        this.direction = direction;
        this.frontBlocked = frontBlocked;
        this.location = location;
    }
    
    /**
     * 
     * @param s the scene to set as the left 
     */
    public void setLeft(Scene s) {
        this.left = s;
    }
    
    /**
     * @param s the scene to set as the left 
     */
    public void setRight(Scene s) {
        this.right = s;
    }
    
    /**
     * 
     * @param s 
     */
    public void setForward(Scene s) {
        this.forward = s;
    }
    
    /**
     * 
     * @return 
     */
    public Scene getForward()
    {
        return forward;
    }
    
    /**
     * 
     * @return 
     */
    public Scene getRight()
    {
        return right;
    }
    
    /**
     * 
     * @return 
     */
    public Scene getLeft()
    {
        return left;
    }
    
    /**
     * gets the image from the scene.
     * @return the image.
     */
    public BufferedImage getImage() 
    {
        if (image == null)
        {
            try {
                image = ImageIO.read(new File("images\\" + imagePath));
            } catch (IOException ex) {
                Logger.getLogger(Scene.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return image;
    }
    
    public String getImagePath()
    {
        return imagePath;
    }
    
    public boolean isBlocked() {
        return frontBlocked;
    }
    
    
    
    
    
}
