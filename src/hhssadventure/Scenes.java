/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;
<<<<<<< HEAD

=======
import javax.imageio.ImageIO;
>>>>>>> branch 'master' of https://github.com/janaj4926/HHSSAdventure

/**
 *
 * @author janaj4926
 */
public class Scenes {
<<<<<<< HEAD
    private String currentDirection;
    private BufferedImage image = null;
=======

    Scenes(Scanner input) {
        
    }
    
>>>>>>> branch 'master' of https://github.com/janaj4926/HHSSAdventure

    public BufferedImage getPic() {
        return image;
    }

    //waiting for the interface
<<<<<<< HEAD

    public int direction(Scanner input) {
        int c = 0;
=======
    public int direction(String d) {
        if
>>>>>>> branch 'master' of https://github.com/janaj4926/HHSSAdventure
        return c;
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
