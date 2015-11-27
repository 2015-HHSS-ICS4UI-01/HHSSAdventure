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
public class Location {

    private String name;
    private int numOfPictures;
    private Scene[] scenes;
    private Scene c = new Scene();

    public Location(Scanner input) {
        //get the name of the location
        name = input.nextLine();
        //getting the picture of the scene
        scenes = new Scene[4];
        numOfPictures = 4;
        for (int i = 0; i < numOfPictures; i++) {
            Scene s = new Scene(input);
            scenes[i] = s;
        }
    }

    /**
     * getting the scene from Scene class
     *
     * @param position getting the position of the picture 1 through 4
     * @return the position of the scene
     */
    public String getImage(int position) {
        return scenes[position].getPicture();
    }

    /**
     *get the 
     * @return isFrontBlocked
     */
    public boolean isFrontBlocked() {
        return c.getIsFrontBlocked();
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return this.name;
    }

    /**
     *
     * @return
     */
    public String getNextLocation() {
        return c.getNextLocation();
    }

    /**
     *
     * @return
     */
    public int getNumOfPictures() {
        return this.numOfPictures;
    }
}
