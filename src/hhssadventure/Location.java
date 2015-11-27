/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.util.Scanner;

/**
 *
 * @author millg1278
 */
public class Location {

    private Scene[] scene;
    private String image;
    private String imageDirection;
    private String directionFrontBlocked;

    public Location(Scanner input) {
        Scene scene = new Scene(input);
        image = scene.getPicture();
        imageDirection = scene.getDirection();
        directionFrontBlocked = imageDirection;
        
        Scene Scene[] = new Scene[4]; 
        
    }
    public String getImage(){
        return this.image;
    }
    
    public String getDirection(){
        return this.imageDirection;
    }
    
    public String direcFrontBlocked() {
        return this.directionFrontBlocked;
    }
}