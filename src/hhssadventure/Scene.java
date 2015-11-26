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
 * @author yaol9270
 */
public class Scene {

    private String direction;
    private String name;
    private String picture;
    private String nextPicture;
    private String nextDirection;
    private BufferedImage img;
    private String here;
    private boolean blocked;

    public Scene(Scanner input) {

        direction = input.next();

        picture = input.next();

        img = null;
        try {
            img = ImageIO.read(new File("images/" + picture));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        here = input.next();
        if (here.equals("false")) {
            blocked = false;
            nextPicture = input.next();
            nextDirection = input.next();

        } else {
            blocked = true;

        }
        
        input.nextLine();





    }

    public BufferedImage picture() {
        return this.img;
    }

    public String direction() {
        return this.direction;
    }

    public boolean frontBlocked() {
        return this.blocked;
    }

    public String nextLocation() {
        return this.nextPicture;
    }

    public String description() {
        return this.name;
    }

    public String nextDirection() {
        return this.nextDirection;
    }
}
