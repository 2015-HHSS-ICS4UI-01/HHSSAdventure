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
public class HHSSAdventure {

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
            //sets the direction to a number 
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
        //updates location and sets the interface to visable
        updateLocation();
        GUI = new Interface(this);
        GUI.setVisible(true);

    }

    public void updateImage() {
        try {
            //loads the image
            img = ImageIO.read(new File(currentScene.getImage()));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    
    
    
    public void left(){ 
        //turning left button
        //if the direction is north(0) and you are turning left, set the direction to west(3)
        if(dir == 0){
            dir = 3;
        } else {
            dir--;
        }
        //sets the scene to the locations scene at the direction
        currentScene = currentLocation.getCurrentScene(dir);
    }

    public void forward() {
        //forward button
        
        location = currentScene.getNextLocation();
        dir = currentScene.getNextDir();
        updateLocation();
    }

    public void right() {
         //turning right button
        //if the direction is west(3) and you are turning right, set the direction to north(0)
        if (dir < 3) {
            dir++;
        } else {
            dir = 0;
        }
        //sets the scene to the locations scene at the direction
        currentScene = currentLocation.getCurrentScene(dir);
    }

    public void updateLocation() {
        for (Location l : locations) {
            if (l.getLocationName().equals(location)) {
                currentLocation = l;
                currentScene = currentLocation.getCurrentScene(dir);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        HHSSAdventure adv = new HHSSAdventure();
    }
}
