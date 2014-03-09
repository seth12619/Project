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
    animateThread thread;
    ArrayList<Drawable> list = new ArrayList<Drawable>();
   
    javax.swing.Timer myTimer;
    String timeCheck = "okay";
    
    boolean window = true;
   
    Server serve;
    createClient client;
    
    String command;
   
    
    public Game(int person) {
        player = person;
        
        setBackground(Color.WHITE);
        setSize(800,450);
        
        avatar = new Ship(player, list);
        list.add(avatar);
   
         Thread t = new Thread(){
    @Override
    public void run() { 
            //stub stuff it should do
        while (true) {
           for ( Drawable a : list)
            {
                a.animate();
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
                    avatar.moveLeft();       
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    avatar.moveRight();
                    setCommand("moveRight");
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    avatar.moveUp();
                
                    //repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    avatar.moveDown();
                
                    //repaint();        
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE ) {

                     avatar.shoot();

                }
                     
                
                 
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
      
       }); 

       setVisible(true);
      }
    
    public void setCommand(String action) {
        command = action;
    }

    
     /**
      * This method will set Player as player one
     * 
     * @throws java.io.IOException
     */
    public void create() throws IOException {
         setPlayerOne();
         String username = JOptionPane.showInputDialog("Enter a name you want to use: ");
         avatar.setPlayer(player);
       Thread j = new Thread() {
            @Override
            public void run() {
                try {
                    serve = new Server(command);
                } catch (IOException ex) {
                    System.out.println("Error IOException Server");
                }
            }
        };
       j.start();
         
       
        
    }
    
   
    
    
        
   
    
    /**
     * This method will set player as player two
     * 
     */
    public void join() {
        setPlayerTwo();
        String username = JOptionPane.showInputDialog("Enter a name you want to use: ");
        avatar.setPlayer(player);
        Thread j = new Thread() {
            @Override
            public void run() {
                 client = new createClient("client");
            }
        };
       j.start();
        
        
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
        
        for ( Drawable a : list)
        {
            a.draw(g);
        }
        
       
    }

}
