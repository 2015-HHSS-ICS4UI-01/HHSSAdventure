/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.util.Scanner;

/**
 *
 * @author paulm6438
 */
public class Scene {

    private String picture;
    private String direction;
    private boolean isFrontBlocked;
    private String nextLocation;
    private String nextDirection;
    private String description;

    public Scene(Scanner input) {
        //getting the direction of the picture
        direction = input.next();
        //getting the picture from that direction
        picture = input.next();
        //cheking if the front is blocked of not
        String check = input.next();
        if (check.equals("false")) {
            isFrontBlocked = false;
            //if not get the next location
            nextLocation = input.next();
            //get the next direction
            nextDirection = input.next();
        } else {
            isFrontBlocked = true;
            input.next();
        }
        //get description
        description = input.next();

    }

    Scene() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * the direction of the picture
     *
     * @return direction
     */
    public String getDirection() {
        return this.direction;
    }

    /**
     * the actual picture of the set scene
     *
     * @return picture
     */
    public String getPicture() {
        return this.picture;
    }

    /**
     * is front of the picture blocked
     *
     * @return isFrontBlocked
     */
    public boolean getIsFrontBlocked() {
        return this.isFrontBlocked;
    }

    /**
     * getting the next location to a picture
     *
     * @return nextLocation
     */
    public String getNextLocation() {
        return this.nextLocation;
    }

    /**
     * getting the next direction of the next location
     *
     * @return getNextDirection
     */
    public String getNextDirection() {
        return this.nextDirection;
    }

    /**
     * getting the description of the picture
     *
     * @return getDescription
     */
    public String getDescription() {
        return this.description;
    }
}
