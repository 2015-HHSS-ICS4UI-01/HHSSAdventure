/*
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.util.Scanner;

/**
 * The Scenes that correspond to Locations in the game.
 * @author morgennebesenschek
 */
public class Scene {
    private String sceneDirection;
    private String scenePicture;
    private boolean isBlocked;
    private String nextLocation;
    private String nextDirection;
    private String description;
    
    public Scene(Scanner input){
        sceneDirection = input.next();
        scenePicture = input.next();
        String check = input.next();
        //if front of scene is blocked, go to the next scene
        if(check.equals("true")){
            isBlocked = true;
            input.nextLine();
        }
        //if not blocked, add the next location and its direction first
        else{
            isBlocked = false;
            nextLocation = input.next();
            nextDirection = input.nextLine();
        }
        description = input.nextLine();
        
        
    }
    
    /**
     * Returns the faced direction in the current scene.
     * @return the current direction.
     */
    public String getDirection(){
        return this.sceneDirection;
    }
    
    /**
     * Returns the picture associated with the scene.
     * @return the scene's image.
     */
    public String getPicture(){
        return this.scenePicture;
    }
    
    /**
     * Returns whether the player can move forward to another location.
     * @return whether or not the player is blocked from moving forward.
     */
    public boolean isBlocked(){
        return this.isBlocked;
    }
    
    /**
     * Returns the location that will be entered if the player moves forward. 
     * @return the new location.
     */
    public String getNextLocation(){
        return this.nextLocation;
    }
    
    /**
     * Returns the scene the player will start from in the next location
     * @return the starting scene of the next location.
     */
    public String getNextDirection(){
        return this.nextDirection;
    }
    
    /**
     * Returns the description associated with the scene.
     * @return the scene's description.
     */
    public String getDescription(){
        return this.description;
    }  
}