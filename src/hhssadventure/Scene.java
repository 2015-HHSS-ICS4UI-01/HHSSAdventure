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
    private String image;
    private boolean blocked;
    private String nextLocation;
    private String nextDirection;
    
    public Scene(Scanner input){
      
                
        name = input.nextLine();
        input.nextLine();
        direction = input.next();
        image = input.next();
        if(direction.equals("true")){
            blocked = true;
            input.nextLine();
        }else{
        nextLocation = input.next();
        nextDirection = input.next();
        input.nextLine();
      }
  
   }
     
    public String getDirection(){
            return this.direction;
        }
    
    public String getName(){
        return this.name;
    }
    
    public String getImage(){
        return this.image;
    }
    
    public boolean isBlocked(){
        return this.blocked;
    }
    
    public String getNextLocation(){
        return this.nextLocation;
    }
    
    public String getNextDirection(){
        return this.nextDirection;
    }
    
    
}
