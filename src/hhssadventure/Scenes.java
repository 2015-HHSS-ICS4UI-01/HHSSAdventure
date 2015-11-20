/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 *
 * @author janaj4926
 */
public class Scenes {
    BufferedImage img = null;

    public void getpic(String picName) {
        try{
            img = ImageIO.read(picName);
        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
    }

    //waiting for the interface
    public int direction(String d) {
        int c = 0;
        return c;
    }
    
    public boolean isFrontBlocked(){
        return true;
    }
    
    public void getNextLocation(){
        
    }
    
    public void description(){
        
    }
    
    public void getNextDirection(){
        
    }
}
