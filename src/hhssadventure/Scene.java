/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
    
    public void setLeft(Scene s) {
        this.left = s;
    }
    
    public void setRight(Scene s) {
        this.right = s;
    }
    
    public void setForward(Scene s) {
        this.forward = s;
    }
    
    public Scene getForward()
    {
        return forward;
    }
    
    public Scene getRight()
    {
        return right;
    }
    
    public Scene getLeft()
    {
        return left;
    }
    
    public BufferedImage getPicture() throws IOException
    {
        if (image == null)
        {
            image = ImageIO.read(new File("images\\" + imagePath));
        }
        return image;
    }
    
    public String getImagePath()
    {
        return imagePath;
    }
    
    
    
    
    
}
