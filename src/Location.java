
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vonhn0812
 */
public class Location {

    private Scene[] Scenes;
    private String name;
/**
 * constructor method
 * @param input 
 */
    public Location(Scanner input) {
        //set location name
        name = input.nextLine();
        //make scene array with 4 scenes
        Scenes = new Scene[4];
        //transfer text into the scene class'
        for (int i = 0; i < 4; i++) {

            Scene s = new Scene(input);
            //put Scene in array
            Scenes[i] = s;
        }


    }
    /**
     * get location name
     * @return 
     */
    public String getName() {
        return this.name;
    }
    /**
     * get scene using name instead of index
     * @param direction
     * @return 
     */
    public Scene getScene(String direction) {
        int i = 0;
        while(i<Scenes.length-1 && !Scenes[i].getDirection().equals(direction)){
            i++;
        }
        return Scenes[i];
    }
    
}
