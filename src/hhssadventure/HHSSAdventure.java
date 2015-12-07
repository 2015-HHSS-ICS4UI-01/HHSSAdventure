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
 * A game that allows a user to walk around Huron Heights Secondary School.
 * @author lamon
 */

public class HHSSAdventure {
    private ArrayList<Location> locations = new ArrayList<>();
    private UserInterface gui;
    //tracks the name of the current location
    private String currentLocation = null;
    //tracks the name of the current direction
    private String currentDirection = null;
    //array to hold all possible directions in the game
    private String[] directions;
    //tracks all information associated with the current location
    private Location currentLoc = null;
    
    /**
     * Constructor for the HHSSAdventure Game.
     */
    public HHSSAdventure(){
        //all possible directions in the game: north, east, south and west
        directions = new String[] {"N","E","S","W"};
        
        //reads in the text file with all game variables
        FileReader file = null;
        try{
            file = new FileReader("images/pics.txt");
        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        Scanner input = new Scanner(file);
        
        //assigns the starting location and direction of the user
        currentLocation = input.next();
        currentDirection = input.next();
        
        //adds all possible locations to the game
        while(input.hasNext()){
            Location l = new Location(input);
            locations.add(l);
        }
        
        //creates the graphical user interface, and adds all necessary info
        //including an image, a description, and whether user can move forward
        gui = new UserInterface(this);        
        for(int i = 0; i < locations.size(); i++){
            if(currentLocation.equals(locations.get(i).getName())){
                currentLoc = locations.get(i);
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
        //turns the user to the left of their current direction
        for(int i = 0; i < directions.length; i++){
            if(currentDirection.contains(directions[i])){
                if(currentDirection.contains("N")){
                    currentDirection = "W";
                    break;
                }else{
                    currentDirection = directions[i-1];
                    break;
                }
            }
        }
        //updates user interface
        gui.setDescription(currentLoc.getDescription(currentDirection));
        gui.setImage(currentLoc.getImage(currentDirection));  
        gui.setForward(currentLoc.isBlocked(currentDirection));
    }
    
    /**
     * Moves the user to the scene right of their current direction.
     */
    public void nextScene(){ 
        //turns the user to the right of their current direction
        for(int i = 0; i < directions.length; i++){
            if(currentDirection.contains(directions[i])){
                if(currentDirection.contains("W")){
                    currentDirection = "N";
                    break;
                }else{
                    currentDirection = directions[i+1];
                    break;
                }
            }
        }
        //updates user interface
        gui.setDescription(currentLoc.getDescription(currentDirection));
        gui.setImage(currentLoc.getImage(currentDirection));    
        gui.setForward(currentLoc.isBlocked(currentDirection));
    }
    
    /**
     * Moves the user to the location ahead of their current direction.
     */
    public void switchLocation(){        
        //sets current location to the new location
        currentLocation = currentLoc.getNextLocation(currentDirection);
        //sets current direction to the new direction
        currentDirection = currentLoc.getNextDirection(currentDirection);
        //grabs all information related to the new location
        for(int i = 0; i < locations.size(); i++){
            if(currentLocation.equals(locations.get(i).getName())){
                currentLoc = locations.get(i);
            }
        }

        //update the user interface
        gui.setDescription(currentLoc.getDescription(currentDirection));
        gui.setImage(currentLoc.getImage(currentDirection));  
        gui.setForward(currentLoc.isBlocked(currentDirection));
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //runs the game
        HHSSAdventure game = new HHSSAdventure();
                
    }
    
}
