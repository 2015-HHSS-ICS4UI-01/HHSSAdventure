/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.util.Scanner;

/**
 *
 * @author NathanKampzEtAndrewSSS
 */
public class Location {

    private final String locationName;
    private final Scene[] scenes = new Scene[4];

    public Location(Scanner in) {
        locationName = in.nextLine();
        for (int i = 0; i < scenes.length; i++) {
            Scene s = new Scene(in);
            scenes[i] = s;
        }
    }

    public String getLocationName() {
        return locationName;
    }

    public Scene getCurrentScene(int dir) {
        return scenes[dir];
    }
}
