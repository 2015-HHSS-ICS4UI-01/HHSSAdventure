
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
public class Student {
    private String name;
    private String homeRoom;
    private int studentNumber;
    private boolean isSpecialist;
    private String specialist; 
    
    //constructor to create student from a file
    public Student(Scanner input){
        name = input.next();
        homeRoom = input.next();
        studentNumber = input.nextInt();
        String check = input.next();
        if(check.equals("y")){
            isSpecialist = true;
            specialist = input.nextLine();
        }else{
            isSpecialist = false;
            input.nextLine();
        }
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getStudentNumber(){
        return this.studentNumber;
    }
    
    public String getHomeRoom(){
        return this.homeRoom;
    }

    public boolean isSpecialist(){
        return this.isSpecialist;
    }
    
    public String getSpecialist(){
        return this.specialist;
    }
}
