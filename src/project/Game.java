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


public class Game extends Canvas implements Runnable {
    
    boolean window = true;
    
  //  final Ship avatar = new Ship();
    
    public Game() throws IOException {
        
        setBackground(Color.WHITE);
        setSize(800,450);
        
       
        
        
        
       setVisible(true);
    }
    
     /**
      * This method should create a client, and a server.
     * @throws UnknownHostException
     * @throws IOException 
     */
    public void create() {
         
        
        String username = JOptionPane.showInputDialog("Enter a name you want to use: ");
       
        
       
       
        
        Thread t = new Thread(this);
        t.start();
    }
    
    public void join() throws IOException {
        
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
    
    @Override
    public void paint(Graphics g) {
        g.translate(50, 0);
        
        repaint();
    }

    /**
     * This run method should be the thread part.
     */
    @Override
    public void run() {
        
        
        
        
        /**
       while(window) {
           int i = 0;
           //TO DO LOGIC waawawawawawawawa
           System.out.println("checkTest " + i);
           i++;
       } */
    }
    
}
