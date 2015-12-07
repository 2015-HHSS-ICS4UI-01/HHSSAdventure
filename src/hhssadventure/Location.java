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
public class Location {

    private final String locationName;
    private final Scene[] scenes = new Scene[4];

    /**
     * Reads in the information for each location
     *
     * @param in the scanner to read the file
     */
    public Location(Scanner in) {
        locationName = in.nextLine();
        for (int i = 0; i < scenes.length; i++) {
            Scene s = new Scene(in);
            scenes[i] = s;
        }
    }

    /**
     * gets the name of the location
     *
     * @return the location name
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * gets the current scene
     *
     * @param dir the direction the player is facing
     * @return the current scene
     */
    public Scene getCurrentScene(int dir) {
        return scenes[dir];
    }
}
