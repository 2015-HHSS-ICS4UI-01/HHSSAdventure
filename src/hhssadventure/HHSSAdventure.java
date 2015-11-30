/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.image.BufferedImage;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lamon
 */
public class HHSSAdventure {

    //an array list to store classes
    //just like our list ADT lessons
    private ArrayList<Location> locations = new ArrayList<>();
    private Interface gui;
    private Location storedLocation;
    private String[] compass = {"N", "E", "S", "W"};
    public String currentLocation = null;
    public String currentDirection = null;

    public HHSSAdventure() {
        //used to help read a file
        FileReader file = null;
        try {
            file = new FileReader("images/pics.txt");
        } catch (Exception e) {
            //prints out the error message
            e.printStackTrace();
            //stops the program
            System.exit(0);
        }

        //creates a scanner to read the file
        Scanner input = new Scanner(file);

        //read the starting location and direction
        currentLocation = input.nextLine();
        currentDirection = input.nextLine();

        while (input.hasNext()) {
            Location l = new Location(input);

            locations.add(l);
        }

        for (int i = 0; i < locations.size(); i++) {
            if (currentLocation.equals(locations.get(i).getName())) {
                storedLocation = locations.get(i);
            }
        }
        
        gui = new Interface(this);

        gui.setDescription(storedLocation.getSceneDescription(this.currentDirection));
        gui.setImage(getImage());


        gui.setVisible(true);

    }

    public void turnRight() {
        if (currentDirection.equals("W")) {
            currentDirection = "N";
        } else {
            for (int i = 0; i < compass.length; i++) {
                if (compass[i].equals(currentDirection)) {
                    currentDirection = compass[i + 1];

                    break;
                }
            }

            for (int i = 0; i < locations.size(); i++) {
                if (currentLocation.equals(locations.get(i).getName())) {
                    storedLocation = locations.get(i);
                }

            }
        }
        
        gui.setDescription(storedLocation.getSceneDescription(this.currentDirection));
        gui.setImage(getImage());
        
    }

    public void turnLeft() {
        if (currentDirection.equals("N")) {
            currentDirection = "W";
        } else {
            for (int i = 0; i < compass.length; i++) {
                if (compass[i].equals(currentDirection)) {
                    currentDirection = compass[i - 1];

                    break;
                }
            }

            for (int i = 0; i < locations.size(); i++) {
                if (currentLocation.equals(locations.get(i).getName())) {
                    storedLocation = locations.get(i);
                }

            }
        }
        gui.setDescription(storedLocation.getSceneDescription(this.currentDirection));
        gui.setImage(getImage());
      
    }

    public void advance() {
    
        if (!storedLocation.isFrontBlocked(currentDirection)) {
            currentLocation = storedLocation.getSceneNextLocation(currentDirection);
            currentDirection = storedLocation.getSceneNextDirection(currentDirection);
            
            
            for (int i = 0; i < locations.size(); i++) {
                if (currentLocation.equals(locations.get(i).getName())) {
                    storedLocation = locations.get(i);
                }
            }
            
            gui.setDescription(storedLocation.getSceneDescription(this.currentDirection));
            
            gui.setImage(getImage());
        }
    }
    
    public BufferedImage getImage(){
        return storedLocation.getSceneImage(currentDirection);
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // I changed the comment!!!!
        //currentDir
        //Locations[]
        //currentLocation
        //switchLocation(name,direction)

        HHSSAdventure f = new HHSSAdventure();
    }
}
