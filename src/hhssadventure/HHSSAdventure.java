/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.AWTException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author lamon
 */
public class HHSSAdventure {

    /**
     * @param args the command line arguments
     */
    Scene currentScene = null;
    HashMap<String, Scene> scenes = new HashMap<>();
    
    /**
     * Runs the game loop
     * @throws AWTException 
     */
    private void run() throws AWTException
    {
        // Creates the window
        UserInterface UI = new UserInterface(currentScene);
        
        boolean done = false;
        while(!done) {
            // Check the mouse movement, changing the current scene accordingly
            UI.updateScene();
            // Redraws the UI
            UI.repaint();
            // Sleeps the current thread to allow the event listeners in the UI to act
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Reads the pictures and their connections from the file, connects them in a graph, and runs the game
     * @param args
     * @throws AWTException 
     */
    public static void main(String[] args) throws AWTException {
        HHSSAdventure main = new HHSSAdventure();
        main.readFile();
        main.run();
    }
    
    /**
     * Reads file and links all of the scenes in a graph
     */
    private void readFile()
    {
        // Stores all of the locations and their indivdual scenes based on their scene image names, in the order [N, E, S, W] -- This isn't a very good approach, and we'd change it if we were to redo the project
            // LocationName:String, ScenePictures:String[]
        HashMap<String, String[]> locations = new HashMap<>();
        // Stores the next location and starting direction for each scene
            // Since the scenes stored in the locations map are ordered by [N, E, S, W] --> [0, 1, 2, 3], where the direction value is the corresponding index
            // SceneImage:String, [LocationName:String, Direction:Integer]
        HashMap<String, HashMap<String, Integer>> sceneForwards = new HashMap<>();
        
        // The name of the starting location
        String startingLocationName = "";
        // The direction index [N, E, S, W] --> [0, 1, 2, 3] of the starting direction
        int startingLocationDirection = 0;
        
        try
        {
              // load the file for scanning
              FileReader file = new FileReader("images\\pics.txt");
              Scanner s = new Scanner(file);
              
              // The starting location name is the first element of the file
              startingLocationName = s.next();
              // The starting direction is the seconds element of the file
                // The direction is converted into the corresponding integer index
              startingLocationDirection = convertDirectionToIndex(s.next().charAt(0));
              
              // Commence reading of all the locations and 
                // The file is structured as a list of locations, each containing exactly 4 scenes, in the order N E S W
              while(s.hasNext())
              {
                    // Set the current location's name
                     String location = s.next();
                     // scenes in this location
                     String[] scenesArray = new String[4];
                     
                     // Loop through each scene
                     for (int i = 0; i < 4; i ++)
                     {
                            
                            // The direction the user is facing when in this scene
                            String direction = s.next();
                            // The current scene's image (ImageName.JPG)
                            String image = s.next();
                            // The string (true/false) whether or not forward is blocked
                            String blockedString = s.next();
                            // convert the string (true/false) into a boolean reading
                            boolean blocked = blockedString.equals("true") ? true: false;
                            
                            // The location-direction index pair for the sceneForwards map
                            HashMap<String, Integer> nextLocationAndDirection = new HashMap<>();
                            
                            // If the scene forward isn't blocked set the nextLocationAndDirection
                            if (!blocked)
                            {
                                // the forward location
                                String nextLocation = s.next();
                                // the direction (converted into an index for [N, E, S, W]) of the forward scene
                                int dir = convertDirectionToIndex(s.next().charAt(0));
                                nextLocationAndDirection.put(nextLocation, dir);
                            }
                            // otherwise, just set the nextLocationAndDirection to contain invalid values
                            else
                            {
                                nextLocationAndDirection.put(null, -1);
                            }
                            
                            // create the current scene and add it to the scenes map
                            scenes.put(image, new Scene(location, image, blocked, direction.charAt(0)));
                            // populate scenes array for each location (N E S W)
                            scenesArray[i] = image;
                            // add the information about this scene's forward stuff to the sceneForwards map
                            sceneForwards.put(image, nextLocationAndDirection);
                     }
                     // Once all of the scenes have been taken care of, add the current location to the locations map
                     locations.put(location, scenesArray);
                     
              }
         }catch(Exception e)
         {
              e.printStackTrace();
         }        
        // now that the scenes have been stored, we can link them by iterating through all of the locations
        for (Map.Entry location: locations.entrySet())
        {
            // the N E S W Scene array in each location
            String[] currentScenes = (String[])location.getValue();
            // go through each scene and set its left, right, and forward scenes
            for (int i = 0; i < currentScenes.length; i ++)
            {
                // Set left and right by incrementing/decrementing the indeces
                String left = currentScenes[modifyIndex(i-1, currentScenes.length)];
                String right = currentScenes[modifyIndex(i+1, currentScenes.length)];
                // Get the sceneForward map for the current scene
                Map.Entry nextSceneLocation = sceneForwards.get(currentScenes[i]).entrySet().iterator().next();
                
                // this is the actual scene object for the current scene
                Scene curLocation = scenes.get(currentScenes[i]);
                // set left and right scenes for the current scene
                curLocation.setLeft(scenes.get(left));
                curLocation.setRight(scenes.get(right));
                // if the scene actually has a next location (this could also be done with isBlocked()...)
                if (nextSceneLocation.getKey() != null)
                {
                    // the forward scene is obtained from the locations map using the nextSceneLocation map (which contains the next location location name and index for [N, E, S, W])
                    String forward = locations.get((String)nextSceneLocation.getKey())[(int)nextSceneLocation.getValue()];
                    curLocation.setForward(scenes.get(forward));
                }
            }
        }
        // the current scene is retrieved using the start data from the locations map (since we don't know its image)
        currentScene = scenes.get(locations.get(startingLocationName)[startingLocationDirection]);
    }
    
    /**
     * Modifies the an index to fit the [N, E, S, W] --> [0, 1, 2, 3] format of scene storage
     * @param index the index to be modified -- lowest value is -1, highest value is array length
     * @param arrLength the length of the array for which the thing is modified
     * @return a modified index, wrapped around if it is out of bounds
     */
    public int modifyIndex(int index, int arrLength)
    {
        // if the index is out of bounds too low, it is set as the greatest
        if (index < 0)
        {
            index = arrLength-1;
        }
        // if the index is out of bounds too high, it is set as the lowest
        if (index >= arrLength)
        {
            index = 0;
        }
        
        return index;
    }
    
    /**
     * Converts 
     * @param direction
     * @return 
     */
    public int convertDirectionToIndex(char direction)
    {
        switch(direction)
        {
            case 'N':
                return 0;
            case 'E':
                return 1;
            case 'S':
                return 2;
            case 'W':
                return 3;
            default:
                return -1;
        }
    }
    
    
}
