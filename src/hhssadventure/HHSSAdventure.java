
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
        // an array List to store classes
        // just like our list AUT lessons
        ArrayList<Class> classes = new ArrayList<Class>();
        private UserInterface gui;
        private int classNum = 0;
        
        public HHSSAdventure(){
        // used to help read a file
        FileReader file = null;
        try{
            file = new FileReader("file.txt");
        }catch(Exception e){
            // prints out the error message
            e.printStackTrace();
            // stops the program
            System.exit(0);
        }
        // creates a scanner to read the file
        Scanner input = new Scanner(file);
        // keeps scanning as long as there is something to scan in
        while(input.hasNext()){

    }
        }
        

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    }
   
        
        
     public void forward(){
         
         
     }
     
      public void left(){
          
      }
      
       public void right(){
           
       }
       
}
