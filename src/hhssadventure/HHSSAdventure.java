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
    int counter = 0;
    private ArrayList<Class> locations = new ArrayList<>();
    private String startingLocation;
    private String startDirection;
    public HHSSAdventure() {
        FileReader file = null;

        try {
            file = new FileReader("images/pics.txt");

        } catch (Exception e) {
            e.printStackTrace();
        }

        Scanner input = new Scanner(file);
//          while(s.hasNext())
//          {
//             System.out.println(s.nextLine());
//          }

        startingLocation = input.nextLine();
        startDirection = input.nextLine();
       
        
        
        Location c = new Location(input);
        Location w = new Location(input);

        
        
        System.out.println(c.getNextLocation("W"));

        System.out.println(w.getNextLocation("N"));
        
        
    }

   

    public void currentLocation() {
    }

    public void currentDirection() {
    }

    public void findLocation() {
    }

    public static void main(String[] args) {
        HHSSAdventure game = new HHSSAdventure();
        
        
    }
}
