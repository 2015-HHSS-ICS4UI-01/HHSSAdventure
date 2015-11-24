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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      FileReader file = null;
        
        try
        {
           file = new FileReader("images/pics.txt");
          
        }catch(Exception e)
     {
          e.printStackTrace();
     }
       
        Scanner s = new Scanner(file);
//          while(s.hasNext())
//          {
//             System.out.println(s.nextLine());
//          }
          
           Location v = new Location(s);
           Scene c = new Scene(s);
           
           System.out.println(c.getDirection());
        
    }
}
