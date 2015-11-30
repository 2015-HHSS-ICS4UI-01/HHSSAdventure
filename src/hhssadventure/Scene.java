/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author donet6376
 */
public class Scene {

    private String direction;
    private String frontBlockedString;
    private boolean frontBlocked;
    private String nextLocation;
    private String description;
    private String nextDirection;
    private String imageName;
    private BufferedImage image;

    public Scene(Scanner constructor) {
        //read in the text file and sets the variables
        direction = constructor.next();
        imageName = constructor.next();
        frontBlockedString = constructor.next();
        //check if front is blocked
        if (frontBlockedString.equals("false")) {
            frontBlocked = false;
            nextLocation = constructor.next();
            nextDirection = constructor.next();
        } else {
            frontBlocked = true;
        }

        //read the image names from the text file
        try {
            File input = new File("images/" + imageName);
            image = ImageIO.read(input);
        } catch (IOException ie) {
            System.out.println("Error:" + ie.getMessage());
        }
        //move to next line in the text file
        constructor.nextLine();
    }

    /**
     * method to draw the image
     * @param g
     */
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }

    /**
     * returns the image
     * @return the image
     */
    public BufferedImage getImage() {
        return this.image;
    }

    /**
     * returns the direction of the image
     * @return the direction of the image
     */
    public String getDirection() {
        return this.direction;
    }

    /**
     * sets the description so location can chance it
     * @param temp the description
     */
    public void setDescription(String temp) {
        description = temp;
    }

    /**
     * returns the description
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * returns frontBlocked boolean
     * @return frontBlocked
     */
    public boolean isFrontBlocked() {
        return frontBlocked;
    }

    /**
     * returns the next location
     * @return nextLocation
     */
    public String getNextLocation() {
        return nextLocation;
    }

    /**
     * returns the next direction
     * @return nextDirection
     */
    public String getNextDirection() {
        return nextDirection;
    }
}