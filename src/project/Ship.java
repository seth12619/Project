/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

/**
 *
 * @author Seth Legaspi/Marco Santos
 */
public final class Ship extends Canvas {
    Color shipColor;
    private BufferedImage shipAv; //Ship's image
    
    
    int xPos; //x position of image
    int yPos; // y position of image
    int hBLength; //length of hit box
    int hBWidth; //width of hit box
    int health; //how much damage before going dead

    
    
    public Ship(int player) {
        if (player == 1) {
        this.xPos = 20;
        this.yPos = 50;
        this.hBLength =60;
        this.hBWidth = 60;
        this.health = 100;
        } 
        else if (player == 2) {
        this.xPos = 20;
        this.yPos = 120;
        this.hBLength =60;
        this.hBWidth = 60;
        this.health = 100;
        }
        
        
        if (player == 1) {
         try {    
        shipAv = ImageIO.read(getClass().getResource("playerOne.jpg"));
        } catch (IOException e) {
            System.out.println("Sprite image loading error - shipAv Player 1");
        } }
        else if (player == 2) {
            try {
        shipAv = ImageIO.read(getClass().getResource("playerTwo.jpg"));
            } catch (IOException e) {
                System.out.println("Sprite image loading error - shipAv Player 2");
            }
            
      
        repaint();
        }
        
        
        //draw the hitbox here
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
    
    public void shoot() {
        //this would create an instance of the bullet class
    }
    
    public void takeDamage(int damage) {
        health = health - damage;
        if (health <= 0)
        {
            //dies
        }
    }
    
    public int getXPos(){
        return xPos;
    }
    
    public int getYPos(){
        return yPos;
    }
    
    public int getHBLength(){
        return hBLength;
    }
    
    public int getHBWidth(){
        return hBWidth;
    }
    
    public int getHealth(){
        return health;
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawImage(shipAv, xPos, yPos, null);
        
        
       
    }
    
}
