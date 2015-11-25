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
        name = input.nextLine();
        scenes = new Scene[4];
        numOfPictures = 4;
        for (int i = 0; i < numOfPictures; i++) {
            Scene s = new Scene(input);
            scenes[i] = s;
        }
    }

    public String getImage() {
        return scenes[position].getPicture();
    }

    public boolean isFrontBlocked() {
        return n.getClass;
    }

    public String getDescription() {
        return this.name;
    }

    public String getNextLocation() {
        return Scene.getClass(getNextLocation);
    }
}
