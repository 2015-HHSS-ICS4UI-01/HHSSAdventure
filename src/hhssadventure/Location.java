/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.util.Scanner;

/**
 *
 * @author yaol9270
 */
public class Location {
    private int numLocation;
    private Location[] locationlocation;
    private String name;
    private String direction;
    
    
    public Location(Scanner input){
        name = input.nextLine();
        direction = input.nextLine();
        
        for(int i = 0; i < numLocation; i ++){
            Location l = new Location(input);
            
            locationlocation[i] = l;
        }
        
    }
    
    
    public void getImage(String dir){
        return Scene.picture();
    }
    
    public void isFrontBlocked(String dir){
        
    }
    
    public void getDescription(String dir){
        
    }
    
    public void NextLocation(String dir){
        
    }
}
