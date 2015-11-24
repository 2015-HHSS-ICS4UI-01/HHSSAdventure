/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.image.BufferedImage;
import java.util.Scanner;

/**
 *
 * @author yaol9270
 */
public class Location {

    private Scene[] scenes;
    private String name;
    private String direction;
    private int dirNum;
    
    
    public Location(Scanner input){
        name = input.nextLine();
        direction = input.nextLine();
        scenes = new Scene[4];
        
        for(int i = 0; i < 4; i ++){
            Scene s = new Scene(input);
            
            scenes[i] = s;
        }
        
    }
    
    
    public BufferedImage getImage(String dir){
        if(dir == "N"){
            dirNum = 0;
        }
        else if(dir == "E"){
            dirNum = 1;
        }
        else if(dir == "S"){
            dirNum = 2;
        }
        else if(dir == "W"){
            dirNum = 3;
        }
        return scenes[dirNum].picture();
    }
    
    public boolean isFrontBlocked(String dir){
        if(dir == "N"){
            dirNum = 0;
        }
        else if(dir == "E"){
            dirNum = 1;
        }
        else if(dir == "S"){
            dirNum = 2;
        }
        else if(dir == "W"){
            dirNum = 3;
        }
        return scenes[dirNum].frontBlocked();
    }
    
    public String getDescription(String dir){
        if(dir == "N"){
            dirNum = 0;
        }
        else if(dir == "E"){
            dirNum = 1;
        }
        else if(dir == "S"){
            dirNum = 2;
        }
        else if(dir == "W"){
            dirNum = 3;
        }
        return scenes[dirNum].description();
    }
    
    public String NextLocation(String dir){
        if(dir == "N"){
            dirNum = 0;
        }
        else if(dir == "E"){
            dirNum = 1;
        }
        else if(dir == "S"){
            dirNum = 2;
        }
        else if(dir == "W"){
            dirNum = 3;
        }
        return scenes[dirNum].nextLocation();
    }
}
