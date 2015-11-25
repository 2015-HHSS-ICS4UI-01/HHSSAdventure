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
 * @author janaj4926
 */
public class Scenes {

    private String dir;
    private String picName;
    private boolean isFrontBlocked;
    private String nextLocation;
    private String nextDir;
    private String description;
    
    Scenes(Scanner input) {
        dir = input.next();
        picName = input.next();
        String check = input.next();
        if (check.equals("false")) {
            isFrontBlocked = false;
            nextLocation = input.next();
            nextDir = input.next();
        }else{
            isFrontBlocked = true;    
        }
        description = input.next();
        input.nextLine();
    }
    
    public boolean isFrontBlocked(){
        return isFrontBlocked;
    }
    
    public String getNextLocation(){
        return nextLocation;
    }
    
    public String description(){
        return description;
    }
    
    public BufferedImage getpic(String picName) {
        BufferedImage img = null;
        try{
            ImageIO.read(new File("picName"));
        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        return img;
    }
}