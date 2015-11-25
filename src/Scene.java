
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;
import javax.imageio.ImageIO;

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
    private BufferedImage picture;

    public Scene(Scanner input) {
        direction = input.next();

        image = input.next();
       
        try{
            picture = ImageIO.read(new File("images/" + image));
        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }

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

    public BufferedImage getImage() {
        return this.picture;
    }

    public boolean getForward() {
        return this.moveForward;
    }

    public String getnextLocation() {

        return this.nextLocation;

    }

    public String getnextDirection() {
        return this.nextDirection;
    }
}
