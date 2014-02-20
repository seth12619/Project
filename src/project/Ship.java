/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.*;

/**
 *
 * @author Seth Legaspi/Marco Santos
 */
public class Ship extends Canvas {
    Color shipColor;
    BufferedImage shipAv; //Ship's image
    
    
    int xPos; //x position of image
    int yPos; // y position of image
    
    
    public Ship() {
    
    }
    
    /**
     * 
     * This will set an image to be used for a certain ship
     * @param i - Will determine if player 1 image will be used, or player 2
     * @throws java.io.IOException
     */
    public void setImage(int i) throws IOException {
        
        if (i == 1) {
        shipAv = ImageIO.read(new File("imageName.jpg"));
        }
        else 
        shipAv = ImageIO.read(new File("imageName2.jpg"));
    }
    
    
    /**
     * Will decrease y by 1 px by default, thus moving object 1px on screen
     */
    public void moveUp() {
        
    }
    
    /**
     * Will increase y by 1 px by default, thus moving object 1px on screen
     */
    public void moveDown() {
        
    }
    
    /**
     * Will increase x by 1 px by default, thus moving object 1px on screen
     */
    public void moveRight() {
        
    }
    
    /**
     * Will decrease x by 1 px by default, thus moving object 1px on screen
     */
    public void moveLeft() {
        
    }
    
    public void draw(Graphics g) {
        g.drawImage(shipAv, xPos, yPos, null);
        
    }
    
}
