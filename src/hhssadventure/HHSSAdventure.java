/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author lamon
 */
public class HHSSAdventure {

    /**
     * @param args the command line arguments
     */
    
    private ArrayList<Location> location = new ArrayList<>();
    private int locationNum = 0;
    
    
    public HHSSAdventure(){
    FileReader file = null;
            try
            {
                  file = new FileReader("images/pics.txt");
                  
                  
             }catch(Exception e)
             {
                  e.printStackTrace();
                  System.exit(0);
             }
            Scanner input = new Scanner(file);
            String startingLocation = input.nextLine();
            String startingDirection = input.nextLine();
            
            while(input.hasNext())
                  {
                     Location l = new Location(input);
                     location.add(l);
                  }
}
    
    
    public static void main(String[] args) {
        
        HHSSAdventure game = new HHSSAdventure();
             
            
    }
    
}
