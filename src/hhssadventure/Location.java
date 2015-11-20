/*
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.Image;
import java.util.Scanner;

/**
 *
 * @author morgennebesenschek
 */
public class Location {
    private String locationName;
    private Scene[] scenes;
    
    
    //constructor for the locations using a text file
    public Location(Scanner input){
        locationName = input.next();
        scenes = new Scene[4];
        
        for(int i = 0; i < scenes.length; i++){
            //creates a scene
            Scene s = new Scene(input);
            //add scene to the list
            scenes[i] = s;
        }
        
        
    }
    
    /**
     * Returns the picture associated with the current scene.
     * @return the scene's image.
     */
    public String getImage(int direction){
        return scenes[direction].getPicture();
    }
    
    /**
     * Returns whether the player is able to move forward to another location.
     * @return whether or not the player can move forward.
     */
    public boolean isBlocked(int direction){
         return scenes[direction].isBlocked();
    }
    
    /**
     * Returns the description associated of the current scene
     * @return the scene description.
     */
    public String getDescription(int direction){
        return scenes[direction].getDescription();
    }
    
    /**
     * Returns the location that the player can move to from this scene.
     * @return the name of the location.
     */
    public String getNextLocation(int direction){
        return scenes[direction].getNextLocation();
    }
    
}
