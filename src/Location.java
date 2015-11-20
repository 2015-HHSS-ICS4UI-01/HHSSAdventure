
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


public Location(Scanner input){
name = input.nextLine();
Scenes = new Scene[4];
for(int i = 0;i < 4; i++){
        Scene s = new Scene(input);
        //put student in list
        Scenes[i] = s;
    }

}

public String getName(){
    return this.name;
}


}
