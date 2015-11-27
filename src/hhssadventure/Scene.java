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
 * The image the user is facing.
 * 
 * @author johns6971
 */
public class Scene {
    //Name of the image in scene.
    private String imagePath;
    //The stored image of the scene.
    private BufferedImage image;
    //Whether or not the user can go forward from this scene
    private boolean frontBlocked;
    //The scene to the left of the current one.
    private Scene left;
    //The scene to the right of the current one.
    private Scene right;
    //The scene in front of the current one.
    private Scene forward;

    /**
     * Initializes the scene
     * 
     * @param imagePath the file name of the image associated with the scene.
     * @param frontBlocked Whether or not the scene has a possible scene in front of it.
     */
    public Scene(String imagePath, boolean frontBlocked) {
        this.imagePath = imagePath;
        this.frontBlocked = frontBlocked;
    }

    /**
     * sets the scene to the left of the current scene.
     *
     * @param s the scene to set as left.
     */
    public void setLeft(Scene s) {
        this.left = s;
    }

    /**
     * Sets the scene to the right of the current scene.
     *
     * @param s the scene to set as right.
     */
    public void setRight(Scene s) {
        this.right = s;
    }

    /**
     * Sets the scene in front of the current scene
     *
     * @param s the scene to set as forward.
     */
    public void setForward(Scene s) {
        this.forward = s;
    }

    /**
     * Gets the scene in front of the current scene.
     *
     * @return the forward scene.
     */
    public Scene getForward() {
        return forward;
    }

    /**
     * Gets the scene to the right of the current scene.
     *
     * @return the right scene.
     */
    public Scene getRight() {
        return right;
    }

    /**
     * Gets the scene to the left of the current scene.
     *
     * @return the left scene.
     */
    public Scene getLeft() {
        return left;
    }

    /**
     * Gets the image from the scene.
     *
     * @return the image.
     */
    public BufferedImage getImage() {
        //If there is no image stored
        if (image == null) {
            try {
                //Find the image and store it
                image = ImageIO.read(new File("images\\" + imagePath));
            } catch (IOException ex) {
                Logger.getLogger(Scene.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return image;
    }
    
    /**
     * Checks if there is space in front to move.
     *
     * @return if front is blocked.
     */
    public boolean isBlocked() {
        return frontBlocked;
    }
}
