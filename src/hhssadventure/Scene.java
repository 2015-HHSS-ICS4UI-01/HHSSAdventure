/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author rayan4858
 */
public class Scene {

    //variables to hold strings and names
    private String direction;
    private String imageName;
    private String isBlocked;
    private String nextLocation;
    private String nextDirection;
    //set the boolean as not blocked to begin
    private boolean frontBlock = false;
    //declare the image variable
    private BufferedImage img = null;

    //constructor 
    public Scene(Scanner input) {
        //the direction is read from the next line in the text file
        direction = input.next();
        //the image name is read from the next line in the text file
        imageName = input.next();
        //whether the front is path is blocked or not is the next line
        isBlocked = input.next();
        //if the front is not blocked
        if (isBlocked.equals("false")) {
            //the front is blocked boolean is true
            frontBlock = true;
            //the next direction and location are read from the text file
            nextLocation = input.next();
            nextDirection = input.next();
        } else {
            //the front is not blocked
            frontBlock = false;
        }
        //skip to the next line in the file
        input.nextLine();  
        
        //get the images
        try {
            img = ImageIO.read(new File("images/" + imageName));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * is the front blocked
     * @return whether the front is blocked or not
     */
    public boolean frontBlocked() {
        return this.frontBlock;
    }

    /**
     * what the next location is
     * @return the next location
     */
    public String nextLocation() {
        return this.nextLocation;
    }

    /**
     * get the direction 
     * @return the direction
     */
    public String getDirection() {
        return this.direction;
    }

    /**
     * what the next direction is
     * @return the next direction
     */
    public String nextDirection() {
        return this.nextDirection;
    }

    /**
     * get the image 
     * @return the image
     */
    public BufferedImage getImage() {
        return this.img;
    }
}
