/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.Scanner;

/**
 *
 * @author janaj4926
 */
public class Locations {
    private String place;
    private Scenes[] scenes = new Scenes[4];
    private Scenes getimage;
    private boolean isFrontBlocked;
    private String description;
    private Scenes nextLocation;
    
    //making scenes
    public Locations(Scanner input) {
        place = input.nextLine();
        for (int i = 0; i < 4; i++) {
            Scenes s = new Scenes(input);
            scenes[i] = s;
        }
    }
    
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
    
    public String getPlace(String p){
        return place;
    }
    
    public String getDirection(String p){
        return p;
    }
}

