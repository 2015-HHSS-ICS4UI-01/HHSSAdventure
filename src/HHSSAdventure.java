
import Example.Interface;
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

    private AdventureFrame frame;
    private String currentLocation;
    private String currentDirection;
    
    private ArrayList<Location> locations;
    private AdventureFrame gui;
    public HHSSAdventure(){
        locations = new ArrayList<>();

        FileReader file = null;
        try {
            file = new FileReader("Images/pics.txt");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

        Scanner input = new Scanner(file);
        currentLocation = input.nextLine();
        currentDirection = input.nextLine();


        while (input.hasNext()) {
            //creating class from file
            Location c = new Location(input);
            locations.add(c);
        }
        gui = new AdventureFrame(this);
        gui.setVisible(true);
        
        
        gui.setDirection(currentDirection);
        gui.setLocationName(currentLocation);
        

    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

       HHSSAdventure game = new HHSSAdventure();
       
        
        

    }
    
    public Location getLocation(String name){
        int i = 0;
        
        while(!name.equals(locations.get(i).getName())&&i<locations.size()){
         i++;
        }
        
        return locations.get(i);
       
    }
    
    public void turnRight(){
        if(currentDirection == "N"){
           currentDirection = "E" ;
        }else if(currentDirection == "E"){
           currentDirection = "S" ;
        }else if(currentDirection == "S"){
           currentDirection = "W" ;
        }else if(currentDirection == "W"){
           currentDirection = "N" ;
        }
        gui.setDirection(currentDirection);
    }
    
    public void turnLeft(){
    if(currentDirection == "N"){
           currentDirection = "W" ;
        }else if(currentDirection == "E"){
           currentDirection = "N" ;
        }else if(currentDirection == "S"){
           currentDirection = "E" ;
        }else if(currentDirection == "W"){
           currentDirection = "S" ;
        }
    gui.setDirection(currentDirection);
}
    
    
    }

