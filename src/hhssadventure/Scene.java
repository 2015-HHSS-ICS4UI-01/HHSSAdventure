/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author isles3536
 */
public class Scene {

    private String direction;
    private BufferedImage image;
    private String isBlocked;
    private boolean blocked;
    private String nextLocation;
    private String nextDirection;
/**
 * To get the input to read the file to get things into the correct positions for the correct information
 * @param input The file that was created for the purpose of this assignment
 */
    public Scene(Scanner input) {
        
        direction = input.next();
        String img = input.next();
        image = null;
        try {
            image = ImageIO.read(new File("images/" + img));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        isBlocked = input.next();
        //Will continue to run if the way not blocked but if it is it will not keep running
        if (isBlocked.equals("true")) {
            blocked = true;
            input.nextLine();
        } else {
            nextLocation = input.next();
            nextDirection = input.next();
            input.nextLine();
        }

    }
//These are the getter methods so that the location class can call to get the information that it needs so that is is able to switch properly.
    public String getDirection() {
        return this.direction;
    }

    public BufferedImage getImage() {
        return this.image;
    }

    public boolean isBlocked() {
        return this.blocked;
    }

    public String getNextLocation() {
        return this.nextLocation;
    }

    public String getNextDirection() {
        return this.nextDirection;
    }
}
