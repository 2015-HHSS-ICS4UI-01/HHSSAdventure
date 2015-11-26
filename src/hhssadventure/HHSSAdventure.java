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
    private InterfaceGame gui;

    public HHSSAdventure() {
        //help file read
        FileReader file = null;
        try {
            file = new FileReader("students/students.txt");
        } catch (Exception e) {
            //prints out messege
            e.printStackTrace();
            //stops program
            System.exit(0);
        }

        //creates a scanner to read file
        Scanner input = new Scanner(file);

        //keep scanning as long as there is somthing to scan
        while (input.hasNext()) {
            //creating a class from a file
            Location c = new Location(input);
            //adding the class to the list
            locations.add(c);
        }

        gui = new InterfaceGame(this);
        //set the text for the next class
        Location c = locations.get(getImage());
        gui.setPictureName(c.getDescription());
        //show it
        gui.setVisible(true);
    }

    public void nextLocation() {
        //set the text for the next class
        Location c = locations.get(getNextLocation());
        gui.setPictureName(c.getDescription());
    }

    public void turnLeft() {
        //if classNum in in bounds
        if (numOfPictures > 0 && numOfPictures <= 4) {
            //turns left
            numOfPictures--;
        } else {
            numOfPictures = 4;
        }
        //sets description for next photo
        Location c = locations.get(numOfPictures);
        gui.setPictureName(c.getDescription());
    }

    public void turnRight() {
        //if classNum is in bounds of the arra
        if (numOfPictures >= 0 && numOfPictures < 4) {
            //turn right
            numOfPictures++;
        } else {
            numOfPictures = 0;
        }
        //set description for next photo
        Location c = locations.get(numOfPictures);
        gui.setPictureName(c.getDescription());

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HHSSAdventure f = new HHSSAdventure();
    }
}
