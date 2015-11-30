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
        String temp = in.nextLine();
        image = in.next();
        String test = in.next();
        if (test.equals("false")) {
            frontBlocked = false;
            nextLocation = in.next();
            nextDir = in.nextInt();
            in.nextLine();
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
}
