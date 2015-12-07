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

    private int dir;
    private String imageName;
    private boolean frontBlocked;
    private String nextLocation;
    private int nextDir;

    /**
     * Reads in the information for each scene
     * @param in the scanner to read the file
     */
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
     *
     * @return direction
     */
    public int getDir() {
        return dir;
    }

    /**
     * gets the current image name
     *
     * @return image name
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * gets whether or not the front passage is blocked or not
     *
     * @return true or false
     */
    public boolean getFrontBlocked() {
        return frontBlocked;
    }

    /**
     * gets the next location
     *
     * @return the next location
     */
    public String getNextLocation() {
        return nextLocation;
    }

    /**
     * gets next direction
     *
     * @return next direction
     *
     */
    public int getNextDir() {
        return nextDir;
    }
    
    /**
     * Converts the direction to an integer
     * @param temp the string to convert
     * @return the direction as an integer
     */
    public int convert(String temp) {
        int num;
        switch (temp) {
            case " N":
                num = 0;
                break;
            case " E":
                num = 1;
                break;
            case " S":
                num = 2;
                break;
            default:
                num = 3;
                break;
        }
        return num;
    }
}