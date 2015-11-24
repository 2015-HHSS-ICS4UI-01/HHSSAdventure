
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
    private String startLocation;
    private String startDirection;
    private Location currentLocation;
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
        startLocation = input.nextLine();
        startDirection = input.nextLine();


        while (input.hasNext()) {
            //creating class from file
            Location c = new Location(input);
            locations.add(c);
        }
        gui = new AdventureFrame(this);
        gui.setVisible(true);
        
        currentLocation = this.getLocation(startLocation);
        
        gui.setLocationName(startLocation);
        

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
    
    
    }

