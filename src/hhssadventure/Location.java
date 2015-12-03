/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;


import java.util.Scanner;

/**
 *
 * @author rayan4858
 */
public class Location {
    private String locationName;
    private Scene[] scenes; 
    private String nextLocation;
    
    
    public Location(Scanner input){
        locationName = input.nextLine();
        System.out.println(locationName);
        
        scenes = new Scene[4];
        for (int i = 0; i < 4; i++) {
            //creats a scene
            Scene s = new Scene(input);
            //puts scene in the list
            scenes[i] = s;
            
//            System.out.println(scenes[i].getDirection());
//            System.out.println(scenes[i].frontBlocked());
//            System.out.println(scenes[i].nextLocation());
//            System.out.println(scenes[i].nextDirection());
//            System.out.println("");
            
        }
    }
    

    public Scene getSceneImage(String sceneDirection){
        int i = 0;
        while(i < 3 && scenes[i].getDirection() != sceneDirection) {
            i++;
        }
        return scenes[i];
    }
    
    public String getDesciption(){
       return this.locationName;
    }
    
    
}
