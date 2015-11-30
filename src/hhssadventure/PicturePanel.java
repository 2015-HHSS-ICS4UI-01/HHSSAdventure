package hhssadventure;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;


/**
 * A custom JComponent that will contain an image
 * @author NathanKampzEtAndrewSSS
 */
public class PicturePanel extends JComponent {
    private BufferedImage image = null;
    
    /**
     * Painting the image
     * @param g the graphics object
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(image != null){
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
    
    /**
     * Sets the image of the panel to display
     * @param img the BufferedImage to load in
     */
    public void setImage(BufferedImage img){
        this.image = img;
        repaint();
    }
}
