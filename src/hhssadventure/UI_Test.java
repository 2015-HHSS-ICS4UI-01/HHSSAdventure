/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.AWTException;
import java.io.IOException;

/**
 *
 * @author scott
 */
public class UI_Test {

    /**
     * @param args the command line arguments
     * @throws java.awt.AWTException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws AWTException, IOException {
        //String location, String picture, boolean frontBlocked, char direction

        Scene scene = new Scene("Doesn't matter whatever", "IMG_0046.jpg", false, 'n');
        Scene scene2 = new Scene("Doesn't matter whatever", "IMG_0045.jpg", false, 'n');
        
        UserInterface UI = new UserInterface(scene);
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        UI.setImage(scene2);
    }

}
