/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author lamon
 */
public class HHSSAdventure {

    /**
     * @param args the command line arguments
     */
    private ArrayList<Location> location = new ArrayList<>();
    private String currentLocation;
    private String currentDir;
    private UserInterface gui;
    private Location Location;
    private Scene Scene;

    public HHSSAdventure() {
        //read the text file
        FileReader file = null;
        try {
            file = new FileReader("images/pics.txt");


        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        //initialize the scanner
        Scanner input = new Scanner(file);
        //read the starting location, set it
        String startingLocation = input.nextLine();
        //read the starting direction, set it
        String startingDirection = input.nextLine();

        //when there is more locations, add it to the list of locations
        while (input.hasNext()) {
            Location l = new Location(input);
            location.add(l);
        }
        
        //set the current location and direction to the starting location
        currentDir = startingDirection;
        currentLocation = startingLocation;
        Location = getLocation();
        //going through to find the actual location
        
        //draw everything
        gui = new UserInterface(this);
        gui.setVisible(true);
        gui.description(Location.getLocation());
        gui.displayPicture(Location.getImage(currentDir));
    }

    /**
     * find the location 
     * @return the location
     */
    public Location getLocation() {
        
        int i = 0;

        while (i < location.size()) {

            if (!location.get(i).getLocation().equals(currentLocation)) {
                i++;
            }else{
                
                break;
            }
        }
        return location.get(i);
        
    }

    
    /**
     * Moves forward
     */
    public void forward() {
        //if front is not blocked
        if (!Location.isFrontBlocked(currentDir)) {
            
            //set current location to the next location specified for the current direction
            currentLocation = Location.NextLocation(currentDir);
            //set current direction to the next scene's direction
            currentDir = Scene.nextDirection();
            
            //going through to find the actual location
            Location = getLocation();
            //draw stuff
            gui.displayPicture(Location.getImage(currentDir));
            Scene = Location.getScene(currentDir);
            gui.description(Location.getLocation());
        }


    }

    /**
     * Turns right
     */
    public void turnRight() {
        //change the current direction to shift right
        if (currentDir.equals("N")) {
            currentDir = "E";
        } else if (currentDir.equals("E")) {
            currentDir = "S";
        } else if (currentDir.equals("S")) {
            currentDir = "W";
        } else if (currentDir.equals("W")) {
            currentDir = "N";
        }
        //draw stuff
        gui.displayPicture(Location.getImage(currentDir));
        Scene = Location.getScene(currentDir);
        gui.description(Location.getLocation());
    }

    /**
     * Turns left
     */
    public void turnLeft() {
        //change the current direction to shift left
        if (currentDir.equals("N")) {
            currentDir = "W";
        } else if (currentDir.equals("W")) {
            currentDir = "S";
        } else if (currentDir.equals("S")) {
            currentDir = "E";
        } else if (currentDir.equals("E")) {
            currentDir = "N";
        }
        
        //draw stuff
        gui.displayPicture(Location.getImage(currentDir));
        Scene = Location.getScene(currentDir);
        gui.description(Location.getLocation());
    }

    public static void main(String[] args) {

        HHSSAdventure game = new HHSSAdventure();


    }
}

