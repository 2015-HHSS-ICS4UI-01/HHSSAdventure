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
    private BufferedImage image;
    
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
    
    public boolean isFrontBlocked(){
        return isFrontBlocked;
    }
    
    public String getNextLocation(){
        return nextLocation;
    }
    
    public String getNextDir(){
        return nextDir;
    }
    
    public String description(){
        return description;
    }
    
    private void loadPic(String picName) {
        image = null;
        try{
            image = ImageIO.read(new File(picName));
        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
    }
    
    public BufferedImage getPic(){
        return image;
    }
}
