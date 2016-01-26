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
/**
 * This method is to check if the location at the current direction is blocked
 * @param dir The direction that the user is facing 
 * @return If the direction ahead of them is blocked
 */
    public boolean isFrontBlocked(String dir) {
        for (int i = 0; i < 4; i++) {
            if (scenes[i].getDirection().equals(dir)) {
                return scenes[i].isBlocked();
            }
          }
       return true; 
  }
/**
 * This method is to get the next location that the player can tavel to if the front is not blocked
 * @param dir The current direction that the player is facing 
 * @return Returning the location that the player can travel to if they can
 */
    public String getNextLocation(String dir) {
        for (int i = 0; i < 4; i++) {
            if (scenes[i].getDirection().equals(dir)) {
                return scenes[i].getNextLocation();
            }
        }
        return null;
    }
/**
 * This method is to get the current image of the place that the player is at
 * @param dir the current direction that the player is at
 * @return return the image, if there is one to show
 */
    public BufferedImage getImage(String dir) {
        for (int i = 0; i < 4; i++) {
            if (scenes[i].getDirection().equals(dir)) {
                return scenes[i].getImage();
            }
        }
        return null;
    }
/**
 * Returns the name of the location that the player is at.
 * @return returns the name of the location.
 */
    public String getName() {
        return this.name;
    }
}
