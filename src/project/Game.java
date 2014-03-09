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
    Ship avatarTwo;
    animateThread thread;
    ArrayList<Drawable> list = new ArrayList<Drawable>();
   
    javax.swing.Timer myTimer;
    String timeCheck = "okay";
    
    boolean window = true;
   
    Server serve;
    createClient client;
    
    String command;
   
    
    public Game(int person) throws IOException {
        player = person;
        
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
                    if (player == 1) {
                        avatar.moveLeft();
                        serve.setActionDone("moveLeft");
                    }
                    else if (player == 2) {
                        avatarTwo.moveLeft();
                        client.setCommand("moveLeft");
                    }   
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    
                    if (player == 1) {
                        avatar.moveRight();
                        serve.setActionDone("moveRight");
                    }
                    else if (player == 2) {
                        avatarTwo.moveRight();
                        client.setCommand("moveRight");
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if (player == 1) {
                        avatar.moveUp();
                        serve.setActionDone("moveUp");
                    }
                    else if (player == 2) {
                        avatarTwo.moveUp();
                        client.setCommand("moveUp");
                    }
                
                    //repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (player == 1) {
                        avatar.moveDown();
                        serve.setActionDone("moveDown");
                    }
                    else if (player == 2) {
                        avatarTwo.moveDown();
                        client.setCommand("moveDown");
                    }
                
                    //repaint();        
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE ) {

                     if (player == 1) {
                        avatar.shoot();
                        serve.setActionDone("shoot");
                    }
                    else if (player == 2) {
                        avatarTwo.shoot();
                        client.setCommand("shoot");
                    }

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
                    serve = new Server();
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
