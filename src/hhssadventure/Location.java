/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author simma1980
 */
public class Location {

    private String name;
    private ArrayList<Scene> scenes = new ArrayList<>();

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
}