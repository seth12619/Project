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
    Socket sock;
    PrintStream testOut;
    Scanner in;
    boolean window = true;
    
    final Ship avatar = new Ship();
    
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
        try {
            avatar.setImage(1);
        } catch (IOException ex) {
            System.out.println("Error in setting up avatar Image");
        }
        InetAddress ip = null;
        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            System.out.println("Error in obtaining local IP address");
        }
        String username = JOptionPane.showInputDialog("Enter a name you want to use: ");
        try {
            sock = new Socket(ip, 8888);
        } catch (IOException ex) {
            System.out.println("Error in creating new socket");
        }
        try {
            testOut = new PrintStream(sock.getOutputStream());
        } catch (IOException ex) {
            System.out.println("Error in getting OutputStream");
        }
        try {
            in = new Scanner(new InputStreamReader(sock.getInputStream()));
        } catch (IOException ex) {
            System.out.println("Error in getting InputStream");
        }
        
        testOut.println(username);
        try {
            Server create = new Server(); //create server
        } catch (IOException ex) {
            System.out.println("Error in Creating Server");
        }
        
        Thread t = new Thread(this);
        t.start();
    }
    
    public void join() throws IOException {
        avatar.setImage(2);
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
        avatar.draw(g);
        repaint();
    }

    /**
     * This run method should be the thread part.
     */
    @Override
    public void run() {
       while(window) {
           int i = 0;
           //TO DO LOGIC waawawawawawawawa
           System.out.println("checkTest " + i);
           i++;
       }
    }
    
}
