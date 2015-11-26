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
    ArrayList<Locations> locations = new ArrayList<>();
    private AdventureInterface gui;
    private String currentPlace;
    private String currentDirection;
    private Locations forward;
    
    public HHSSAdventure(){
        FileReader file = null;
        try {
            file = new FileReader("images/pics.txt");
        } catch (Exception e) {
            //prints out the error message
            e.printStackTrace();
            //stops the program
            System.exit(0);
        }

        //creates a scanner to read a file
        Scanner input = new Scanner(file);

        //


        currentPlace = input.nextLine();
        currentDirection = input.nextLine();
        while (input.hasNext()) {
            Locations l = new Locations(input);
            locations.add(l);
        }
        
        gui = new AdventureInterface(this);

    }
    public void turnLeft(){
        
    }
    
    public void turnRight(){
        
    }
    
    public void goForward(){
        if(forward.isFrontBlocked()){
            currentPlace = forward.nextLocation();
        }
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //current direction
        //current location
        //locations[]

    }
}
