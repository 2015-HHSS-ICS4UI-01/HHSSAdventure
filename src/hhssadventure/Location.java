/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.image.BufferedImage;
import java.util.Scanner;

/**
 *
 * @author yaol9270
 */
public class Location {

    private Scene[] scenes;
    private String name;
    private String direction;
    private int dirNum;
    
    /**
     * the location (and its 4 scenes)
     * @param input the scanner to read text file
     */
    public Location(Scanner input){
        //acquire the name of the location
        name = input.nextLine();
        //make an array to store the 4 scenes in that location (for the 4 directions)
        scenes = new Scene[4];

        
        for(int i = 0; i < 4; i ++){
            Scene s = new Scene(input);
            
            scenes[i] = s;
        }
        
    }
    
    /**
     * gets the image
     * @param dir the direction
     * @return the picture
     */
    public BufferedImage getImage(String dir){
        if(dir.equals("N")){
            dirNum = 0;
        }
        else if(dir.equals("E")){
            dirNum = 1;
        }
        else if(dir.equals("S")){
            dirNum = 2;
        }
        else if(dir.equals("W")){
            dirNum = 3;
        }
        return scenes[dirNum].picture();
    }
    
    /**
     * sees if front is blocked
     * @param dir the direction
     * @return if the front is blocked (false = no, true = yes)
     */
    public boolean isFrontBlocked(String dir){
        if(dir.equals("N")){
            dirNum = 0;
        }
        else if(dir.equals("E")){
            dirNum = 1;
        }
        else if(dir.equals("S")){
            dirNum = 2;
        }
        else if(dir.equals("W")){
            dirNum = 3;
        }
        return scenes[dirNum].frontBlocked();
    }
    
    /**
     * gets the location name
     * @return the location name
     */
    public String getLocation(){
        return this.name;
    }
    
    /**
     * gets the scene
     * @param dir the direction
     * @return the scene associated with that direction
     */
    public Scene getScene(String dir){
        if(dir.equals("N")){
            dirNum = 0;
        }
        else if(dir.equals("E")){
            dirNum = 1;
        }
        else if(dir.equals("S")){
            dirNum = 2;
        }
        else if(dir.equals("W")){
            dirNum = 3;
        }
        return scenes[dirNum];
    } 
    
    /**
     * gets the description 
     * @param dir the direction
     * @return the description of that scene
     */
    public String getDescription(String dir){
        if(dir.equals("N")){
            dirNum = 0;
        }
        else if(dir.equals("E")){
            dirNum = 1;
        }
        else if(dir.equals("S")){
            dirNum = 2;
        }
        else if(dir.equals("W")){
            dirNum = 3;
        }
        return scenes[dirNum].description();
    }
    
    /**
     * gets the next location
     * @param dir the direction
     * @return the next location
     */
    public String NextLocation(String dir){
        if(dir.equals("N")){
            dirNum = 0;
        }
        else if(dir.equals("E")){
            dirNum = 1;
        }
        else if(dir.equals("S")){
            dirNum = 2;
        }
        else if(dir.equals("W")){
            dirNum = 3;
        }
        return scenes[dirNum].nextLocation();
    }
}
