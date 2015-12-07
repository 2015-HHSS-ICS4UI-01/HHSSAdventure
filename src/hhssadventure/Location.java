/*
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.util.Scanner;

/**
 * The Locations that can be explored in the game.
 * @author morgennebesenschek
 */
public class Location {
    private String locationName;
    //array to hold all possible directions in the game
    private String[] directions;
    //tracks the current direction in integer form
    private int currentDirection;
    //the areas that correspond to each direction of a location
    private Scene[] scenes;
    
    //constructor for the locations using a text file
    public Location(Scanner input){
        directions = new String[] {"N","E","S","W"};
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
        for(int i = 0; i < directions.length; i++){
            if(direction.contains(directions[i])){
                currentDirection = i;
            }
        }
        return scenes[currentDirection].getPicture();
    }
    
    /**
     * Returns whether the player is able to move forward to another location.
     * @param direction the player's current direction.
     * @return whether or not the player can move forward.
     */
    public boolean isBlocked(String direction){
        for(int i = 0; i < directions.length; i++){
            if(direction.contains(directions[i])){
                currentDirection = i;
            }
        }
        return scenes[currentDirection].isBlocked();
    }
    
    /**
     * Returns the description associated with the current scene.
     * @param direction the 
     * @return the scene's description.
     */
    public String getDescription(String direction){
        for(int i = 0; i < directions.length; i++){
            if(direction.contains(directions[i])){
                currentDirection = i;
            }
        }
        return scenes[currentDirection].getDescription();
    }
    
    /**
     * Returns the location that the player can move to from this scene.
     * @param direction the player's current direction. 
     * @return the name of the next location.
     */
    public String getNextLocation(String direction){
        for(int i = 0; i < directions.length; i++){
            if(direction.contains(directions[i])){
                currentDirection = i;
            }
        }
        return scenes[currentDirection].getNextLocation();
    }
    
    /**
     * Returns the direction that the player will face in the next location.
     * @param direction the player's current direction.
     * @return the next direction
     */
    public String getNextDirection(String direction){
        for(int i = 0; i < directions.length; i++){
            if(direction.contains(directions[i])){
                currentDirection = i;
            }
        }
        return scenes[currentDirection].getNextDirection();
    }
    
}
