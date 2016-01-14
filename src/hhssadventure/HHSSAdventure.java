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

    //initialize the array that will contain all the locations
    private ArrayList<Location> locations = new ArrayList<Location>();
    //the current location the user is in
    private String currentLocation;
    //the current direction the user is facing
    private String currentDirection;
    //initialize the interface
    private UserInterface gui;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HHSSAdventure f = new HHSSAdventure();
    }

    //constructor
    public HHSSAdventure() {
        //give it the file to read
        FileReader file = null;
        try {
            file = new FileReader("images/pics.txt");
        } catch (Exception e) {
            //prints out error message
            e.printStackTrace();
            //stops the program
            System.exit(0);
        }
        //give the scanner the file
        Scanner reader = new Scanner(file);

        //read in the first two lines of the file which will be the current location and direction
        currentLocation = reader.nextLine();
        currentDirection = reader.nextLine();

        //keep scanning as long as theres something to scan
        while (reader.hasNext()) {
            //adding a class from the file
            Location a = new Location(reader);
            //addint the class to the list
            locations.add(a);
        }
        //give this to the interface
        gui = new UserInterface(this);
        gui.setVisible(true);
        //set the text for the class name
        gui.setLocationName(currentLocation);
        //set the direction
        gui.setDirection(this.Direction(currentDirection));
        //showing the image the person is at
        gui.showImage(this.getLocation(currentLocation).getSceneImage(currentDirection).getImage());
    }

    /**
     * the move right controls
     */
    public void right() {
        //check to see if there is something for the current direction
        if (currentDirection != null) {
            //if the current direction is north
            if (currentDirection.equals("N")) {
                //change the direction to east
                currentDirection = "E";
                //if the current direction is east
            } else if (currentDirection.equals("E")) {
                //change the direction to south
                currentDirection = "S";
                //if the current direction is south
            } else if (currentDirection.equals("S")) {
                //change the direction to west
                currentDirection = "W";
                //if the current direction is west
            } else if (currentDirection.equals("W")) {
                //change the direction to north
                currentDirection = "N";
            }
            
            //the new assigned direction is the current direction
            gui.setDirection(this.Direction(currentDirection));
            //show the corresponding picture
            gui.showImage(this.getLocation(currentLocation).getSceneImage(currentDirection).getImage());
        }
    }

    /**
     * the move left controls
     */
    public void left() {
        //check to see if there is something for the current direction
        if (currentDirection != null) {
            //if the current direction is north
            if (currentDirection.equals("N")) {
                //change the direction to west
                currentDirection = "W";
                //if the current direction is east
            } else if (currentDirection.equals("E")) {
                //change the direction to north
                currentDirection = "N";
                //if the current direction is south
            } else if (currentDirection.equals("S")) {
                //change the direction to east
                currentDirection = "E";
                //if the current direction is west
            } else if (currentDirection.equals("W")) {
                //change the direction to south
                currentDirection = "S";
            }
            //the new assigned direction is the current direction
            gui.setDirection(this.Direction(currentDirection));
            //show the corresponding picture
            gui.showImage(this.getLocation(currentLocation).getSceneImage(currentDirection).getImage());
        }
    }

    /**
     * the move forward controls
     */
    public void forward() {
        //check to see if the front is blocked or not 
        if (this.getLocation(currentLocation).getSceneImage(currentDirection).frontBlocked()) {
            //store the direction in a temporary vairable
            String d = currentDirection;
            //the current location is set the the next location
            currentLocation = this.getLocation(currentLocation).getSceneImage(d).nextLocation();
            //the current direction is set the the next direction
            currentDirection = this.getLocation(currentLocation).getSceneImage(d).nextDirection();
            //output the new direction
            gui.setDirection(this.Direction(currentDirection));
            //output new location
            gui.setLocationName(currentLocation);
            //show the corresponding picture
            gui.showImage(this.getLocation(currentLocation).getSceneImage(currentDirection).getImage());
        }

    }

    /**
     * 
     * @param d the direction
     * @return the new direction
     */
    public String Direction(String d) {
        //if the direction is north
        if (d.equals("N")) {
            d = "North";
            //if the direction is south
        } else if (d.equals("S")) {
            d = "South";
            //if the direction is east
        } else if (d.equals("E")) {
            d = "East";
            //if the direction is west
        } else if (d.equals("W")) {
            d = "West";
        }
        //return the direction in a name form
        return d;
    }

    /**
     * 
     * @param name if the location
     * @return the location
     */
    public Location getLocation(String name) {
        int i = 0;
        //while the location is not equal to the description given to the location
        while (i < locations.size() - 1 && !name.equals(locations.get(i).getDesciption())) {
            //increase the loop variable
            i++;
        }
        //return the location
        return locations.get(i);
    }
}
