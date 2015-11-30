/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.image.BufferedImage;
import java.util.Scanner;

/**
 *
 * @author isles3536
 */
public class Location {

    private Scene[] scenes;
    private String name;

    public Location(Scanner input) {

        scenes = new Scene[4];

        name = input.nextLine();
        for (int i = 0; i < 4; i++) {
            Scene s = new Scene(input);
            scenes[i] = s;
        }



    }

    public boolean isFrontBlocked(String dir) {
        for (int i = 0; i < 4; i++) {
            if (scenes[i].getDirection().equals(dir)) {
                return scenes[i].isBlocked();
            }
    }
       return true; 
  }

    public String getNextLocation(String dir) {
        for (int i = 0; i < 4; i++) {
            if (scenes[i].getDirection().equals(dir)) {
                return scenes[i].getNextLocation();
            }
        }
        return "";
    }

    public BufferedImage getImage(String dir) {
        for (int i = 0; i < 4; i++) {
            if (scenes[i].getDirection().equals(dir)) {
                return scenes[i].getImage();
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }
}
