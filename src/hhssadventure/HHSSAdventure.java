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

    /**
     * @param args the command line arguments
     */
    
    private ArrayList<Location> locations = new ArrayList<>();
    
    
    private String currentDirection;
    private String currentLocation;
    private Interface gui;
    
    public HHSSAdventure() {
        
        //the file reader
        FileReader file = null;

        try {
            file = new FileReader("images/pics.txt");

        } catch (Exception e) {
            e.printStackTrace();
        }

        Scanner input = new Scanner(file);
        //getting the starting locations
        currentLocation = input.nextLine();
        currentDirection = input.nextLine();
        //adding the locations into the array
          while(input.hasNext())
          {
             Location s = new Location(input);
              
             locations.add(s);
          }
      
        
        
        
         
        
        //setting up the interface
        gui = new Interface(this);
        gui.setVisible(true);
        gui.setLocation(currentLocation);
        gui.setDirection(currentDirection); 
       
        
        
        //setting the image on the interface to the starting location
        for(Location l : locations){
           
            if(l.getName().equals(currentLocation)){
                gui.setImage(l.getImage(currentDirection));
            }
        }
    }
    /**
     * Creating a method to be able to turn left on the interface
     */
    public void turnLeft(){
        //A for loop to go through all of the locations in the locations array
        for (Location l : locations){
            //when the location matches location "l" the if statement will run
            if (l.getName().equals(currentLocation)){
                //The if statments below checks the current direction and when the directions match the direction will change as if you turned left
                //When the direction is changed the picture on the interface will change as well as the direction that is displayed on the interface
             if (currentDirection.equals("N")){
               currentDirection = "W";
               gui.setImage(l.getImage(currentDirection));
               gui.setDirection(currentDirection); 
            }else if (currentDirection.equals("W")){
                currentDirection = "S";
                gui.setDirection(currentDirection);
               gui.setImage(l.getImage(currentDirection));
            } else if (currentDirection.equals("S")){
                currentDirection = "E";
                gui.setDirection(currentDirection);
               gui.setImage(l.getImage(currentDirection));
            } else if (currentDirection.equals("E")){
                currentDirection = "N";
                gui.setDirection(currentDirection);
               gui.setImage(l.getImage(currentDirection));
            }
          }
        }
    }
    /**
     * The turnRight method works the same as the turn left method just the diections are switched to correspond with turning right.
     */
    public void turnRight(){
        for (Location l : locations){
            if(l.getName().equals(currentLocation)){
            if (currentDirection.equals("N")){
                currentDirection = "E";
                gui.setImage(l.getImage(currentDirection));
                gui.setDirection(currentDirection);
            }else if (currentDirection.equals("E")){
                currentDirection = "S";
                gui.setDirection(currentDirection);
               gui.setImage(l.getImage(currentDirection));
            } else if (currentDirection.equals("S")){
                currentDirection = "W";
                gui.setDirection(currentDirection);
               gui.setImage(l.getImage(currentDirection));
            } else if (currentDirection.equals("W")){
                currentDirection = "N";
                gui.setDirection(currentDirection);
               gui.setImage(l.getImage(currentDirection));
            }
            }
        }
    }
    /**
     * The go forward method allows the player to move forward to continue moving down the hallway. If the way is not blocked.
     */
    public void goForward(){
        //To go through all the locations
         for (Location l : locations){
             //When the location for the for loop matches the current location
             if(l.getName().equals(currentLocation)){
                 //It checks the if the way infront is blocked
                 if(l.isFrontBlocked(currentDirection) == false){
                     //If the way is not blocked the picture will move forward
                     
                     currentLocation = l.getNextLocation(currentDirection);
                     gui.setLocation(currentLocation);
                     //If the way is blocked the game lets the user know that the way forward is blocked
                 }else{
                     System.out.println("The way is blocked");
                 }
             }
         }
         //The location will be updated to show the picture at their current location.
         for(Location l : locations){
             if(l.getName().equals(currentLocation)){
                 gui.setImage(l.getImage(currentDirection));
                 gui.setDirection(currentDirection);
             }
         }
         
    }
    
    
    public static void main(String[] args) {
        HHSSAdventure game = new HHSSAdventure();
    }
}
