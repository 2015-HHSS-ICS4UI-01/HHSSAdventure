/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.util.Scanner;

/**
 *
 * @author rayan4858
 */
public class Location {

    //variable to store the name of the location
    private String locationName;
    //initialize the array of scenes
    private Scene[] scenes;

    //contstructor 
    public Location(Scanner input) {
        //the name of the location is the next line in the text file
        locationName = input.nextLine();
        //give the array a size
        scenes = new Scene[4];
        //itter through and assign every spot in the array a scene
        for (int i = 0; i < 4; i++) {
            //creats a scene
            Scene s = new Scene(input);
            //puts scene in the list
            scenes[i] = s;
        }
    }

    /**
     * 
     * @param sceneDirection the direction the scene is in
     * @return the scene
     */
    public Scene getSceneImage(String sceneDirection) {
        int i = 0;
        //while the scene is not equal to the description given to the location
        while (i < scenes.length - 1 && !this.scenes[i].getDirection().equals(sceneDirection)) {
            i++;
        }
        //return the scene
        return scenes[i];
    }

    /**
     * 
     * @return the name of the location
     */
    public String getDesciption() {
        return this.locationName;
    }

}
