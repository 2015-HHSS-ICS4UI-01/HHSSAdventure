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

    private String location;
    private Scene[] scenes = new Scene[4];

    public Location(Scanner in) {
        location = in.nextLine();
        for (int i = 0; i < scenes.length; i++) {
            Scene s = new Scene(in);
            scenes[i] = s;
        }
    }

    public String getLocationName() {
        return location;
    }

    public Scene getCurrentScene(int dir) {
        return scenes[dir];
    }
}
