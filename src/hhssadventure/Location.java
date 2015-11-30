/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author naylj6470
 */
public class Location {

    private Scene[] scenes = new Scene[4];
    private String name;

    /**
     * Constructor for the locations
     * @param constructor the scanner that is reading the files
     */
    public Location(Scanner constructor) {
        //store the locations' name
        name = constructor.nextLine();
        //create scenes for all 4 direction of the location
        for (int i = 0; i < 4; i++) {
            Scene s = new Scene(constructor);
            scenes[i] = s;
            //set each scenes' description
            s.setDescription(name + " facing " + s.getDirection());
        }
    }

    /**
     * Getter for the location name
     * @return the name of the location
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for a scenes image
     * @param dir the direction for the scene
     * @return the image of the scene facing a specific direction
     */
    public BufferedImage getSceneImage(String dir) {
        for (int i = 0; i < 4; i++) {
            if (dir.equals(scenes[i].getDirection())) {
                return scenes[i].getImage();
            }
        }
        return null;
    }

    /**
     * Getter for if the front is blocked
     * @param dir the direction for the scene
     * @return true or false
     */
    public boolean isFrontBlocked(String dir) {
        for (int i = 0; i < 4; i++) {
            if (dir.equals(scenes[i].getDirection())) {
                return scenes[i].isFrontBlocked();
            }
        }
        return true;
    }

    /**
     * Getter for a scenes description
     * @param dir the direction for the scene
     * @return the description of the scene facing a specific direction
     */
    public String getSceneDescription(String dir) {
        for (int i = 0; i < 4; i++) {
            if (dir.equals(scenes[i].getDirection())) {
                return scenes[i].getDescription();
            }
        }
        return null;
    }

    /**
     * Getter for a scenes next location
     * @param dir the direction for the scene
     * @return the next location of the scene facing a specific direction
     */
    public String getSceneNextLocation(String dir) {
        for (int i = 0; i < 4; i++) {
            if (dir.equals(scenes[i].getDirection())) {
                return scenes[i].getNextLocation();
            }
        }
        return null;
    }

    /**
     * Getter for a scenes next direction
     * @param dir the direction for the scene
     * @return the next direction of the scene facing a specific direction
     */
    public String getSceneNextDirection(String dir) {
        for (int i = 0; i < 4; i++) {
            if (dir.equals(scenes[i].getDirection())) {
                return scenes[i].getNextDirection();
            }
        }
        return null;
    }
}
