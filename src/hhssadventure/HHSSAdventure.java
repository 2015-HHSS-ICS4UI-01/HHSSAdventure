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
    private String startingLocation;
    private String startingDirection;
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
        
        startingLocation = reader.nextLine();
        startingDirection = reader.nextLine();
        
        
        //keep scanning as long as theres something to scan
        while (reader.hasNext()) {
            //adding a class from the file
            Location a = new Location(reader);
            //addint the class to the list
            locations.add(a);
        }
        
        gui = new UserInterface(this);
        //set the text for the class name
        Location l = locations.get(locationNumber);
        gui.setLocationName(l.getDesciption());
        
        
        //showing the image the person is at
        gui.showImage(l.getSceneImage(startingDirection).getImage());
        //show it
        gui.setVisible(true);
        
    }
    
    
    public void right(){
//        Location l = locations.get(locationNumber);   
//        if () {
//            
//        }
//        gui.showImage(l.getSceneImage(currentDirection).getImage());
//        gui.setLocationName(l.getDesciption());
    }
    
    public void left(){
        Location l = locations.get(locationNumber);
        locationNumber --;
        gui.showImage(l.getSceneImage(currentDirection).getImage());
        gui.setLocationName(l.getDesciption());
    }
    
    public void forward(){
        Location l = locations.get(locationNumber);
        locationNumber --;
        gui.showImage(l.getSceneImage(currentDirection).getImage());
        gui.setLocationName(l.getDesciption());
        
    }
}
