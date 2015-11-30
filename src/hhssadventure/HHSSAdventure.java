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

    /**
     * Constructor for the game (HHSSAdventure)
     */
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

        //read each location
        while (input.hasNext()) {
            Location l = new Location(input);
            //add each location to the location ArrayList
            locations.add(l);
        }

        //find the starting location in the ArrayList
        for (int i = 0; i < locations.size(); i++) {
            if (currentLocation.equals(locations.get(i).getName())) {
                //sets storedLocation to be the starting location
                storedLocation = locations.get(i);
            }
        }

        //creates the interface and sets the starting information
        gui = new Interface(this);
        gui.setDescription(storedLocation.getSceneDescription(this.currentDirection));
        gui.setImage(getImage());
        gui.setVisible(true);
    }

    /**
     * Changes the direction the player is facing to the right
     */
    public void turnRight() {
        //special case for direction being at the end of the compass array
        if (currentDirection.equals("W")) {
            currentDirection = "N";
        } else {
            //changes the direction to be the next direction in the compass
            for (int i = 0; i < compass.length; i++) {
                if (compass[i].equals(currentDirection)) {
                    currentDirection = compass[i + 1];
                    break;
                }
            }
        }
        //changes the image and description displayed in the interface
        gui.setDescription(storedLocation.getSceneDescription(this.currentDirection));
        gui.setImage(getImage());
    }

    /**
     * Changes the direction the player is facing to the left
     */
    public void turnLeft() {
        //special case for direction being at the end of the compass array
        if (currentDirection.equals("N")) {
            currentDirection = "W";
        } else {
            //changes the direction to be the previous direction in the compass
            for (int i = 0; i < compass.length; i++) {
                if (compass[i].equals(currentDirection)) {
                    currentDirection = compass[i - 1];
                    break;
                }
            }
        }
        //changes the image and description displayed in the interface
        gui.setDescription(storedLocation.getSceneDescription(this.currentDirection));
        gui.setImage(getImage());
    }

    /**
     * Changes the location and direction of the player
     */
    public void advance() {
        //check that the player can move forward
        if (!storedLocation.isFrontBlocked(currentDirection)) {
            //change our location and direction to the next one
            currentLocation = storedLocation.getSceneNextLocation(currentDirection);
            currentDirection = storedLocation.getSceneNextDirection(currentDirection);

            //changes the storedLocation to be the new location
            for (int i = 0; i < locations.size(); i++) {
                if (currentLocation.equals(locations.get(i).getName())) {
                    storedLocation = locations.get(i);
                }
            }
            //changes the image and description displayed in the interface
            gui.setDescription(storedLocation.getSceneDescription(this.currentDirection));
            gui.setImage(getImage());
        }
    }

    /**
     * Getter for the image
     * @return the image stored in the specified scene
     */
    public BufferedImage getImage() {
        return storedLocation.getSceneImage(currentDirection);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       

        HHSSAdventure f = new HHSSAdventure();
    }
}
