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
    
    public Scene(Scanner input){
       
        direction = input.next();
        String img = input.next();
        image = null;
        try{
            image = ImageIO.read(new File("images/" + img));
        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        isBlocked = input.next();
        if(isBlocked.equals("true")){
            blocked = true;
            input.nextLine();
        }else{
        nextLocation = input.next();
        nextDirection = input.next();
        input.nextLine();
      }
  
      }
     
    public String getDirection(){
            return this.direction;
        }
    
    
    public BufferedImage getImage(){
        return this.image;
    }
    
    public boolean isBlocked(){
        return this.blocked;
    }
    
    public String getNextLocation(){
        return this.nextLocation;
    }
    
    public String getNextDirection(){
        return this.nextDirection;
    }
    
    
}
