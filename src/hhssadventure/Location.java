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
        name = input.nextLine();
        scenes = new Scene[4];
        numOfPictures = 4;
        for (int i = 0; i < numOfPictures; i++) {
            Scene s = new Scene(input);
            scenes[i] = s;
        }
    }

    /**
     *
     * @param position
     * @return
     */
    public String getImage(int position) {
        return scenes[position].getPicture();
    }

    /**
     *
     * @return
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
