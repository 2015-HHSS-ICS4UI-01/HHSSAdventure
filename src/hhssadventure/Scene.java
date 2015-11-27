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

    public String getDirection() {
        return this.direction;
    }

    public String getPicture() {
        return this.picture;
    }

    public boolean getIsFrontBlocked() {
        return this.isFrontBlocked;
    }

    public String getNextLocation() {
        return this.nextLocation;
    }

    public String getNextDirection() {
        return this.nextDirection;
    }

    public String getDescription() {
        return this.description;
    }
}
