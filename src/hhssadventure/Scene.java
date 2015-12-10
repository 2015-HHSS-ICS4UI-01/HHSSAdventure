/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author rayan4858
 */
public class Scene {

    private String direction;
    private Scene[] Scenes;
    private String imageName;
    private String blocked;
    private String nextLocation;
    private String nextDirection;
    private boolean block = false;
    private BufferedImage img = null;

    //constructor 
    public Scene(Scanner input) {

        direction = input.next();
        
        imageName = input.next();
        
        
        try{
            img = ImageIO.read(new File("images/" + imageName));
        }catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        
        String f = input.next();
        if (input.hasNext()) {
            if (f.equals("false")) {
               block = true;
               nextLocation = input.next();
               nextDirection = input.next();
            }
        }
        blocked = input.next();
        if (blocked.equals("false")) {
            block = false;
            nextLocation = input.next();
            nextDirection = input.next();
        } else {
            block = true;  
            
        }
        input.nextLine();
    }

    public boolean frontBlocked() {
        return this.block;
    }

    public String nextLocation() {
        return this.nextLocation;
    }

    public String getDirection() {
        return this.direction;
    }

    public String nextDirection() {
        return this.nextDirection;
    }
    
    public BufferedImage getImage(){
        return this.img;
    }
}
