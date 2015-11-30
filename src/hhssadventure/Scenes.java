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

    //direction
    private String dir;
    //name of the pic
    private String picName;
    //is the front is blocked?
    private boolean isFrontBlocked;
    //next location I can go to
    private String nextLocation;
    //next direction i face when i move
    private String nextDir;
    //the description
    private String description;
    //the image
    private BufferedImage image;
    
    /**
     * creates each individual scene
     * @param input the scanner
     */
    Scenes(Scanner input) {
        dir = input.next();
        picName = input.next();
        loadPic(picName);
        String check = input.next();
        if (check.equals("false")) {
            isFrontBlocked = false;
            nextLocation = input.next();
            nextDir = input.next();
        }else{
            isFrontBlocked = true;    
        }
        description = input.nextLine();
    }
    
    /**
     * looks for a boolean to see if i can go forward
     * @return true or false
     */
    public boolean isFrontBlocked(){
        return isFrontBlocked;
    }
    
    /**
     * finds the next location to go to
     * @return next location
     */
    public String getNextLocation(){
        return nextLocation;
    }
    
    /**
     * looks for the description if there is one
     * @return description
     */
    public String description(){
        return description;
    }
    
    /**
     * loads in the pictures
     * @param picName the name of the pic to look for
     */
    private void loadPic(String picName) {
        image = null;
        try{
            image = ImageIO.read(new File(picName));
        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
    }
    
    /**
     * returns a pic
     * @return picture
     */
    public BufferedImage getPic(){
        return image;
    }
}
