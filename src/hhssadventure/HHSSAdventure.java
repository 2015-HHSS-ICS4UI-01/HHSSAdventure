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
    private UserInterface gui;
    private String currentLocation;
    private String currentDirection;
    
    public HHSSAdventure(){        
        FileReader file = null;
        
        try{
            file = new FileReader("images/pics.txt");
        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        
        Scanner input = new Scanner(file);
        
        currentLocation = input.next();
        currentDirection = input.next();
        
        while(input.hasNext()){
            Location l = new Location(input);
            locations.add(l);
        }
        
        gui = new UserInterface(this);
        
        
    }
    
    /**
     * Moves the user to the scene left of their current direction.
     */
    public void prevScene(){
        if(currentDirection.equals("N")){
            currentDirection = "W";
        }
    }
    
    /**
     * Moves the user to the scene right of their current direction.
     */
    public void nextScene(){
        
    }
    
    /**
     * Moves the user to the location forward of their current direction.
     * @param name the name of the new location.
     * @param direction the direction the user will face in the new location.
     */
    public void switchLocation(String name, String direction){
        
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HHSSAdventure game = new HHSSAdventure();
        
    }
    
}
