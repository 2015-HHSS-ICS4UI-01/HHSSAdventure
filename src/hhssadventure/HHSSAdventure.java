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

    public void switchLocation(String name, String direction){
        
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Location> locations = new ArrayList<>();
        String currentLocation;
        String currentDirection;
        
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
        
        for(int i = 0; i < locations.size(); i++){
            System.out.println(locations.get(i).getName());
        }
        
    }
    
}
