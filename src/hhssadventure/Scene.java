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
 * @author NathanKampzEtAndrewSSS
 */
public class Scene {
    
    private String dir;
    private String image;
    private boolean frontBlocked;
    private String nextLocation;
    private String nextDir;
    private BufferedImage img = null;
    
    public Scene(Scanner in) {
        dir = in.next();
        image = in.next();
        String test = in.next();
        if (test.equals("false")) {
            frontBlocked = false;
            nextLocation = in.next();
            nextDir = in.nextLine();
        } else {
            frontBlocked = true;
            in.nextLine();
        }
        try {
            img = ImageIO.read(new File(image));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * gets the current direction
     *
     * @return direction
     */
    public String getDir() {
        return dir;
    }

    /**
     * gets the current image name
     *
     * @return image name
     */
    public String getImage() {
        return image;
    }

    /**
     * gets whether or not the front passage is blocked or not
     *
     * @return true or false
     */
    public boolean getFrontBlocked() {
        return frontBlocked;
    }

    /**
     * gets the next location
     *
     * @return the next location
     */
    public String getNextLocation() {
        return nextLocation;
    }

    /**
     * gets next direction
     *
     * @return next direction
     */
    public String getNextDir() {
        return nextDir;
    }
}
