
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vonhn0812
 */
public class Scene {

    private String direction;
    private String image;
    private boolean moveForward;
    private String nextLocation;
    private String nextDirection;

    public Scene(Scanner input) {
        direction = input.next();
        image = input.next();
        String f = input.next();
        if (f.equals("false")) {
            moveForward = true;
            nextLocation = input.next();
            nextDirection = input.next();
       } else {
           moveForward = false;
       }

        input.nextLine();
    }

    public String getDirection() {
        return this.direction;
    }

    public String getImage() {
        return this.image;
    }

    public boolean getForward() {
        return this.moveForward;
    }

    public String getnextLocation() {

        return this.nextLocation;

    }
    
    public String getnextDirection(){
        return this.nextDirection;
    }
}
