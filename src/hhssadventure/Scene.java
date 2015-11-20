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
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author donet6376
 */
public class Scene extends Panel {
    
    //picture
    private char direction;
    private boolean frontBlocked;
    private Location nextLocation;
    private String Description;
    private char nextDirection;
    
    BufferedImage  image;
  public Scene() {
  try {
//  System.out.println("Enter image name\n");
//  BufferedReader bf=new BufferedReader(new 
// InputStreamReader(System.in));
// String imageName=bf.readLine();
  File input = new File("images/IMG_0047.JPG");
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
} 
    
    
    
    
    
    
  
