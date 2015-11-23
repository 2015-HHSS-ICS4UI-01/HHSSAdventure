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
    private boolean isFrontBlocked;
    private String getNextLocation;
    
    
    public Location(Scanner input){
        input.nextLine();
        input.nextLine();
        name = input.nextLine();
        input.nextLine();
        String check = input.next();
        if (check.equals("false")){
            isFrontBlocked = false;
            getNextLocation = input.nextLine();
        } else {
            isFrontBlocked = true;
            input.nextLine();
        }
        
        scenes = new Scene[3];
        for (int i = 0; i < 3; i++){
         Scene s = new Scene(input);
         scenes[i] = s;
        }
        
        
    }
    
    
    public boolean isFrontBlocked(){
        return this.isFrontBlocked;
    }
    
    public String getNextLocation(){
        return this.getNextLocation;
    }
    
    public String name(){
        return this.name;
    }
    
    
    
}
