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

    private String pichure;
    private String direction;
    private boolean isFrontBlocked;
    private String nextLocation;
    private String nextDirection;

    public Scene(Scanner input) {
        direction = input.next();
        pichure = input.next();
        String check = input.next();
        if (check.equals("false")) {
            isFrontBlocked = false;
            nextLocation = input.next();
            nextDirection = input.nextLine();
        } else {
            isFrontBlocked = true;
            input.nextLine();
        }
    }

    public String getDirection() {
        return this.direction;
    }

    public String getPichure() {
        return this.pichure;
    }

    public boolean isFrontBlocked() {
        return this.isFrontBlocked;
    }

    public String getNextLocation() {
        return this.nextLocation;
    }

    public String getNextDirection() {
        return this.nextDirection;
    }
}
