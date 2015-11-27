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
    private BufferedImage image;
    private boolean isFrontBlocked;
    private String description;
    private Scenes nextLocation;
    
    
    public Locations(Scanner input) {
        place = input.nextLine();
        for (int i = 0; i < 4; i++) {
            Scenes s = new Scenes(input);
            scenes[i] = s;
        }
    }
    
    public BufferedImage getImage(String dir){
        return image;
    }
            
    public boolean getIsFrontBlocked(String dir){
        return isFrontBlocked;
    }
    
    public String getDescription(String dir){
        return description;
    }
    
    public String getNextLocation(String dir){
       if(dir.equals('N')){
           return scenes[0].getNextLocation();
       }

    }
    
    public String getPlace(String p){
        return "";
    }
}

