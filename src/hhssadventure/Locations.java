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
    private String name;

    private Scenes[] scenes;
    
    
    Locations(Scanner input) {
        for(int i = 0; i < scenes.length; i++){
            scenes[i] = input.next();
        }
    }
      
    public void getImage(){
        
    public Locations(Scanner input) {
        name = input.nextLine();
        for (int i = 0; i < 4; i++) {
            Scenes s = new Scenes(input);
            scenes[i] = s;
        }
    }
    
    public BufferedImage getImage(int dir){
        
    }
            
    public boolean isFrontBlocked(int dir){
        
    }
    
    public String getDescription(int dir){
        
    }
    
    public String nextLocation(int dir){
        
    }
}

