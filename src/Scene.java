
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
        //direction string
        direction = input.next();
        //image url
        image = input.next();
        //read in image from string 
        try {
            picture = ImageIO.read(new File("images/" + image));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        //input String move forward
        String f = input.next();
        if (input.hasNext()) {
            //convert into boolean
            if (f.equals("false")) {
                moveForward = true;
                //if false input next location/direction
                nextLocation = input.next();
                nextDirection = input.next();

            } else {
                moveForward = false;
            }
        }



        input.nextLine();
    }

    /**
     * get direction
     *
     * @return
     */
    public String getDirection() {
        return this.direction;
    }

    /**
     * get image
     *
     * @return
     */
    public BufferedImage getImage() {
        return this.picture;
    }

    /**
     * get move forward
     *
     * @return
     */
    public boolean getForward() {
        return this.moveForward;
    }

    /**
     * get next location
     *
     * @return
     */
    public String getnextLocation() {

        return this.nextLocation;

    }

    /**
     * get next Direction
     *
     * @return
     */
    public String getnextDirection() {
        return this.nextDirection;
    }
}
