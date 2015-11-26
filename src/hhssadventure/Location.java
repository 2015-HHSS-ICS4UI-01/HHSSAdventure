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

    private String name;
    private ArrayList<Scene> scenes = new ArrayList<>();
    private int sceneNum = 0;
     

    public Location(Scanner in) {
        name = in.nextLine();
        for (int i = 0; i < 4; i++) {
            Scene s = new Scene(in);
            scenes.add(s);
        }
    }

    public String getName() {
        return name;
    }
    
    public String nextDir() {
        return scenes.get(sceneNum).getNextDir();
    }
    
    
}
