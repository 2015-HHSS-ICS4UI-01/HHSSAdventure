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
        //going through to find the actual location



    }

    public Location getLocation() {
        int i = 0;

        while (i < location.size()) {

            if (!Location.getLocation().equals(currentLocation)) {
                i++;
            }else{
                break;
            }
        }
        return Location;
    }

    public void forward() {
        if (!Location.isFrontBlocked(currentDir)) {
            currentLocation = Location.NextLocation(currentLocation);
            currentDir = Scene.nextDirection();
            //going through to find the actual location
            Location = getLocation();
        }


    }

    public void turnRight() {
        if (currentDir == "N") {
            currentDir = "E";
        } else if (currentDir == "E") {
            currentDir = "S";
        } else if (currentDir == "S") {
            currentDir = "W";
        } else if (currentDir == "W") {
            currentDir = "N";
        }
    }

    public void turnLeft() {
        if (currentDir == "N") {
            currentDir = "W";
        } else if (currentDir == "E") {
            currentDir = "N";
        } else if (currentDir == "S") {
            currentDir = "E";
        } else if (currentDir == "W") {
            currentDir = "S";
        }
    }

    public static void main(String[] args) {

        HHSSAdventure game = new HHSSAdventure();


    }
}
