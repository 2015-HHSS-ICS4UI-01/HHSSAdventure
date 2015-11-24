/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hhssadventure;

import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author rayan4858
 */
public class Scene{
    private String direction;
    private Scene[] Scenes;
    private String imageName;
    private String blocked;
    private String nextLocation;
    private String nextDirection;
    
    
    
    
    //constructor 
    public Scene(Scanner input){
          direction = input.next();
          imageName = input.next();
          blocked = input.next();
          if (blocked.equals("false")) {
            nextLocation = input.next();
            nextDirection = input.next();
          }else{
              input.nextLine();
          }

    } 
    
    
    public boolean frontBlocked( ){

    }
    
    
    
    public boolean nextLocation( ){
        //
    }
    
    
    
    public int getDirection(){
        //give the direction youre currently in
        //get the first letter in the file somehow
        return this.direction;
    }
    
    public void nextDirection(){
        //the fifth part of the line in the picture
    }
    
}
