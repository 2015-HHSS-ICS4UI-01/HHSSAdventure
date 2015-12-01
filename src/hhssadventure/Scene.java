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
public final class Scene {
    
    private final int dir;
    private final String imageName;
    private final boolean frontBlocked;
    private String nextLocation;
    private int nextDir;
    
    public Scene(Scanner in) {
        String temp = in.next();
        dir = convert(temp);
        imageName = in.next();
        String test = in.next();
        if (test.equals("false")) {
            frontBlocked = false;
            nextLocation = in.next();
            temp = in.nextLine();
            nextDir = convert(temp);
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
    public String getImageName() {
        return imageName;
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
     * @return next direction
     * 
     */
    public int getNextDir() {
        return nextDir;
    }
    
    public int convert(String temp) {
        int direction;
        switch (temp) {
            case "N":
                direction = 0;
                break;
            case "E":
                direction = 1;
                break;
            case "S":
                direction = 2;
                break;
            default:
                direction = 3;
                break;
        }
        return direction;
    }
}
