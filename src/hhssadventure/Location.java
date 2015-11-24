/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author naylj6470
 */
public class Location {
    
    private Scene[] scenes = new Scene[3];
    private String name;
    
    public Location(Scanner constructor){
        name = constructor.nextLine();
        for(int i = 0; i < 4; i++){
            Scene s = new Scene(constructor);
            scenes[i] = s;
            s.setDescription(name + s.getDirection());
        }
    }
    
    public BufferedImage getImage(Scene c){
        return c.getPhoto();
    }
    
    public boolean isFrontBlocked(char dir){
        return true;
    }
    

    
    
}
