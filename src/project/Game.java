/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Seth Legaspi/Marco Santos
 */


public class Game extends Canvas {
    int player;
    Ship avatar;
    
    
    boolean window = true;
    ArrayList keysPressed = new ArrayList<>();
    
  //  final Ship avatar = new Ship();
    
    public Game(int person) {
        player = person;
        
        setBackground(Color.WHITE);
        setSize(800,450);
        
        avatar = new Ship(player);
        repaint();
        
       
       
        
        /**
         * Note: Add collision so the avatar sprite ship won't go over bounds.
         */
       addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                keysPressed.add(e.getKeyCode());
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {   
                    avatar.moveLeft();       
                   /* if (keysPressed.contains(KeyEvent.VK_UP)) {
                        avatar.moveUp();
                    }
                    if (keysPressed.contains(KeyEvent.VK_DOWN)) {
                        avatar.moveDown();
                    } */
                    
                    repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    avatar.moveRight();
                /*    if (keysPressed.contains(KeyEvent.VK_UP)) {
                        avatar.moveUp();
                    }
                    if (keysPressed.contains(KeyEvent.VK_DOWN)) {
                        avatar.moveDown();
                    }  */
                    repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    avatar.moveUp();
                  /*  if (keysPressed.contains(KeyEvent.VK_LEFT)) {
                        avatar.moveLeft();
                    }
                    if (keysPressed.contains(KeyEvent.VK_RIGHT)) {
                        avatar.moveRight();
                    } */
                    repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    avatar.moveDown();
                  /*  if (keysPressed.contains(KeyEvent.VK_LEFT)) {
                        avatar.moveLeft();
                    }
                    if (keysPressed.contains(KeyEvent.VK_RIGHT)) {
                        avatar.moveRight();
                    } */
                    repaint();        
                }
                 if (e.getKeyCode() == KeyEvent.VK_SPACE ) {
                    avatar.shoot();
                    System.out.println("Sex");
                }
                
                 
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
              keysPressed.remove(KeyEvent.VK_UP);
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                  keysPressed.remove(KeyEvent.VK_DOWN);
                }
                else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                  keysPressed.remove(KeyEvent.VK_RIGHT);
                }
                else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                  keysPressed.remove(KeyEvent.VK_LEFT);
                }

                
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
        
        avatar.draw(g);
        
       
    }

}
