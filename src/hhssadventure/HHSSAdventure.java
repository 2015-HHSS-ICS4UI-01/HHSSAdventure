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
    

    public HHSSAdventure() {

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

        currentPlace = input.nextLine();
        currentDirection = input.nextLine();
        while (input.hasNext()) {
            Locations l = new Locations(input);
            locations.add(l);
        }
        gui = new AdventureInterface(this);
        gui.setVisible(true);
        
        
        for (Locations l : locations) {
            if (l.getPlace().equals(currentPlace)) {
                gui.setImage(l.getImage(currentDirection));
            }
        }

        
    }

    public void turnLeft() {
        System.out.println("turned left");
        for (Locations l : locations) {
            if (l.getPlace().equals(currentPlace)) {
                if (currentDirection.equals("N")) {
                    currentDirection = "W";
                    gui.setImage(l.getImage(currentDirection));
                } else if (currentDirection.equals("S")) {
                    currentDirection = "E";
                    gui.setImage(l.getImage(currentDirection));
                } else if (currentDirection.equals("E")) {
                    currentDirection = "N";
                    gui.setImage(l.getImage(currentDirection));
                } else if (currentDirection.equals("W")) {
                    currentDirection = "S";
                    gui.setImage(l.getImage(currentDirection));
                }
            }
        }
    }

    public void turnRight() {
        System.out.println("turned right");
        for (Locations l : locations) {
            if (l.getPlace().equals(currentPlace)) {
                if (currentDirection.equals("N")) {
                    currentDirection = "E";
                    gui.setImage(l.getImage(currentDirection));
                    
                } else if (currentDirection.equals("S")) {
                    currentDirection = "W";
                    gui.setImage(l.getImage(currentDirection));
                } else if (currentDirection.equals("E")) {
                    currentDirection = "S";
                    gui.setImage(l.getImage(currentDirection));
                } else if (currentDirection.equals("W")) {
                    currentDirection = "N";
                    gui.setImage(l.getImage(currentDirection));
                }
        
            }
        }
    }

    public void goForward() {
        for (Locations l : locations) {
            if (l.getPlace().equals(currentPlace)) {
                if (!l.getIsFrontBlocked(currentDirection)) {
                    System.out.println(currentPlace);
                    System.out.println("not blocked");
                    String temp = l.getNextLocation(currentDirection);
                    
                    currentDirection = l.getNextDirection(currentDirection);
                    gui.setImage(l.getImage(currentDirection));
                    //give interface new picture and refresh it
                    currentPlace = temp;
                    System.out.println(currentPlace + "1");
                }else{
                System.out.println("blocked");
                }
            }
        }
        

//        if (forward.getIsFrontBlocked(currentPlace)) {
//            currentPlace = forward.getNextLocation(currentDirection);
//        }
//
//        if (locationNum < locations.size() - 1) {
//            locationNum++;
//        } else if (locationNum == locations.size() - 1) {
//            locationNum = 0;
//        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HHSSAdventure a = new HHSSAdventure();
    }
}
