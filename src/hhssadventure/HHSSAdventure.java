/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author lamon
 */

public class HHSSAdventure {

    private ArrayList<Location> locations = new ArrayList<>();
    private UserInterface gui;
    private String currentLocation;
    private String currentDirection;
    
    public HHSSAdventure(){        
        FileReader file = null;
        
        try{
            file = new FileReader("images/pics.txt");
        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        
        Scanner input = new Scanner(file);
        
        currentLocation = input.next();
        currentDirection = input.next();
        
        while(input.hasNext()){
            Location l = new Location(input);
            locations.add(l);
        }
        
        gui = new UserInterface(this);        
        Location currentLoc = null;
        for(int i = 0; i < locations.size(); i++){
            if(currentLocation.equals(locations.get(i).getName())){
                currentLoc = locations.get(i);
                break;
            }
        }
        gui.setDescription(currentLoc.getDescription(currentDirection));
        gui.setImage(currentLoc.getImage(currentDirection));
        gui.setForward(currentLoc.isBlocked(currentDirection));
        gui.setVisible(true);
    }
    
    /**
     * Moves the user to the scene left of their current direction.
     */
    public void prevScene(){
        if(currentDirection.equals("N")){
            currentDirection = "W";
        }
        else if(currentDirection.equals("W")){
            currentDirection = "S";
        }
        else if(currentDirection.equals("S")){
            currentDirection = "E";
        }
        else{
            currentDirection = "N";
        }
        
        Location currentLoc = null;
        for(int i = 0; i < locations.size(); i++){
            if(currentLocation.equals(locations.get(i).getName())){
                currentLoc = locations.get(i);
                break;
            }
        }
        gui.setDescription(currentLoc.getDescription(currentDirection));
        gui.setImage(currentLoc.getImage(currentDirection));
        gui.setForward(currentLoc.isBlocked(currentDirection));
    }
    
    /**
     * Moves the user to the scene right of their current direction.
     */
    public void nextScene(){
        if(currentDirection.equals("N")){
            currentDirection = "E";
        }
        else if(currentDirection.equals("E")){
            currentDirection = "S";
        }
        else if(currentDirection.equals("S")){
            currentDirection = "W";
        }
        else{
            currentDirection = "N";
        }
        
        Location currentLoc = null;
        for(int i = 0; i < locations.size(); i++){
            if(currentLocation.equals(locations.get(i).getName())){
                currentLoc = locations.get(i);
                break;
            }
        }
        gui.setDescription(currentLoc.getDescription(currentDirection));
        gui.setImage(currentLoc.getImage(currentDirection));
        gui.setForward(currentLoc.isBlocked(currentDirection));       
    }
    
    /**
     * Moves the user to the location forward of their current direction.
     * @param name the name of the new location.
     * @param direction the direction the user will face in the new location.
     */
    public void switchLocation(String name, String direction){
        currentLocation = name;
        currentDirection = direction;
        Location currentLoc = null;
        for(int i = 0; i < locations.size(); i++){
            if(currentLocation.equals(locations.get(i).getName())){
                currentLoc = locations.get(i);
                break;
            }
        } 
        gui.setDescription(currentLoc.getDescription(currentDirection));
        gui.setImage(currentLoc.getImage(currentDirection));
        gui.setForward(currentLoc.isBlocked(currentDirection));
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HHSSAdventure game = new HHSSAdventure();
        
    }
    
}
