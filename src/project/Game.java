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
    
    boolean movingUpTwo = false;
    boolean movingDownTwo = false;
    boolean movingLeftTwo = false;
    boolean movingRightTwo = false;
    boolean isShootingTwo = false;
    
    boolean movingUpRel = false;
    boolean movingDownRel = false;
    boolean movingLeftRel = false;
    boolean movingRightRel = false;
    boolean isShootingRel = false;
   
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
         Thread two = new Thread() {
             @Override
             public void run() {
                 while (true) {
                     if (movingLeftTwo= true) { //movingLeft
                     if (player == 1) {
                        avatarTwo.moveLeft();  
                    }
                    else if (player == 2) {           
                        avatar.moveLeft();
                    }
                     if (movingRightTwo == true) { //moveRight
                     if (player == 1) {     
                        avatarTwo.moveRight();  
      
                    }
                    else if (player == 2) {   
                        avatar.moveRight();
        
                  }
                 }
                      if (movingUpTwo == true) {  //moveUp
                  if (player == 1) { 
                        avatarTwo.moveUp();  
                    }
                    else if (player == 2) {               
                        avatar.moveUp();     
                    }
                 }
                      if (movingDownTwo == true) { //moveDown      
                 if (player == 1) {                 
                        avatarTwo.moveDown();

                    }
                    else if (player == 2) {      
                        avatar.moveDown();
                    }
                 }
                      if (isShootingTwo == true) { //shooting
                 if (player == 1) {
                        avatarTwo.shoot();
                      
                    }
                    else if (player == 2) {
                        avatar.shoot();
                        
                    }
                 }
                     
                }
                     
                 }
             }
         };
         two.start();

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
                             String checker;
                             checker = serve.getAction();
                             if (checker.equals("moveLeft")) {
                                 avatarTwo.moveLeft();
                             }
                             if (checker.equals("moveRight")) {
                                 avatarTwo.moveRight();
                             }
                             if (checker.equals("moveUp")) {
                                 avatarTwo.moveUp();
                             }
                             if (checker.equals("moveDown")) {
                                 avatarTwo.moveDown();
                             }
                             if (checker.equals("shoot")) {
                                 avatarTwo.shoot();
                             }
                             
                             // avatarTwo.setPos(serve.getXAction(), serve.getYAction());
                            //  serve.setPosition(avatar.getXPos(), avatar.getYPos());
                        
                         }
                         else if (player == 2) {
                             String checker;
                             checker = client.getCommand();
                             
                             if (checker.equals("moveLeft")) {
                                 movingLeftTwo = true;
                             }
                             if (checker.equals("moveRight")) {
                                 movingRightTwo = true;
                             }
                             if (checker.equals("moveUp")) {
                                 movingUpTwo = true;
                             }
                             if (checker.equals("moveDown")) {
                                 movingDownTwo = true;
                             }
                             if (checker.equals("shoot")) {
                                 isShootingTwo = true;
                             }
                             //Ones below are when false
                             if (checker.equals("moveLeftFalse")) {
                                 movingLeftTwo = false;
                             }
                             if (checker.equals("moveRightFalse")) {
                                 movingRightTwo = false;
                             }
                             if (checker.equals("moveUpFalse")) {
                                 movingUpTwo = false;
                             }
                             if (checker.equals("moveDownFalse")) {
                                 movingDownTwo = false;
                             }
                             if (checker.equals("shootFalse")) {
                                isShootingTwo = false;
                             }
                     
                           
                            // avatar.setPos(client.getXOrder(), client.getYOrder());
                            // client.setPosition(avatarTwo.getXPos(), avatarTwo.getYPos());
                         }
                         
                     }
                 };
                 new javax.swing.Timer(delay, refresh).start();
         
t.start();
d.start();

        
       addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_A) {   
                    movingLeft = true;             
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                   
                    movingRight = true;
                   
                }
                if (e.getKeyCode() == KeyEvent.VK_W) {
                   
                    movingUp = true;
                    
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    
                    movingDown = true;
                     
                }
                if (e.getKeyCode() == KeyEvent.VK_M ) {

                     isShooting = true;

                }
              
                
                 
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_A) {   
                    movingLeft = false;
                    if (player == 1) {
                    serve.sendCommand("moveLeftFalse");
                    }
                    if (player == 2) {
                    client.sendCommand("moveLeftFalse");
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                   
                    movingRight = false;
                   if (player == 1) {
                    serve.sendCommand("moveDownFalse");
                    }
                    if (player == 2) {
                    client.sendCommand("moveDownFalse");
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_W) {
                   
                    movingUp = false;
                    if (player == 1) {
                    serve.sendCommand("moveUpFalse");
                    }
                    if (player == 2) {
                    client.sendCommand("moveUpFalse");
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    
                    movingDown = false;
                    if (player == 1) {
                    serve.sendCommand("moveDownFalse");
                    }
                    if (player == 2) {
                    client.sendCommand("moveDownFalse");
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_M ) {

                     isShooting = false;
                     if (player == 1) {
                    serve.sendCommand("shootFalse");
                    }
                    if (player == 2) {
                    client.sendCommand("shootFalse");
                    }
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
   public void join() throws IOException {
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
    
 
    /**
     * actions
     */
    public void left() {
        if (player == 1) {
            serve.sendCommand("moveLeft");
        }
        else if (player == 2) {
            client.sendCommand("moveLeft");
        }
    }
    
    public void right() {
       
        if (player == 1) {
            serve.sendCommand("moveRight");
        }
        else if (player == 2) {
            client.sendCommand("moveRight");
        }
         
    }
    public void up () {
       
        if (player == 1) {
            serve.sendCommand("moveUp");
            
        }
        else if (player == 2) {
            client.sendCommand("moveUp");
            
        }
      
    }
    
    public void down() {
      
        if (player == 1) {
            serve.sendCommand("moveDown");
           
        }
        else if (player == 2) {
            client.sendCommand("moveDown");
           
        }
         
    }
    
    public void shoot() {
       
        if (player == 1) {
                        serve.sendCommand("shoot");
                    }
                    else if (player == 2) {
                        client.sendCommand("shoot");
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
