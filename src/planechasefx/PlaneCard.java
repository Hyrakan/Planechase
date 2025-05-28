/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package planechasefx;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Simon Skroch
 */
public class PlaneCard {

    final private String name;
    final private ImageIcon image;

    public PlaneCard(String name) {
        this.name = name;
        ImageIcon planeImageIcon = new ImageIcon("assets/planes/" + name.toLowerCase() + ".jpg"); // Assuming images are stored in "assets/planes" with names matching the plane names
        Image scaledPlaneImage = planeImageIcon.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        planeImageIcon = new ImageIcon(scaledPlaneImage);
        image = planeImageIcon;
    }

    public String getName() {
        return name;
    }

    public ImageIcon getImage() {
        return image;
    }
    
}
