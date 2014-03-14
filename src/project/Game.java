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
         Thread two = new Thread() { //Thread two is for the stuff given to this certain client
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
                      try {
                     Thread.sleep(20);
                 } catch (InterruptedException ex) {
                     System.out.println("Thread sleep - actions Interrupted");
                 }
                }
                     
                 }
             
         };
         two.start();
         
          Thread twoFalse = new Thread() { //Thread two is for the stuff given to this certain client
             @Override
             public void run() {
                 while (true) {
                     if (movingLeftRel== true) { //movingLeft
                            if (player == 1) {
                           serve.sendCommand("moveLeftFalse");
                           }
                           else if (player == 2) {
                           client.sendCommand("moveLeftFalse");
                           }
                     }
                     if (movingRightRel == true) { //moveRight
                           if (player == 1) {
                           serve.sendCommand("moveRightFalse");
                           }
                           else if (player == 2) {
                           client.sendCommand("moveRightFalse");
                           }
                 }
                      if (movingUpRel == true) {  //moveUp
                            if (player == 1) {
                            serve.sendCommand("moveUpFalse");
                            }
                            else if (player == 2) {
                            client.sendCommand("moveUpFalse");
                            }
                 }
                      if (movingDownRel == true) { //moveDown      
                                if (player == 1) {
                                serve.sendCommand("moveDownFalse");
                                }
                                else if (player == 2) {
                                client.sendCommand("moveDownFalse");
                                }
                 }
                      if (isShootingRel == true) { //shooting
                                if (player == 1) {
                               serve.sendCommand("shootFalse");
                               }
                               else if (player == 2) {
                               client.sendCommand("shootFalse");
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
         twoFalse.start();


         Thread d = new Thread() {    // Thread d is for actions in this certain client.        
             @Override
             public void run() {
                 while (true) {     
                if (movingLeft == true) { //movingLeft
                     if (player == 1) {
                        avatar.moveLeft();  
                        serve.sendCommand("moveLeft");
                    }
                    else if (player == 2) {           
                        avatarTwo.moveLeft();
                        client.sendCommand("moveLeft");
                    }
                }
                 
                 if (movingRight == true) { //moveRight
                     if (player == 1) {     
                        avatar.moveRight();  
                        serve.sendCommand("moveRight");
                    }
                    else if (player == 2) {   
                        avatarTwo.moveRight();
                        client.sendCommand("moveRight");    
                  }
                 }
                
                 if (movingUp == true) {  //moveUp
                  if (player == 1) {                  
                        avatar.moveUp();
                        serve.sendCommand("moveUp");     
                    }
                    else if (player == 2) { 
                        avatarTwo.moveUp();
                        client.sendCommand("moveUp");           
                    }
                 }             
                 
                 if (movingDown == true) { //moveDown      
                 if (player == 1) {  
                        avatar.moveDown();
                        serve.sendCommand("moveDown");
                    }
                    else if (player == 2) {      
                        avatarTwo.moveDown();
                        client.sendCommand("moveDown");                    
                    }
                 }
                 
                 
                 if (isShooting == true) { //shooting
                 if (player == 1) {
                        avatar.shoot();
                        serve.sendCommand("shoot");
                    }
                 else if (player == 2) {
                        avatarTwo.shoot();
                        client.sendCommand("shoot");
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
                             String checker;
                             boolean shootChecker;
                             boolean leftChecker;
                             boolean rightChecker;
                             boolean upChecker;
                             boolean downChecker;
                             
                             checker = "";
                             shootChecker = false;
                             leftChecker = false;
                             rightChecker = false;
                             upChecker = false;
                             downChecker = false;
                            
                              if (player == 1) {
                             checker = serve.getAction();    
                             shootChecker = serve.getShoot();
                             leftChecker = serve.getLeft();
                             rightChecker = serve.getRight();
                             upChecker = serve.getUp();
                             downChecker =  serve.getDown();
                              }
                              
                              
                               if (player == 2) {
                             checker = client.getCommand();       
                             shootChecker = client.getShoot();
                             leftChecker = client.getLeft();
                             rightChecker = client.getRight();
                             upChecker = client.getUp();
                             downChecker = client.getUp();
                              }
                               
                               
                             if (leftChecker == true) {
                                 movingLeftTwo = true;
                             }
                             if (rightChecker == true) {
                                 movingRightTwo = true;
                             }
                             if (upChecker == true) {
                                 movingUpTwo = true;
                             }
                             if (downChecker == true) {
                                 movingDownTwo = true;
                             }
                             if (shootChecker == true) {
                                 isShootingTwo = true;
                             }
                             //ones below are false  
                             if (downChecker == false) {
                                 movingDownTwo = false;
                             }
                             if (upChecker == false) {
                                 movingUpTwo = false;
                             }
                             if (leftChecker == false) {
                                 movingLeftTwo = false;
                             }
                             if (rightChecker == false) {
                                 movingRightTwo = false;
                             }
                             if (shootChecker == false) {
                                 isShootingTwo = false;
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
                    movingLeftRel= false;
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                   
                    movingRight = true;
                    movingRightRel= false;
                }
                if (e.getKeyCode() == KeyEvent.VK_W) {
                   
                    movingUp = true;
                    movingUpRel= false;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    
                    movingDown = true;
                    movingDownRel= false;
                }
                if (e.getKeyCode() == KeyEvent.VK_M ) {

                     isShooting = true;
                     isShootingRel= false;
                }
              
                
                 
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_A) {   
                    movingLeft = false;
                    movingLeftRel= true;
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                   
                    movingRight = false;
                    movingRightRel = true;
                   
                }
                if (e.getKeyCode() == KeyEvent.VK_W) {
                   
                    movingUp = false;
                    movingUpRel = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    
                    movingDown = false;
                    movingDownRel = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_M ) {

                     isShooting = false;
                     isShootingRel = true;
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
        if (player == 2) {
            client.sendCommand("moveLeft");
        }
    }
    
    public void right() {
        if (player == 1) {
            serve.sendCommand("moveRight");
        }
        if (player == 2) {
            client.sendCommand("moveRight");
        }
         
    }
    public void up () {
       
        if (player == 1) {
            serve.sendCommand("moveUp");
        }
        if (player == 2) {
            client.sendCommand("moveUp");      
        }
      
    }
    
    public void down() {
        if (player == 1) {
            serve.sendCommand("moveDown");   
        }
        if (player == 2) {
            client.sendCommand("moveDown");       
        }     
    }
    
    public void shoot() {
                    if (player == 1) {
                        serve.sendCommand("shoot");
                    }
                    if (player == 2) {
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
