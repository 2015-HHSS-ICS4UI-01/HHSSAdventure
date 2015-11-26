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

    //an array list to store classes
    //just like our list ADT lessons

    private ArrayList<Location> locations = new ArrayList<>();
    private Interface gui;
    private int num = 0;
    private Location storedLocation;
    
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

        while(input.hasNext()){
            Location l = new Location(input);
            
            locations.add(l);
        }
        
        for(int i = 0; i < locations.size(); i++){
            if(currentLocation.equals(locations.get(i).getName())){
                Location l = locations.get(i);
            }
        }
        
        gui = new Interface(this);
        for(int i = 0; i < locations.size(); i++){
            if(currentLocation.equals(locations.get(i).getName())){
                Location l = locations.get(i);
                gui.setDescription(l.getSceneDescription(this.currentDirection));
            }
        }
        
        
        gui.setVisible(true);
        System.out.println(storedLocation.getName());
    }
    
    
    public void turnRight(){
        if(num < locations.size() - 1){
            num++;
        }
        Location l = locations.get(num);
        gui.setDescription(l.getSceneDescription(this.currentDirection));
    }
    
    public void turnLeft(){
        if(num > 0){
            num--;
        }
        Location l = locations.get(num);
        gui.setDescription(l.getSceneDescription(this.currentDirection));
    }
    
    public void advance(){
        
                currentLocation = storedLocation.getSceneNextLocation(currentDirection);
                currentDirection = storedLocation.getSceneNextDirection(currentDirection);
                //gui.setImage();
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
