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
    private String picture;
    private boolean blocked;
    
    
    public Scene(Scanner input){
        name = input.next();
        picture = input.next();
        direction = input.next();
        blocked = input.nextBoolean();
        
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
