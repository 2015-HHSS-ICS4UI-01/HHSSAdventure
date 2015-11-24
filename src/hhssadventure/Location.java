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

    private Scene[] scenes;
    private String name;
    private String direction;
    
    
    public Location(Scanner input){
        name = input.nextLine();
        direction = input.nextLine();
        scenes = new Scene[4];
        
        for(int i = 0; i < 4; i ++){
            Scene s = new Scene(input);
            
            scenes[i] = s;
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
