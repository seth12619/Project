/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 package project;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.*;

import java.awt.event.*;
import java.awt.Image;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Seth Legaspi/Marco Santos
 */


public class Game extends Canvas{
    int player;
    Ship avatar;
    Ship avatarTwo;
    
    animateThread thread;
    ArrayList<Drawable> list = new ArrayList<Drawable>();
   
    javax.swing.Timer myTimer;
    String timeCheck = "okay";
    
    Image backbuffer;
    
    boolean window = true;
   
    
   
    
    public Game(int person) {
        player = person;
        
        backbuffer = createImage(800, 450);
        setBackground(Color.WHITE);
        setSize(800,450);
        
        avatar = new Ship(1, list);
        avatarTwo = new Ship(2, list);
        
        list.add(avatar);
        list.add(avatarTwo);
        
         if (player == 1) {
            create();
        }
        else if (player == 2) {
            join();
        }
   
         Thread t = new Thread(){
    @Override
    public void run() { 
            //stub stuff it should do
        while (true) {
            
            try{
           for ( Drawable a : list)
            {
                a.animate();
            }
        }
        catch (ConcurrentModificationException ex)
        {
            
        }
            repaint();
            try {
                Thread.sleep(10);  //will make thread sleep
            } catch (InterruptedException ex) {
                System.out.println("Thread's sleep thingie was interrupted");
         }
        }
        
        
    }
    
};

t.start();
        
        /**
         * Note: Add collision so the avatar sprite ship won't go over bounds.
         */
       addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {   
                    if (avatar.getXPos() >0)
                    {
                        avatar.moveLeft();   
                    }
                  
                    //repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (avatar.getXPos() +118 < 800)
                    {
                        avatar.moveRight();
                    }
                    //repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if(avatar.getYPos() > 0)
                    {
                        avatar.moveUp();
                    }
                    //repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (avatar.getYPos() + 88 <= 450)
                    {
                        avatar.moveDown();
                    }
                    //repaint();        
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE ) {
                     //int delay = 50;
                     avatar.shoot();
                    // ActionListener doIt = new ActionListener() {
                       
                        /*
                         @Override
                         public void actionPerformed(ActionEvent e) {
                            avatar.animate();
                             repaint();
                         }
                     };
                      if (timeCheck.equals("okay")) { 
                       myTimer = new javax.swing.Timer(delay, doIt);
                        timeCheck = "NO";
                        System.out.println("Pew Pew Pew!");
                        repaint();
                      }
                      myTimer.start();
                      */
                }
                     
                
                 
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
      
       }); 

       setVisible(true);
      }

    
    public void update(Graphics g) {
        paint(g);
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
    
    
    public String Test(String Input) {
        String potato;
        
        potato = (Input + " is a potato.");
        
        return potato;
        
    }
    
    /**
     * This method will setWindow status to false upon closing of the JFrame, to stop all threads or servers
     */
    public void setWindowStatus() {
    window = false;
}
    
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
        
        //if(backbuffer==null) 
        backbuffer = createImage(800, 450);
        Graphics backg = backbuffer.getGraphics();
        
        try
        {
        for ( Drawable a : list)
        {
            a.draw(backg);
        }
    }
    
    catch (ConcurrentModificationException ex)
    {
    }
        
    g.drawImage(backbuffer, 0, 0, this);
       
    }

}