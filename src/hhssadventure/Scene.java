/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.util.Scanner;

/**
 *
 * @author simma1980
 */
public class Scene {

    private String dir;
    private String location;
    private boolean frontBlocked;
    private String nextLocation;
    private String nextDir;
    private String image;

    public Scene(Scanner in) {
        dir = in.next();
        image = in.next();
        String test = in.next();
        if (test.equals("false")) {
            frontBlocked = false;
        } else {
            frontBlocked = true;
        }
        
        
    }
}
