/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author lamon
 */
public class HHSSAdventure {

    private AdventureInterface gui;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //current direction
        //current location
        //locations[]

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
//        while (input.hasNext()) {
//            System.out.println(input.nextLine());
//        }
    }
}
