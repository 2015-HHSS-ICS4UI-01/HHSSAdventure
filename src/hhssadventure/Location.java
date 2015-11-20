/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.util.ArrayList;

/**
 *
 * @author naylj6470
 */
public class Location {
    
    private ArrayList<Scene> scenes = new ArrayList<>();
    private String name;
    
    //public getImage(dir)
    
    public boolean isFrontBlocked(char dir){
        return true;
    }
    public String getDescription(Scene dir){
        
    }
    public Location getNextLocation(Scene dir){
        
    }
    
    
}
