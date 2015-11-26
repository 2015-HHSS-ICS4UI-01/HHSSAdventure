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
        direction = input.next();
        picture = input.next();
        String check = input.next();
        if (check.equals("false")) {
            isFrontBlocked = false;
            nextLocation = input.next();
            nextDirection = input.next();
        } else {
            isFrontBlocked = true;
            input.next();
        }
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
