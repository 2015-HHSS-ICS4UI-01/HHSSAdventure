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
public class Scene extends Panel {
    
    private String direction;
    private boolean frontBlocked;
    private String nextLocation;
    private String description;
    private String nextDirection;
    private String imageName;
    private BufferedImage  image;
    private String[] compass = {"N","S","E","W"};
    
  public Scene(Scanner constructor) {
      direction = constructor.next();
      imageName = constructor.next();
      frontBlocked = constructor.nextBoolean();
      if(frontBlocked == false){
          nextLocation = constructor.next();
          nextDirection = constructor.next();
      }
      constructor.nextLine();
  }   
     
  public Scene(){
  try {
  File input = new File("images/" + imageName);
  image = ImageIO.read(input);
  } catch (IOException ie) {
  System.out.println("Error:"+ie.getMessage());
  }
  }

  public void paint(Graphics g) {
  g.drawImage( image, 0, 0, null);
  }

  static public void main(String args[]) throws
Exception {
  JFrame frame = new JFrame("Display image");
  Panel panel = new Scene();
  frame.getContentPane().add(panel);
  frame.setSize(1200, 800);
  frame.setVisible(true);
  }
  
      public BufferedImage getImage(){
        return this.image;
}
      
      public String getDirection(){
          return this.direction;
      }
  
      public void setDescription(String temp){
          description = temp;
      }
      
      public String getDescription(){
          return description;
      }
      
      public boolean isFrontBlocked(){
          return frontBlocked;
      }
      
      public String getNextLocation(){
          return nextLocation;
      }
      
      public String getNextDirection(){
          return nextDirection;
      }
      
} 
