/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author yaol9270
 */
public class Scene {

    private String direction;
    private String name;
    private String picture;
    private String nextPicture;
    private String nextDirection;
    private BufferedImage img;
    private String here;
    private boolean blocked;

    public Scene(Scanner input) {
        //for each scene (1 line) get the following things (separated by spaces)
        direction = input.next();

        picture = input.next();
        //find the image
        img = null;
        try {
            img = ImageIO.read(new File("images/" + picture));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        here = input.next();
        //if it is not blocked, get next picture and next direction
        if (here.equals("false")) {
            blocked = false;
            nextPicture = input.next();
            nextDirection = input.next();
            
        }
        //otherwise blocked is true, and do not read anymore (as there is nothing more to read)
        else {
            blocked = true;

        }
        //go to next line
        input.nextLine();





    }

    /**
     * the picture for the scene
     * @return the image
     */
    public BufferedImage picture() {
        return this.img;
    }

    /**
     * the direction of the scene
     * @return the direction
     */
    public String direction() {
        return this.direction;
    }

    /**
     * if front is blocked
     * @return true if it is blocked, false if it is not
     */
    public boolean frontBlocked() {
        return this.blocked;
    }

    /**
     * gets the next location
     * @return the next location
     */
    public String nextLocation() {
        return this.nextPicture;
    }

    /**
     * gets the description for this scene
     * @return the name of the location
     */
    public String description() {
        return this.name;
    }

    /**
     * gets the next direction
     * @return the next direction
     */
    public String nextDirection() {
        return this.nextDirection;
    }
}
