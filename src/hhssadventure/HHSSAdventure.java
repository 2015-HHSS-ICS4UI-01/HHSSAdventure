/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author NathanKampzEtAndrewSSS
 */
public class HHSSAdventure {

    private ArrayList<Location> locations = new ArrayList<>();
    private String location, dir;
    private int locNum = 0;
    private Interface GUI;

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
        dir = in.nextLine();
        while (in.hasNext()) {
            Location l = new Location(in);
            locations.add(l);
        }
        GUI = new Interface(this);
        GUI.setVisible(true);
    }
    
    public String getDir() {
        return dir;
    }
    
    public void nextLocation() {
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        HHSSAdventure hhssa = new HHSSAdventure();
    }
}
