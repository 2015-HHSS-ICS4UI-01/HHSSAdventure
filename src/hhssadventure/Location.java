/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author NathanKampzEtAndrewSSS
 */
public class Location {

    private String location;
    private Scene[] scenes = new Scene[4];
    private Scene currentScene;

    public Location(Scanner in, String dir) {
        location = in.nextLine();
        for (int i = 0; i < scenes.length; i++) {
            Scene s = new Scene(in);
            if (s.getDir().equals(dir)) {
                currentScene = s;
            }
            scenes[i] = s;
        }
    }

    public String location() {
        return location();
    }
    
    public Scene getCurrentScene(){
        return currentScene;
    }
}
