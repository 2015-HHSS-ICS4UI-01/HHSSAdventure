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
    private int classNum = 0;

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
    
        
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // I changed the comment!!!!
        //currentDir
        //Locations[]
        //currentLocation
        //switchLocation(name,direction)
    }
    
}
