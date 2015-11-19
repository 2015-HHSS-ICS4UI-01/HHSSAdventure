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
    public static void main(String[] args) {
        
        ArrayList<Location> locations = new ArrayList<>();
        
        FileReader file = null;
        
        try{
            file = new FileReader("images/pics.txt");
            Scanner input = new Scanner(file);
            while(input.hasNext()){
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
    }
    
}
