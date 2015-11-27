/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.util.Scanner;

/**
 *
 * @author isles3536
 */
public class Location {
    private Scene[] scenes;
    private String name;

    
    
    public Location(Scanner input){
        
        scenes = new Scene[3];
        
        name = input.nextLine();
        for (int i = 0; i < 3; i++){
         Scene s = new Scene(input);
         scenes[i] = s;
        } 
        input.nextLine();
        
        
    }
    
    
    public boolean isFrontBlocked(String dir){
        return true;
    }
    
    public String getNextLocation(String dir){
        for(int i = 0; i < 3; i++){
            if(scenes[i].getDirection().equals(dir)){
                return scenes[i].getNextLocation();
            }
        }
        return "";
    }
    
    
  
    
    public String name(){
        return this.name;
    }
    
    
    
}
