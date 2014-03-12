/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

/**
 *
 * @author Seth Legaspi/Marco Santos
 */
public final class Server implements Runnable {
     private static ServerSocket server = null; 
     private static int portNu = 8888;
     String actionDone;
     
     Scanner sc;
     PrintStream out;
     
     Socket client; //creates socket
     
     int XAct;
     int YAct;
     
      //stuff that is sent out
      DataOutputStream YDOut;
    
      DataInputStream XDIn; //stuff that is received
      DataInputStream YDIn;
      
     int xSend;
     int ySend;
  
    public Server() throws IOException {
        xSend = 2;
        ySend = 2;
        actionDone = null;
          
           
        
                 run();
            
     
                 }
    
    public void setActionDone(String act) {
        actionDone = act;
        
        
    }
    
    public void setPosition(int xP, int yP) {
        xSend = xP;
        ySend = yP;
        run();
    }
    
    public String getAction () {
        return actionDone;
    }
    
    public int getXAction () {
        return XAct;
    }
    public int getYAction() {
        return YAct;
    }
   
    @Override
    public void run() {
         
        Thread  s = new Thread() {
            
            
            @Override
            public void run() {
                
                try {
                server = new ServerSocket( 8888 );
            } catch (IOException ex) {
                System.out.println("Error -- ServerSocket");
            }
           try {
                //waits for client request
                client = server.accept();
            } catch (IOException ex) {
                System.out.println("Error in accepting request from client");;
            }
                
        while( actionDone != null ) { 
           
           try {
                      XDIn = new DataInputStream(client.getInputStream());
                   } catch (IOException ex) {
                       System.out.println("Fatal Error -XDin - Client");
                   }
               
                   try {
                       XAct = XDIn.readInt();
                   } catch (IOException ex) {
                       System.out.println("Error in reading XDIn as int");
                   }
                 

       
                       try {
                  
                           DataOutputStream XDOut = new DataOutputStream(client.getOutputStream());
                               
                          
                           XDOut.writeInt(xSend);
                          
                           XDOut.flush();
                          
                       } catch (IOException ex) {
                           System.out.println("Error!");
                       }
                       actionDone = null;
        }
            }
             };
          s.start();
       
    }
    
}
