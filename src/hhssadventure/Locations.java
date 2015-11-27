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
    
    //
    public BufferedImage getImage(){
        return getimage.getPic();
    }
            
    public boolean getIsFrontBlocked(){
        return isFrontBlocked;
    }
    
    public String getDescription(){
        return description;
    }
    
    public String getNextLocation(){
        return nextLocation.getNextLocation();
    }
    
    public String getPlace(String p){
        return "";
    }
    
    public String getNextDirection
}

