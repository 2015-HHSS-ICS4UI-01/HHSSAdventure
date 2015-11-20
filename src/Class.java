
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
public class Class {
    
    private String courseCode;
    private int numStudents;
    private Student[] students;
    
    //constructor using a text file
    public Class(Scanner input){
        courseCode = input.nextLine();
        numStudents = input.nextInt();
        //mmoving to the next line
        input.nextLine();
        //creating the student array
        students = new Student[numStudents];
        //create the students
        for (int i = 0; i < numStudents; i++) {
            //create a student
            Student s = new Student(input);
            //put all students in list
            students[i] = s;
        }
    }
    
    /**
     * Returns the course code of the class
     * @return the course code
     */
    public String getCourseCode(){
        return this.courseCode;
    }
    
    /**
     * Returns the number of students in the class
     * @return the number of students
     */
    public int getNumberOfStudents(){
        return this.numStudents;
    }
    
    public String getStudentName(int position){
        return students[position].getName();
    }
    
}
