/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.util.Scanner;

/**
 *
 * @author NathanKampzEtAndrewSSS
 */
public class Scene {
    
    private int dir;
    private String image;
    private boolean frontBlocked;
    private String nextLocation;
    private int nextDir;
    
    public Scene(Scanner in) {
        String temp = in.next();
        dir = convert(temp, dir);
        image = in.next();
        String test = in.next();
        if (test.equals("false")) {
            frontBlocked = false;
            nextLocation = in.next();
            temp = in.nextLine();
            nextDir = convert(temp, nextDir);
        } else {
            frontBlocked = true;
            in.nextLine();
        }
    }

    /**
     * gets the current direction
     * @return direction
     */
    public int getDir() {
        return dir;
    }

    /**
     * gets the current image name
     * @return image name
     */
    public String getImage() {
        return image;
    }

    /**
     * gets whether or not the front passage is blocked or not
     * @return true or false
     */
    public boolean getFrontBlocked() {
        return frontBlocked;
    }

    /**
     * gets the next location
     * @return the next location
     */
    public String getNextLocation() {
        return nextLocation;
    }

    /**
     * gets next direction

.* @return next direction
     */
    public int getNextDir() {
        return nextDir;
    }
    
    public int convert(String temp, int dir) {
        switch (temp) {
            //sets the direction to a number
            case "N":
                dir = 0;
                break;
            case "E":
                dir = 1;
                break;
            case "S":
                dir = 2;
                break;
            default:
                dir = 3;
                break;
        }
        //returns the direction
        return dir;
    }
}
