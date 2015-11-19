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
public class Scene {
    private String sceneDirection;
    private Image sceneImage;
    private boolean isBlocked;
    private String nextLocation;
    private String nextDirection;
    
    public Scene(Scanner input){
        
    }
    
    /**
     * Returns the faced direction in the current scene 
     * @return the current direction
     */
    public String sceneDirection(){
        return this.sceneDirection;
    }
    
    /**
     * Returns the image associated with the current scene.
     * @return the image of the scene.
     */
    public Image sceneImage(){
        return this.sceneImage;
    }
    
    /**
     * Returns whether the player is able to move forward to another location.
     * @return whether or not the player can move forward.
     */
    public boolean isBlocked(){
        return this.isBlocked;
    }
    
    /**
     * Returns the location that the player can move to from this scene.
     * @return the name of the location
     */
    public String nextLocation(){
        return this.nextLocation;
    }
    
    /**
     * Returns the starting scene of the next location
     * @return the scene the player will start from in the next location
     */
    public String nextDirection(){
        return this.nextDirection;
    }
    
    
    
    
    
}