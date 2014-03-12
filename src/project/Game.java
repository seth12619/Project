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
 * Left is not working
 */


public class Game extends Canvas{
    int player;
    Ship avatar;
    Ship avatarTwo;
    
    animateThread thread;
    ArrayList<Drawable> list = new ArrayList<Drawable>();
   
    String timeCheck = "okay";
    
    Image backbuffer;
    
    boolean window = true;
    boolean movingUp = false;
    boolean movingDown = false;
    boolean movingLeft = false;
    boolean movingRight = false;
    boolean isShooting = false;
   
    Server serve;
    createClient client;
    
    String command;
    String order;
   
   
    
    public Game(int person) throws IOException {
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
         
         Thread d = new Thread() {
             
             @Override
             public void run() {
                 while (true) {
                     
                if (movingLeft == true) { //movingLeft
                     if (player == 1) {
                       
                        avatar.moveLeft();  
                        left();        
                       
                    }
                    else if (player == 2) {
                        
                        avatarTwo.moveLeft();
                        left();
                        
                    
                    }
                }
                 if (movingRight == true) { //moveRight
                     if (player == 1) {
                       
                        avatar.moveRight();  
                        right();
                    
                       
                    }
                    else if (player == 2) {
                        
                        avatarTwo.moveRight();
                        right();
                    
                  }
                 }
                 if (movingUp == true) {  //moveUp
                  if (player == 1) { 
                     
                        avatar.moveUp();
                        up();
                    
                        
                    }
                    else if (player == 2) {
                       
                        avatarTwo.moveUp();
                        up();
                        
                    }
                 }
                 
                 if (movingDown == true) { //moveDown
                 
                 if (player == 1) {
                        
                        avatar.moveDown();
                        down();
                    
                        
                    }
                    else if (player == 2) {
                       
                        avatarTwo.moveDown();
                        down();
                        
                    }
                 }
                 
                 if (isShooting == true) { //shooting
                 if (player == 1) {
                        avatar.shoot();
                        shoot();
                    }
                    else if (player == 2) {
                        avatarTwo.shoot();
                        shoot();
                    }
                 }
                 
                 try {
                     Thread.sleep(20);
                 } catch (InterruptedException ex) {
                     System.out.println("Thread sleep - actions Interrupted");
                 }
             }
             
             
             }
         };
         
         
                 int delay = 1; //in mill. sec.
                 ActionListener refresh = new ActionListener() {
                    
                     @Override
                     public void actionPerformed(ActionEvent ae) {
                         
                         if (player == 1) {
                             avatarTwo.setPos(serve.getXAction(), serve.getYAction());
                         }
                         if (player == 2) {
                             avatar.setPos(client.getXOrder(), client.getYOrder());
                             System.out.println("client xPos for player1: " + client.getXOrder());
                         }
                        
                     }
                 };
                 new javax.swing.Timer(delay, refresh).start();
            

t.start();
d.start();

        
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
                    movingLeft = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                   
                    movingRight = true;
                   
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                   
                    movingUp = true;
                    
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    
                    movingDown = true;
                     
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE ) {

                     isShooting = true;

                }
                     
                
                 
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {   
                    movingLeft = false;
               
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                   
                    movingRight = false;
                   
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                   
                    movingUp = false;
                    
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    
                    movingDown = false;
                     
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE ) {

                     isShooting = false;

                }
                
                if (e.getKeyCode() == KeyEvent.VK_V ) {
                    list.add(new Enemy(800, 50, 100, 50, 1, 5, list, 50));
                }
            }
      
       }); 
                

         

       setVisible(true);
      }

    
    @Override
    public void update(Graphics g) {
        paint(g);
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
     
                    serve = new Server();
         
   
    }
    
   
    
    
        
   
    
    /**
     * This method will set player as player two
     * 
     */
   public void join() {
        setPlayerTwo();
        String username = JOptionPane.showInputDialog("Enter a name you want to use: ");
        avatar.setPlayer(player); 
                 client = new createClient();

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
    
    public void left() {
        if (player == 1) {
            serve.setPosition(avatar.getXPos(), avatar.getYPos());
        }
        else if (player == 2) {
            client.setCommand("moveLeft");
            client.setPosition(avatarTwo.getXPos(), avatarTwo.getYPos());
            
        }
        
    }
    /**
     * actions
     */
    public void right() {
       
        if (player == 1) {
            serve.setActionDone("moveRight");
            serve.setPosition(avatar.getXPos(), avatar.getYPos());
        }
        else if (player == 2) {
            client.setCommand("moveRight");
            client.setPosition(avatarTwo.getXPos(), avatarTwo.getYPos());
            System.out.println("client sprite: " + avatarTwo.getXPos() + " , " + avatarTwo.getYPos());
        }
         
    }
    public void up () {
       
        if (player == 1) {
            serve.setActionDone("moveUp");
            serve.setPosition(avatar.getXPos(), avatar.getYPos());
        }
        else if (player == 2) {
            client.setCommand("moveUp");
            client.setPosition(avatarTwo.getXPos(), avatarTwo.getYPos());
        }
      
    }
    
    public void down() {
      
        if (player == 1) {
            serve.setActionDone("moveDown");
            serve.setPosition(avatar.getXPos(), avatar.getYPos());
        }
        else if (player == 2) {
            client.setCommand("moveDown");
            client.setPosition(avatarTwo.getXPos(), avatarTwo.getYPos());
        }
         
    }
    
    public void shoot() {
       
        if (player == 1) {
                        serve.setActionDone("shoot");
                    }
                    else if (player == 2) {
                        client.setCommand("shoot");
                    }
              
    }
    
    
    
    @Override
    public void paint(Graphics g) {
   
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
