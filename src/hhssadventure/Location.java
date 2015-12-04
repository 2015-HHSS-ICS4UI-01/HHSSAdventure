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
    private int dirCounter;
    private Scene[] scenes;
    
    
    //constructor for the locations using a text file
    public Location(Scanner input){
        dirCounter = 0;
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
        dirCounter = 0;
        while(dirCounter <= 3){
            if(direction.equals(scenes[dirCounter].getDirection())){
                break;
            }else{
                dirCounter++;
            }
        }
        
        return scenes[dirCounter].getPicture();
    }
    
    /**
     * Returns whether the player is able to move forward to another location.
     * @return whether or not the player can move forward.
     */
    public boolean isBlocked(String direction){
        dirCounter = 0;
        while(dirCounter <= 3){
            if(direction.equals(scenes[dirCounter].getDirection())){
                break;
            }else{
                dirCounter++;
            }
        }
        
        return scenes[dirCounter].isBlocked();
    }
    
    /**
     * Returns the description associated with the current scene.
     * @return the scene's description.
     */
    public String getDescription(String direction){
        
//        System.out.println(scenes[0].getDirection());
//        System.out.println(scenes[1].getDirection());
//        System.out.println(scenes[2].getDirection());
//        System.out.println(scenes[3].getDirection());
        
        int dirCounter = 0;
        System.out.println("Current " + direction);
        System.out.println("---");
        while(dirCounter <= 3){
            System.out.println(scenes[dirCounter].getDirection());
            if(direction.equals(scenes[dirCounter].getDirection())){
                break;
            }else{
                dirCounter++;
            }
        }
//        if(direction.equals("N")){
//            dir = 0;
//        }
//        if(direction.equals("E")){
//            dir = 1;
//        }
//        if(direction.equals("S")){
//            dir = 2;
//        }
//        if(direction.equals("W")){
//            dir = 3;
//        }
        
        return scenes[dirCounter].getDescription();
    }
    
    /**
     * Returns the location that the player can move to from this scene.
     * @return the name of the location.
     */
    public String getNextLocation(String direction){
        int dirCounter = 0;
        while(dirCounter <= 3){
            if(direction.equals(scenes[dirCounter].getDirection())){
                break;
            }else{
                dirCounter++;
            }
            
        }
//        if(direction.equals("N")){
//            dir = 0;
//        }
//        if(direction.equals("E")){
//            dir = 1;
//        }
//        if(direction.equals("S")){
//            dir = 2;
//        }
//        if(direction.equals("W")){
//            dir = 3;
//        }
        
        return scenes[dirCounter].getNextLocation();
    }
    
    /**
     * Returns the direction that the player will face in the next location.
     * @param direction
     * @return 
     */
    public String getNextDirection(String direction){
        int dirCounter = 0;
        while(dirCounter <= 3){
            if(direction.equals(scenes[dirCounter].getDirection())){
                break;
            }else{
                dirCounter++;
            }
        }
//        if(direction.equals("N")){
//            dir = 0;
//        }
//        if(direction.equals("E")){
//            dir = 1;
//        }
//        if(direction.equals("S")){
//            dir = 2;
//        }
//        if(direction.equals("W")){
//            dir = 3;
//        }
        
        return scenes[dirCounter].getNextDirection();
    }
    
}
