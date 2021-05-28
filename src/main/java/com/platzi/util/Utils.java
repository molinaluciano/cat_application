/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.util;

import com.platzi.model.Cats;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author lmolina
 */
public class Utils {
    
    public ImageIcon readImage(URL url) throws IOException{
        Image image = null;
        image = ImageIO.read(url);
        ImageIcon backgroundCat = new ImageIcon(image);
            
        if(backgroundCat.getIconWidth() > 800){
            // resize
            Image background = backgroundCat.getImage();
            Image updated = background.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);
            backgroundCat = new ImageIcon(updated);
        }
        return backgroundCat;
    }
    
}
