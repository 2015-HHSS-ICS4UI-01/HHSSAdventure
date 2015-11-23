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
    private String description;
    
    
    public Location(Scanner input){
        name = input.nextLine();
        
        scenes = new Scene[3];
        
    }
    
    
    
    public String getDesctription(){
        return description;
    }
}
