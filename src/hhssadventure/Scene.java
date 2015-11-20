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
public class Scene {
    private String name;
    private String direction;
    private String decrip;
    private boolean blocked;
    private String nextLocation;
    private String nextDirection;
    
    public Scene(Scanner input){
        name = input.nextLine();
        direction = input.nextLine();
        
        if(input.nextLine() == "true"){
            blocked = true;
        }
        nextLocation = input.nextLine();
        nextDirection = input.nextLine();
        
    }
    
                
    
}
