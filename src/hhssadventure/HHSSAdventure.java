/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author NathanKampzEtAndrewSSS
 */
public final class HHSSAdventure {

    private ArrayList<Location> locations = new ArrayList<>();
    private String location;
    private int dir;
    private Location currentLocation;
    private Scene currentScene;
    private Interface GUI;
    private BufferedImage img = null;

    public HHSSAdventure() {
        FileReader file = null;
        try {
            file = new FileReader("images/pics.txt");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        Scanner in = new Scanner(file);
        location = in.nextLine();
        String temp = in.nextLine();
        switch (temp) {
            case "N":
                dir = 0;
                break;
            case "E":
                dir = 1;
                break;
            case "S":
                dir = 2;
                break;
            default:
                dir = 3;
                break;
        }
        while (in.hasNext()) {
            Location l = new Location(in);
            locations.add(l);
        }
        updateLocation();
        GUI = new Interface(this);
        GUI.setVisible(true);
    }

    public BufferedImage updateImage() {
        try {
            img = ImageIO.read(new File("images/" + currentScene.getImageName()));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return img;
    }

    public void left() {
        if (dir > 0) {
            dir--;
        } else {
            dir = 3;
        }
        updateScene();
    }

    public void forward() {
        if (!currentScene.getFrontBlocked()) {
            location = currentScene.getNextLocation();
            dir = currentScene.getNextDir();
            updateLocation();
        }
    }

    public void right() {
        if (dir < 3) {
            dir++;
        } else {
            dir = 0;
        }
        updateScene();
    }

    public void updateLocation() {
        for (Location l : locations) {
            if (l.getLocationName().equals(location)) {
                currentLocation = l;
                updateScene();
            }
        }
    }

    public void updateScene() {
        currentScene = currentLocation.getCurrentScene(dir);
    }
    
    public String getLocation() {
        return location;
    }
    
    public int getDir() {
        return dir;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        HHSSAdventure adv = new HHSSAdventure();
    }
}
