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
    private String ip;
    int player;
    
    
    
    String command;
    
    int xOrder;
    int yOrder;
    
    int xSend;
    int ySend;
    
    InetAddress host = null;

    /**
     *
     */
    public createClient() {
        xOrder = 1;
        yOrder = 1;
        
        
        
        command = null;
         
         
        run();
    }
    
    public void setCommand (String act) {
        command = act;
        
    }
    
    public void setPosition(int xP, int yP) {
        xSend = xP;
        ySend = yP;
        run();
    }
    
    public String getCommand() {
        return command;
    }
    
    public int getXOrder() {
        return xOrder; //should be called by Game class
    }
    
    public int getYOrder() {
        return yOrder;
    }
    
    @Override
    public void run() {
       //Client below
   
        
        Thread c = new Thread() {
    DataOutputStream XDOut; //stuff that is sent out
    DataOutputStream YDOut;
    
    DataInputStream XDIn; //stuff that is received
    DataInputStream YDIn;
            
               @Override
               public void run() {
    
                   
                   try {
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            System.out.println("Error in getting InetAddress;");
        }
        ip = host.getHostAddress();
        
         try {
               sock = new Socket(ip, 8888);
               
           } catch (IOException ex) {
               System.out.println("Error in making Socket");
           }
          try {
                       XDIn = new DataInputStream(sock.getInputStream());
                   } catch (IOException ex) {
                       System.out.println("Fatal Error -XDin - Client");
                   }
                  
                   try {
                       xOrder = XDIn.readInt();
                   } catch (IOException ex) {
                       System.out.println("Error in reading XDIn as int");
                   }
                   
                          

                       try {
                  
                           XDOut = new DataOutputStream(sock.getOutputStream());
                              
                          
                           XDOut.writeInt(xSend);
                          
                           XDOut.flush();
                           
                       } catch (IOException ex) {
                           System.out.println("Error!");
                       }
                       
                       command = null;
                       
            }
               
            
               
        };
        c.start();
      }     
}
       
        
        
