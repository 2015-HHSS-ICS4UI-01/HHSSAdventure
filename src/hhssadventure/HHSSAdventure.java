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

    private ArrayList<Class> locations = new ArrayList<>();
    private InterfaceGame gui;

    public HHSSAdventure() {
        //help file read
        FileReader file = null;
        try {
            file = new FileReader("students/students.txt");
        } catch (Exception e) {
            //prints out messege
            e.printStackTrace();
            //stops program
            System.exit(0);
        }

        //creates a scanner to read file
        Scanner input = new Scanner(file);

        //keep scanning as long as there is somthing to scan
        while (input.hasNext()) {
            //creating a class from a file
            Locations c = new Locations(input);
            //adding the class to the list
            locations.add(c);
        }

        gui = new InterfaceGame(this);
        //set the text for the next class
        Class c = locations.get(classNum);
        gui.setClassName(c.getCourseCode());
        //show it
        gui.setVisible(true);
    }

    public void nextLocation() {
        //if classNum  is less than numClasses -1
        if (classNum < classes.size() - 1) {
            //advance to next class
            classNum++;
        }
        //set the text for the next class
        Class c = classes.get(classNum);
        gui.setClassName(c.getCourseCode());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HHSSAdventure f = new HHSSAdventure();
    }
}
