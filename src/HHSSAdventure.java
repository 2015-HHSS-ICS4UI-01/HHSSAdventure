
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author lamon
 */
public class HHSSAdventure {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<Location> locations = new ArrayList<>();
        
         FileReader file = null;
        try{
            file = new FileReader("Images/pics.txt");
        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        
        Scanner input = new Scanner(file);
        String startLocation = input.nextLine();
        String startDirection = input.nextLine();
        
        
        while(input.hasNext()){
            //creating class from file
            Location c = new Location(input);
            locations.add(c);
        }
        
        
        
        
    }
    
}
