/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author naylj6470
 */
public class Location {
    
    private Scene[] scenes = new Scene[3];
    private String name;
    
    public BufferedImage getImage(char dir){
        for(int i = 0; i < 4; i++){
            if(dir == scenes[i].getDirection()){
                return scenes[i].getPhoto();
            }
        }
    }
    
    public boolean isFrontBlocked(char dir){
        return true;
    }
    public String getDescription(Scene dir){
        
    }
    public Location getNextLocation(Scene dir){
        
    }
    
    
}
