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
     
     Socket client = null; //creates socket
     
     int XAct;
     int YAct;
     
      DataOutputStream XDOut; //stuff that is sent out
      DataOutputStream YDOut;
    
      DataInputStream XDIn; //stuff that is received
      DataInputStream YDIn;
      
     int xSend;
     int ySend;
  
    public Server() throws IOException {
        
        actionDone = null;
          try {
                server = new ServerSocket( 8888 );
                
            } catch (IOException ex) {
                System.out.println("Error -- ServerSocket");
            }
           
        
        run();
    }
    
    public void setActionDone(String act) {
        actionDone = act;
        
        
    }
    
    public void setPosition(int xP, int yP) {
        xSend = xP;
        ySend = yP;
        
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
        while( true ) { //while (command != null)
           try {
                //waits for client request
                client = server.accept();
            } catch (IOException ex) {
                System.out.println("Error in accepting request from client");;
            }
           try {
                       XDIn = new DataInputStream(client.getInputStream());
                   } catch (IOException ex) {
                       System.out.println("Fatal Error -XDin - Client");
                   }
                   try {
                       YDIn = new DataInputStream(client.getInputStream());
                   } catch (IOException ex) {
                       System.out.println("Fatal Error - YDin - Client");
                   }
                   try {
                       XAct = XDIn.readInt();
                   } catch (IOException ex) {
                       System.out.println("Error in reading XDIn as int");
                   }
                   try {
                       YAct = YDIn.readInt();
                   } catch (IOException ex) {
                       System.out.println("Error in reading YDIn as int");
                   }

       
                       try {
                  
                               XDOut = new DataOutputStream(client.getOutputStream());
                               YDOut = new DataOutputStream(client.getOutputStream());
                          
                           XDOut.writeInt(xSend);
                           YDOut.writeInt(ySend);
                           XDOut.flush();
                           YDOut.flush();
                       } catch (IOException ex) {
                           System.out.println("Error!");
                       }
            }

            
        }
            
        };
        s.start();
    }
    
}
