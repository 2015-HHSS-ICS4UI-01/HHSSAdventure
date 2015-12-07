/*
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

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
     * Returns the name of the location.
     * @return the location's name.
     */
    public String getName(){
        return this.locationName;
    }
    
    /**
     * Returns the picture associated with the current scene.
     * @return the scene's image.
     */
    public String getImage(String direction){
        for(int i = 0; i < scenes.length; i++){
            if(direction.equals(scenes[i].getDirection())){
                return scenes[i].getPicture();
            }
        }
        
        return null;   
    }
    
    /**
     * Returns whether the player is able to move forward to another location.
     * @return whether or not the player can move forward.
     */
    public boolean isBlocked(String direction){
        for(int i = 0; i < scenes.length; i++){
            if(direction.equals(scenes[i].getDirection())){
                return scenes[i].isBlocked();
            }
        }
        
        return true;
    }
    
    /**
     * Returns the description associated with the current scene.
     * @return the scene's description.
     */
    public String getDescription(String direction){
        for(int i = 0; i < scenes.length; i++){
            if(direction.equals(scenes[i].getDirection())){
                return scenes[i].getDescription();
            }
        }
        
        return null;
    }
    
    /**
     * Returns the location that the player can move to from this scene.
     * @return the name of the location.
     */
    public String getNextLocation(String direction){
        for(int i = 0; i < scenes.length; i++){
            if(direction.equals(scenes[i].getDirection())){
                return scenes[i].getNextLocation();
            }
        }
        
        return null;
    }
    
    /**
     * Returns the direction that the player will face in the next location.
     * @param direction
     * @return 
     */
    public String getNextDirection(String direction){
        for(int i = 0; i < scenes.length; i++){
            if(direction.equals(scenes[i].getDirection())){
                return scenes[i].getNextDirection();
            }
        }
        
        return null;
    }
    
}
