
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
        
        
        gui.setDirection(this.Direction(currentDirection));
        gui.setLocationName(currentLocation);
        gui.setPicture(this.getLocation(currentLocation).getScene(currentDirection).getImage());
        

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
        
        while(i<locations.size()-1 &&!name.equals(locations.get(i).getName())){
         i++;
        }
        
        return locations.get(i);
       
    }
    
    public void turnRight(){
        if(currentDirection!=null){
        if(currentDirection.equals("N") ){
           currentDirection = "E" ;
        }else if(currentDirection.equals("E")){
           currentDirection = "S" ;
        }else if(currentDirection.equals("S")){
           currentDirection = "W" ;
        }else if(currentDirection.equals("W")){
           currentDirection = "N" ;
        }
        gui.setDirection(this.Direction(currentDirection));
        gui.setPicture(this.getLocation(currentLocation).getScene(currentDirection).getImage());
        }
    }
    
    public void turnLeft(){
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
    public void Advance(){
     if(this.getLocation(currentLocation).getScene(currentDirection).getForward()){
        String d = currentDirection;
        currentDirection = this.getLocation(currentLocation).getScene(d).getnextDirection();
        currentLocation = this.getLocation(currentLocation).getScene(d).getnextLocation();
        
         
         gui.setDirection(this.Direction(currentDirection));
         gui.setLocationName(currentLocation);
         gui.setPicture(this.getLocation(currentLocation).getScene(currentDirection).getImage());
         
         
     }   
    }
    
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

