/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import java.io.*;
import static java.lang.Thread.sleep;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Seth Legaspi/Marco Santos
 */
public class createClient implements Runnable {
    String checker;
    
    Socket sock;
    PrintStream testOut;
    Scanner in;
    InetAddress ip = null;
    
    String command;
    
    
      
        ObjectOutputStream sendCommand = null; //stuff to be sent
        ObjectInputStream receiveCommand = null; //stuff to receive

    public createClient(String comm) {
        
        command = comm;
        run();
    }
    
    @Override
    public void run() {
       //Client below
           
        
        
        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            System.out.println("Error in obtaining local IP address");
        }
               
               while (true) {
            try {
                sendCommand = new ObjectOutputStream(sock.getOutputStream());
            } catch (IOException ex) {
                System.out.println("Error in Client - sendCommand/Outputstream");
            }
            try {
                //stuff to send
           
            sendCommand.writeObject(command);
            } catch (IOException ex) {
               System.out.println("Error in sending Command - Client");
            }
            try {
                //read stuff from server
                receiveCommand = new ObjectInputStream(sock.getInputStream());
            } catch (IOException ex) {
                System.out.println("Error in receiving command - client");
            }
            String action = null;
            try {
                action = (String)receiveCommand.readObject();
            } catch (IOException ex) {
                System.out.println("Error - receiving command - IOException");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error - receiving command - ClassNotFoundException");;
            }
            if (action.equals("moveRight")) {
                System.out.println("right");
            }
            if (action.equals("moveLeft")) {
                
            }
            if (action.equals("moveUp")) {
                
            }
            if (action.equals("moveDown")) {
                
            }
            
            
            //end of stuff to send
         
           try {
               sock = new Socket(ip, 8888);
           } catch (IOException ex) {
               System.out.println("Error in making Socket");
           }
           
             try {
            in = new Scanner(new InputStreamReader(sock.getInputStream()));
        } catch (IOException ex) {
            System.out.println("Error in getting InputStream");
        } 
             
        try {
            testOut = new PrintStream(sock.getOutputStream());
        } catch (IOException ex) {
            System.out.println("Error in getting OutputStream");
        }
       testOut.println("Test hello");
       testOut.flush();
       String t = in.nextLine(); //test message from server
       System.out.println(t);
      
                   
           }
                   
      }     
}
       
        
        
