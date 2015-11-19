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
    private String currentLocation;
    private String currentDirection;
    private Scene[] scenes;
    
    
    //constructor for the locations using a text file
    public Location(Scanner input){
        currentLocation = input.next();
        currentDirection = input.next();
        
        
    }
    
    /**
     * Returns the current location the player is at.
     * @return the current location.
     */
    public String currentLocation(){
        return this.currentLocation;
    }
    
    /**
     * Returns the current direction the user is facing.
     * @return the current direction.
     */
    public String currentDirection(){
        return this.currentDirection;
    }
    
}
