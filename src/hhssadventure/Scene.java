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
public class Scene {
    private String direction;
    private String name;
    private String place;
    private String picture;
    private String next;
    private String nextDirection;
    private boolean blocked;
    
    
    public Scene(Scanner input){
        name = input.nextLine();
        place = input.nextLine();
        for(int i = 0; i < 4; i++){
            direction = input.next();
            picture = input.next();
            blocked = input.nextBoolean();
            if(blocked == false){
                next = input.next();
                nextDirection = input.next();
            }
        }
        
        
    }
    
    
    public void picture(){
        direction();
    }
    
    public void direction(){
        
    }
    
    public boolean frontBlocked(){
        return this.blocked;
    }
    
    public String nextLocation(){
        
    }
    
    public String description(){
        return this.name;
    }
    
    public void nextDirection(){
        
    }
    
    
}
