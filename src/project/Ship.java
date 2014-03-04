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
        xPos = 15;
    }
    
    /**
     * 
     * This will set an image to be used for a certain ship
     * @param i - Will determine if player 1 image will be used, or player 2
     * @throws java.io.IOException
     */
    public void setImage(int i) throws IOException {
        
        if (i == 1) {
        shipAv = ImageIO.read(new File("playerOne.png"));
        yPos = 20;
        repaint();
        }
        else {
        shipAv = ImageIO.read(new File("playerTwo.png"));
        yPos = 50;
        repaint();
        }
    }
    
    
    /**
     * Will decrease y by 1 px by default, thus moving object 1px on screen
     */
    public void moveUp() {
        yPos = yPos-2;
        repaint();
    }
    
    /**
     * Will increase y by 1 px by default, thus moving object 1px on screen
     */
    public void moveDown() {
        yPos = yPos+2;
        repaint();
    }
    
    /**
     * Will increase x by 1 px by default, thus moving object 1px on screen
     */
    public void moveRight() {
        xPos = xPos+2;
        repaint();
    }
    
    /**
     * Will decrease x by 1 px by default, thus moving object 1px on screen
     */
    public void moveLeft() {
         xPos = xPos-2;
         repaint();
    }
    
    public void draw(Graphics g) {
        g.drawImage(shipAv, xPos, yPos, null);
        
    }
    
}
