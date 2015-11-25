/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author naylj6470
 */
public class Location {

    private Scene[] scenes = new Scene[3];
    private String name;

    public Location(Scanner constructor) {
        name = constructor.nextLine();
        for (int i = 0; i < 4; i++) {
            Scene s = new Scene(constructor);
            scenes[i] = s;
            s.setDescription(name + s.getDirection());
        }
    }

    public String getName() {
        return name;
    }

    public BufferedImage getSceneImage(String dir) {
        for (int i = 0; i < 4; i++) {
            if (dir.equals(scenes[i].getDirection())) {
                return scenes[i].getImage();
            }
        }
        return null;
    }

    public boolean isFrontBlocked(String dir) {
        for (int i = 0; i < 4; i++) {
            if (dir.equals(scenes[i].getDirection())) {
                return scenes[i].isFrontBlocked();
            }
        }
        return true;
    }

    public String getSceneDescription(String dir) {
        for (int i = 0; i < 4; i++) {
            if (dir.equals(scenes[i].getDirection())) {
                return scenes[i].getDescription();
            }
        }
        return null;
    }

    public String getSceneNextLocation(String dir) {
        for (int i = 0; i < 4; i++) {
            if (dir.equals(scenes[i].getDirection())) {
                return scenes[i].getNextLocation();
            }
        }
        return null;
    }

    public String getSceneNextDirection(String dir) {
        for (int i = 0; i < 4; i++) {
            if (dir.equals(scenes[i].getDirection())) {
                return scenes[i].getNextDirection();
            }
        }
        return null;
    }
}
