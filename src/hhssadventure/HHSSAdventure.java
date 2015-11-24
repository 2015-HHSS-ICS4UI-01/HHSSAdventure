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
    
    public String startingLocation = null;
    public String startingDirection = null;
    

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
        startingLocation = input.nextLine();
        startingDirection = input.nextLine();

        while(input.hasNext()){
            Location l = new Location(input);
            
            locations.add(l);
        }
        
        gui = new Interface(this);
        for(int i = 0; i < locations.size(); i++){
            if(startingLocation.equals(locations.get(i).getName())){
                Location l = locations.get(i);
                gui.setDescription(l.getSceneDescription(this.startingDirection));
            }
        }
        
        
        gui.setVisible(true);
        
    }
    
    
    public void nextRoom(){
        if(num < locations.size() - 1){
            num++;
        }
        Location l = locations.get(num);
        gui.setDescription(l.getSceneDescription(this.startingDirection));
    }
    
    public void previousRoom(){
        if(num > 0){
            num--;
        }
        Location l = locations.get(num);
        gui.setDescription(l.getSceneDescription(this.startingDirection));
    }
    
    public void advance(){
        //move to the next location
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
        
//        HHSSAdventure f = new HHSSAdventure();
    }
    
}
