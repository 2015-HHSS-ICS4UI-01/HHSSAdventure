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
    private ArrayList<Location> locations = new ArrayList<Location>();
    private String currentLocation;
    private String currentDirection;
    private UserInterface gui;
    private int locationNumber = 0;
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HHSSAdventure f = new HHSSAdventure();
        
    }

    public HHSSAdventure(){

        //used to help read a file
        FileReader file = null;
        try {
            file = new FileReader("images/pics.txt");
        } catch (Exception e) {
            //prints out error message
            e.printStackTrace();
            //stops the program
            System.exit(0);
        }
        
        Scanner reader = new Scanner(file); 
        
        currentLocation = reader.nextLine();
        currentDirection = reader.nextLine();
        
        
        //keep scanning as long as theres something to scan
        while (reader.hasNext()) {
            //adding a class from the file
            Location a = new Location(reader);
            //addint the class to the list
            locations.add(a);
        }
        
        gui = new UserInterface(this);
        //set the text for the class name
        
        gui.setLocationName(currentLocation);
        gui.setDirection(this.Direction(currentDirection));
        
        //showing the image the person is at
        gui.showImage(this.getLocation(currentLocation).getSceneImage(currentDirection).getImage());
        //show it
        gui.setVisible(true);
        
    }
    
    
    public void right(){
        //check direction is null
        if (currentDirection != null) {
            //reassign the directions based on right turn
            if (currentDirection.equals("N")) {
                currentDirection = "E";
            } else if (currentDirection.equals("E")) {
                currentDirection = "S";
            } else if (currentDirection.equals("S")) {
                currentDirection = "W";
            } else if (currentDirection.equals("W")) {
                currentDirection = "N";
            }
            //reset the visible direction
            gui.setDirection(this.Direction(currentDirection));
            //reset the picture
            gui.showImage(this.getLocation(currentLocation).getSceneImage(currentDirection).getImage());
        }
    }
    
    public void left(){
           //same as right turn except based on left turn
        if (currentDirection != null) {
            if (currentDirection.equals("N")) {
                currentDirection = "W";
            } else if (currentDirection.equals("E")) {
                currentDirection = "N";
            } else if (currentDirection.equals("S")) {
                currentDirection = "E";
            } else if (currentDirection.equals("W")) {
                currentDirection = "S";
            }
            gui.setDirection(this.Direction(currentDirection));
            gui.showImage(this.getLocation(currentLocation).getSceneImage(currentDirection).getImage());
        }
    }
    
    public void forward(){
        //check if player is able to move forward 
        if (this.getLocation(currentLocation).getSceneImage(currentDirection).frontBlocked()){
            //temp direction
            String d = currentDirection;
            //direction is equal to next direction
            currentDirection = this.getLocation(currentLocation).getSceneImage(d).nextDirection();
            //location is equal to next location
            currentLocation = this.getLocation(currentLocation).getSceneImage(d).nextLocation();

            //reset visible direction
            gui.setDirection(this.Direction(currentDirection));
            //reset visible location
            gui.setLocationName(currentLocation);
            //reset picture
            gui.showImage(this.getLocation(currentLocation).getSceneImage(currentDirection).getImage());
        }
       
    }
        
    public String Direction(String d) {
        if (d.equals("N")) {
            d = "North";
        } else if (d.equals("S")) {
            d = "South";
        } else if (d.equals("E")) {
            d = "East";
        } else if (d.equals("W")) {
            d = "West";
        }

        return d;
    }
    
    public Location getLocation(String name){
        int i = 0;
        while (i < 3 && !name.equals(locations.get(i).getDesciption())) {
            i++;
        }
        return locations.get(i);
    }
}
