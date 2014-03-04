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

/**
 *
 * @author Seth Legaspi/Marco Santos
 */
public class Game extends Canvas implements Runnable {
    Socket sock;
    PrintStream testOut;
    Scanner in;
    boolean window = true;
    
    public Game() throws IOException {
        JPanel game = new JPanel();
        game.setLayout(new BorderLayout());
        game.setSize(800,450);
       
        
        
        
        game.setVisible(true);
    }
    
    public void create() throws UnknownHostException, IOException {
        InetAddress ip = InetAddress.getLocalHost();
        String username = JOptionPane.showInputDialog("Enter a name you want to use: ");
        
        sock = new Socket(ip, 8888);
        testOut = new PrintStream(sock.getOutputStream());
        in = new Scanner(new InputStreamReader(sock.getInputStream()));
        
        testOut.println(username);
        
        Server create = new Server(); //create server
        
        Thread t = new Thread(this);
        t.start();
    }
    
    
    public String Test(String Input) {
        String potato;
        
        potato = (Input + " is a potato.");
        
        return potato;
        
    }
    
    public void setWindowStatus() {
    window = false;
}

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
