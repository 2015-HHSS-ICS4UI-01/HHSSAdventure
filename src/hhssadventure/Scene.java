/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author donet6376
 */
public class Scene {

    private String direction;
    private String frontBlockedString;
    private boolean frontBlocked;
    private String nextLocation;
    private String description;
    private String nextDirection;
    private String imageName;
    private BufferedImage image;

    public Scene(Scanner constructor) {
        direction = constructor.next();
        imageName = constructor.next();
        frontBlockedString = constructor.next();
        if (frontBlockedString.equals("false")) {
            frontBlocked = false;
            nextLocation = constructor.next();
            nextDirection = constructor.next();
        } else {
            frontBlocked = true;
        }

        try {
            File input = new File("images/" + imageName);
            image = ImageIO.read(input);
        } catch (IOException ie) {
            System.out.println("Error:" + ie.getMessage());
        }
//      if(frontBlocked == false){
//          nextLocation = constructor.next();
//          nextDirection = constructor.next();
//      }
        constructor.nextLine();
    }

    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }

    public BufferedImage getImage() {
        return this.image;
    }

    public String getDirection() {
        return this.direction;
    }

    public void setDescription(String temp) {
        description = temp;
    }

    public String getDescription() {
        return description;
    }

    public boolean isFrontBlocked() {
        return frontBlocked;
    }

    public String getNextLocation() {
        return nextLocation;
    }

    public String getNextDirection() {
        return nextDirection;
    }
}
