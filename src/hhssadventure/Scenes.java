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

    private String currentDirection;
    private BufferedImage image = null;


    Scenes(Scanner input) {
        
    }
   


    public BufferedImage getPic() {
        return image;
    }

    //waiting for the interface

    public int direction(String d) {
        
    }
    
    public boolean isFrontBlocked(Scanner input){
        return true;
    }
    
    public void getNextLocation(Scanner input){
        
    }
    
    public void description(){
        
    }
    
    public void getNextDirection(Scanner input){
        
    }
}
