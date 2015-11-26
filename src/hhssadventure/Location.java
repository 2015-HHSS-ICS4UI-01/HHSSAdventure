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
    private ArrayList<Scene> scenes = new ArrayList<>();

    public Location(Scanner in) {
        location = in.nextLine();
        for (int i = 0; i < 4; i++) {
            Scene s = new Scene(in);
            scenes.add(s);
        }
    }

    public String location() {
        return location();
    }
}