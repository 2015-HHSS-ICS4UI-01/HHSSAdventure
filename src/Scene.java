/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author vonhn0812
 */
public class Scene {
private String direction;
boolean FrontBlocked;
boolean front;
boolean left;
boolean right;

public void FrontBlocked(){
    if(front == false){
      FrontBlocked = true;
      left = true;
      right = true;
    }else{
        front = true;
        left = true;
        right = true;
    }
    
}
}
