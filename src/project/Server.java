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
     
      
      
     int xSend;
     int ySend;
     
     boolean wait = true;
 
  
    public Server() throws IOException {
          
                server = new ServerSocket( 8888 );
         
                //waits for client request
                client = server.accept();
                
                out = new PrintStream(client.getOutputStream());
                
                 Thread s = new Thread(this);
                 s.start();
                 }
    
    public void setActionDone(String act) {
        actionDone = act;  
    }
    
    public void sendCommand (String act) {
        out.println(act);
    }
    
    public String getAction () {
        return actionDone;
    }
    
    @Override
    public void run() {
         
      try {
            sc = new Scanner(new InputStreamReader(client.getInputStream()));
        } catch (IOException ex) {
            return;
        }
      
      while (wait) {
          actionDone = "";
          
           try {
      setActionDone(sc.nextLine());
       } catch (Exception e) {
               wait = false;
               break;
           }
                   System.out.println("the command: " + actionDone);
      }             

    }
}
