/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

/**
 *
 * @author johns6971
 */
public class Scene {
    private String picture;
    private char direction;
    private boolean frontBlocked;
    
    private Scene left;
    private Scene right;
    private Scene forward;
    
    public Scene(String picture, char direction, boolean frontBlocked) {
        this.picture = picture;
        this.direction = direction;
        this.frontBlocked = frontBlocked;
    }
    
    public void setLeft(Scene s) {
        this.left = s;
    }
    
    public void setRight(Scene s) {
        this.right = s;
    }
    
    public void setForward(Scene s) {
        this.forward = s;
    }
    
    
    
    
    
    
    
}
