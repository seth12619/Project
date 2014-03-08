/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.*;

import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/**
 *
 * @author Seth Legaspi/Marco Santos
 */


public class Game extends Canvas implements Runnable {
    int player;
    Ship avatar;
    animateThread thread;
    ArrayList<Drawable> list = new ArrayList<Drawable>();
   
    
    public Game(int person) throws LWJGLException {
        player = person;
        
        setBackground(Color.WHITE);
        setSize(800,450);
       

        
        avatar = new Ship(player);
        list.add(avatar);
        repaint();
        ///
        try {
	    Display.setDisplayMode(new DisplayMode(800, 600));
	    Display.create();
	} catch (LWJGLException e) {
	    e.printStackTrace();
	    System.exit(0);
	}

	

        while (!Display.isCloseRequested()) {
 
	    
	    Display.update();
            
	}

	Display.destroy();
        System.exit(1);
        
        
        
        ///
      
        
       while(Keyboard.next()) {
           processArrowKeys();
       }
       
       

        /**
         * Note: Add collision so the avatar sprite ship won't go over bounds.
         */
       addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
                if (e.getKeyCode() == KeyEvent.VK_SPACE ) {
                    avatar.shoot();
                    
                    System.out.println("Pew Pew Pew!");
                    repaint();
                }
                
                 
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
      
       }); 

       setVisible(true);
      }

    
     /**
      * This method will set Player as player one
     * 
     */
    public void create() {
         setPlayerOne();
         String username = JOptionPane.showInputDialog("Enter a name you want to use: ");
         avatar.setPlayer(player);
        
       
       
        repaint();
    }
    
   
    
    
        
   
    
    /**
     * This method will set player as player two
     * 
     */
    public void join() {
        setPlayerTwo();
        String username = JOptionPane.showInputDialog("Enter a name you want to use: ");
        avatar.setPlayer(player);
        repaint();
    }
    
    /**
     * Method below makes use of the LWJGT third party library's arrow key constructors
     */
     public final void processArrowKeys() {
    if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
     avatar.moveDown();
     repaint();      
    }
    if(Keyboard.isKeyDown(Keyboard.KEY_UP)) {
      avatar.moveUp();
      repaint();
    }
    
    if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
     avatar.moveLeft();       
     repaint();
    }
    if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
     avatar.moveRight();
     repaint();
    }
  }
    
    
    public String Test(String Input) {
        String potato;
        
        potato = (Input + " is a potato.");
        
        return potato;
        
    }
    
    /**
     * This method will setWindow status to false upon closing of the JFrame, to stop all threads or servers
     */
   
    
    /**
     * The two methods below will set what player this is; it will also help in movement methods
     */
    public void setPlayerOne() {
        player = 1;
    }
    public void setPlayerTwo() {
        player = 2;  
    }
    
    
    
    @Override
    public void paint(Graphics g) {
        
        for ( Drawable a : list)
        {
            a.draw(g);
        }
        
       
    }

    @Override
    public void run() {
         processArrowKeys();
    }

}
