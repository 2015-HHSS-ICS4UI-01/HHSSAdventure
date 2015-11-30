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
     * getting a answer to see if front is blocked
     *
     * @param position to get the position of the next location
     * @return is front blocked with the position
     */
    public boolean isFrontBlocked(int position) {
        return scenes[position].getIsFrontBlocked();
    }

    /**
     * get the description of the photo
     *
     * @return name
     */
    public String getDescription() {
        return this.name;
    }

    /**
     * to get the next location
     *
     * @param position to get the position of the next location
     * @return the next location position
     */
    public String nextLocation(int position) {
        return scenes[position].nextLocation();
    }

    /**
     * get the number of the picture
     *
     * @return numOfPictures
     */
    public int getNumOfPictures() {
        return this.numOfPictures;
    }
}
