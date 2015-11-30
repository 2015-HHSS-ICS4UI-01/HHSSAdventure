/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.util.Scanner;

/**
 *
 * @author janaj4926
 */
public class Locations {
    //name of the location
    private String place;
    //N, S, E, W, Scenes
    private Scenes[] scenes = new Scenes[4];
    
    //
    private Scenes getimage;
    private boolean isFrontBlocked;
    private String description;
    private Scenes nextLocation;
    //
    
    /**
     * makes the scenes
     * @param input 
     */
    public Locations(Scanner input) {
        place = input.nextLine();
        for (int i = 0; i < 4; i++) {
            Scenes s = new Scenes(input);
            scenes[i] = s;
        }
    }
    
    /**
     * gets the image in the direction im looking at
     * @param dir direction im facing
     * @return picture in the direction im facing
     */
    public BufferedImage getImage(String dir){
        if(dir.equals('N')){
            return scenes[0].getPic();
        }else if(dir.equals('E')){
            return scenes[1].getPic();
        }else if(dir.equals('S')){
            return scenes[2].getPic();
        }else if(dir.equals('W')){
            return scenes[3].getPic();
        }else{
            return null;
        }    
    }
    
    /**
     * can I move forward
     * @param dir the direction im facing
     * @return true or false
     */
    public boolean getIsFrontBlocked(String dir){
        if(dir.equals('N')){
            return scenes[0].isFrontBlocked();
        }else if(dir.equals('E')){
            return scenes[1].isFrontBlocked();
        }else if(dir.equals('S')){
            return scenes[2].isFrontBlocked();
        }else if(dir.equals('W')){
            return scenes[3].isFrontBlocked();
        }else{
            return false;
        }
    }
    
    
    /**
     * gets the description of the scene
     * @param dir which scene I'm looking at
     * @return description
     */
    public String getDescription(String dir){
        if(dir.equals('N')){
            return scenes[0].description();
        }else if(dir.equals('E')){
            return scenes[1].description();
        }else if(dir.equals('S')){
            return scenes[2].description();
        }else if(dir.equals('W')){
            return scenes[3].description();
        }else{
            return "";
        } 
    }
    
    /**
     * sees where to move to
     * @param dir which way I'm facing
     * @return next direction
     */
    public String getNextLocation(String dir){
       if(dir.equals('N')){
           return scenes[0].getNextLocation();
       }else if(dir.equals('E')){
           return scenes[1].getNextLocation();
       }else if(dir.equals('S')){
           return scenes[2].getNextLocation();
       }else if(dir.equals('W')){
           return scenes[3].getNextLocation();
       }else{
           return "";
       }
    }
    
    public String getNextDirection(String dir){
       if(dir.equals('N')){
           return scenes[0].getNextDir();
       }else if(dir.equals('E')){
           return scenes[1].getNextDir();
       }else if(dir.equals('S')){
           return scenes[2].getNextDir();
       }else if(dir.equals('W')){
           return scenes[3].getNextDir();
       }else{
           return "";
       }
    }
    
    public String getPlace(){
        return place;
    }
 
}

