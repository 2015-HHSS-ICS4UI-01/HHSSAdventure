/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.util.Scanner;

/**
 *
 * @author rayan4858
 */
public class Location {
    private String locationName;
    private Scene[] scenes; 
    
    
    
    public Location(Scanner input){
        locationName = input.nextLine();
        
        scenes = new Scene[3];
        for (int i = 0; i < 4; i++) {
            Scene s = new Scene(input);
            s[i] = input.next();
        }
        
    }
    

    public void getImage(){
        
    }
    
    public boolean isFrontBlocked(){
        
    }
    
    public String getDesciption(){
       
    }
    
    public void getNextDirection(){
        
    }
}
