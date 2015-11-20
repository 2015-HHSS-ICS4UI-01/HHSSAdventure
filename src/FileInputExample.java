
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alimu
 */
public class FileInputExample {
    //an array list to store classes
    //just like our list ADT lessons

    private ArrayList<Class> classes = new ArrayList<Class>();
    private Interface gui;
    private int classNum = 0;
    public FileInputExample() {

        //used to help read a file
        FileReader file = null;
        try {
            file = new FileReader("students/students.txt");
        } catch (Exception e) {
            //prints out error message
            e.printStackTrace();
            //stops the program
            System.exit(0);
        }

        //creates a scanner to read the file
        Scanner input = new Scanner(file);

        //keep scanning as long as theres something to scan
        while (input.hasNext()) {
            //adding a class from the file
            Class c = new Class(input);
            //addint the clas to the list
            classes.add(c);
        }
        
        gui = new Interface(this);
        //set the text for the next class name
        Class c = classes.get(classNum);
        gui.setClassName(c.getCourseCode());
        //show it
        gui.setVisible(true);
    }
    
    public void nextClass(){
        //if classNum +1 is less than numClasses
        
        if(classNum < classes.size()-1){
            //advance to next class
            classNum++;
        }
        //set the text for the next class name
        Class c = classes.get(classNum);
        
        gui.setClassName(c.getCourseCode());
    }
    
    public void prevClass(){
         //if classNum +1 is less than numClasses
        
        if(classNum > 0){
            //advance to next class
            classNum--;
        }
        //set the text for the next class name
        Class c = classes.get(classNum);
        gui.setClassName(c.getCourseCode());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileInputExample f = new FileInputExample();
    }

}
