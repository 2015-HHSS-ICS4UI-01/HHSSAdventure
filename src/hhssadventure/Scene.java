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
    
    private String direction;
    private String image;
    private String isBlocked;
    private boolean blocked;
    private String nextLocation;
    private String nextDirection;
    
    public Scene(Scanner input){
       
        direction = input.next();
        image = input.next();
        isBlocked = input.next();
        if(isBlocked.equals("true")){
            blocked = true;
            input.nextLine();
        }else if(blocked == false){
        nextLocation = input.next();
        nextDirection = input.next();
        input.nextLine();
      }
  
   }
     
    public String getDirection(){
            return this.direction;
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
