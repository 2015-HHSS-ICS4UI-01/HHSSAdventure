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

    /**
     * @param args the command line arguments
     */
    
    private ArrayList<Location> locations = new ArrayList<>();
    private String startingLocation;
    private String startDirection;
    private String currentDirection;
    private String currentLocation;
    
    public HHSSAdventure() {
        FileReader file = null;

        try {
            file = new FileReader("images/pics.txt");

        } catch (Exception e) {
            e.printStackTrace();
        }

        Scanner input = new Scanner(file);
        
        startingLocation = input.nextLine();
        startDirection = input.nextLine();
          while(input.hasNext())
          {
             Location s = new Location(input);
              System.out.println(s.getName());
             locations.add(s);
          }
      
        
        
        
      
        
        currentDirection = startDirection;
        currentLocation = startingLocation;
    }
        
   
    public void switchLocation(String name, String dir){
        for(int i = 0; i < locations.size(); i++){
            
        }
    }

    public static void main(String[] args) {
        HHSSAdventure game = new HHSSAdventure();
        
        
    }
}
