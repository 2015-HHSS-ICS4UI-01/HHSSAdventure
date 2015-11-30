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
 * @author lamon
 */
public class HHSSAdventure {

    /**
     * @param args the command line arguments
     */
    private ArrayList<Location> location = new ArrayList<>();
    private String currentLocation;
    private String currentDir;
    private UserInterface gui;
    private Location Location;
    private Scene Scene;

    public HHSSAdventure() {
        FileReader file = null;
        try {
            file = new FileReader("images/pics.txt");


        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        Scanner input = new Scanner(file);
        String startingLocation = input.nextLine();
        String startingDirection = input.nextLine();

        while (input.hasNext()) {
            Location l = new Location(input);
            location.add(l);
        }

        currentDir = startingDirection;
        currentLocation = startingLocation;
        Location = getLocation();
        //going through to find the actual location
        gui = new UserInterface(this);
        gui.setVisible(true);

        gui.displayPicture(Location.getImage(currentDir));
    }

    public Location getLocation() {
        int i = 0;

        while (i < location.size()) {

            if (!location.get(i).getLocation().equals(currentLocation)) {
                i++;
            }else{
                
                break;
            }
        }
        return location.get(i);
        
    }

    

    public void forward() {
        if (!Location.isFrontBlocked(currentDir)) {
            currentLocation = Location.NextLocation(currentLocation);
            //currentDir = Scene.nextDirection();
            //going through to find the actual location
            Location = getLocation();
            Scene = Location.getScene(currentDir);
            gui.displayPicture(Location.getImage(currentDir));
        }


    }

    public void turnRight() {
        if (currentDir.equals("N")) {
            currentDir = "E";
        } else if (currentDir.equals("E")) {
            currentDir = "S";
        } else if (currentDir.equals("S")) {
            currentDir = "W";
        } else if (currentDir.equals("W")) {
            currentDir = "N";
        }
        Scene = Location.getScene(currentDir);
        gui.displayPicture(Location.getImage(currentDir));
    }

    public void turnLeft() {
        if (currentDir.equals("N")) {
            currentDir = "W";
        } else if (currentDir.equals("E")) {
            currentDir = "N";
        } else if (currentDir.equals("S")) {
            currentDir = "E";
        } else if (currentDir.equals("W")) {
            currentDir = "S";
        }
        Scene = Location.getScene(currentDir);
        gui.displayPicture(Location.getImage(currentDir));
    }

    public static void main(String[] args) {

        HHSSAdventure game = new HHSSAdventure();


    }
}

