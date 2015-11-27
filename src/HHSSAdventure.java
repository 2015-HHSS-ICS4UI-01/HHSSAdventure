
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
    /**
     * constructor method
     */
    public HHSSAdventure(){
        //array list for location 
        locations = new ArrayList<>();
        //import text file
        FileReader file = null;
        try {
            file = new FileReader("Images/pics.txt");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        //scanner for text file
        Scanner input = new Scanner(file);
        //starting location
        currentLocation = input.nextLine();
        //start direction
        currentDirection = input.nextLine();

        //move text into the location array
        while (input.hasNext()) {
            
            Location c = new Location(input);
            locations.add(c);
        }
        //set the user interface
        gui = new AdventureFrame(this);
        //make it visible
        gui.setVisible(true);
        
        //set the visible direction
        gui.setDirection(this.Direction(currentDirection));
        //set the visible location
        gui.setLocationName(currentLocation);
        //set the picture
        gui.setPicture(this.getLocation(currentLocation).getScene(currentDirection).getImage());
        

    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

       HHSSAdventure game = new HHSSAdventure();
       
       
        

    }
    /**
     * get a location from the array list using a String instead of index
     * @param name
     * @return 
     */
    public Location getLocation(String name){
        int i = 0;
        //find the index at the name
        while(i<locations.size()-1 &&!name.equals(locations.get(i).getName())){
         i++;
        }
        
        return locations.get(i);
       
    }
    /**
     * turn right at current location
     */
    public void turnRight(){
        //check direction is null
        if(currentDirection!=null){
        //reassign the directions based on right turn
        if(currentDirection.equals("N") ){
           currentDirection = "E" ;
        }else if(currentDirection.equals("E")){
           currentDirection = "S" ;
        }else if(currentDirection.equals("S")){
           currentDirection = "W" ;
        }else if(currentDirection.equals("W")){
           currentDirection = "N" ;
        }
        //reset the visible direction
        gui.setDirection(this.Direction(currentDirection));
        //reset the picture
        gui.setPicture(this.getLocation(currentLocation).getScene(currentDirection).getImage());
        }
    }
    /**
     * turn left at current location
     */
    public void turnLeft(){
        //same as right turn except based on left turn
       if(currentDirection!=null){
    if(currentDirection.equals("N")){
           currentDirection = "W" ;
        }else if(currentDirection.equals("E")){
           currentDirection = "N" ;
        }else if(currentDirection.equals("S")){
           currentDirection = "E" ;
        }else if(currentDirection.equals("W")){
           currentDirection = "S" ;
        }
    gui.setDirection(this.Direction(currentDirection));
    gui.setPicture(this.getLocation(currentLocation).getScene(currentDirection).getImage());
       }
}
    /**
     * Move forward
     */
    public void Advance(){
        //check if player is able to move forward 
     if(this.getLocation(currentLocation).getScene(currentDirection).getForward()){
         //temp direction
        String d = currentDirection;
        //direction is equal to next direction
        currentDirection = this.getLocation(currentLocation).getScene(d).getnextDirection();
        //location is equal to next location
        currentLocation = this.getLocation(currentLocation).getScene(d).getnextLocation();
        
         //reset visible direction
         gui.setDirection(this.Direction(currentDirection));
         //reset visible location
         gui.setLocationName(currentLocation);
         //reset picture
         gui.setPicture(this.getLocation(currentLocation).getScene(currentDirection).getImage());
         
         
     }   
    }
    /**
     * to convert text file characters into full directions for interface
     * @param d
     * @return 
     */
    public String Direction(String d){
        if(d.equals("N")){
          d = "North";  
        }else if(d.equals("S")){        
          d = "South";
        }else if(d.equals("E")){        
         d = "East";
        }else if(d.equals("W")){        
         d = "West";
        }
            
        return d;
    }
    
    }

