/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.util.Scanner;

/**
 *
 * @author paulm6438
 */
public class Location {

    private String name;
    private Scene[] scenes;

    public Location(Scanner input) {
        name = input.nextLine();
        
        scenes = new Scene[3];
        
        for (int i = 0; i < 3; i++) {

            Scene s = new Scene(input);

            scenes[i] = s;
        }

    }
    
    public String getImage(){
        return this.image;
    }
   
    public boolean getIsFrontBlocked(){
        return this.isFrontBlocked;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public String getNextLocation(){
        return this.nextLocation;
    }
    
}
