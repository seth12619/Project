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
  
    public Server() throws IOException {
        
        actionDone = "waiting...";
        Scanner sc = null;
        PrintStream out = null;
        run();
    }
    
    public void setActionDone(String act) {
        actionDone = act;
    }
    
    public String getAction () {
        return actionDone;
    }
   
    @Override
    public void run() {
         Socket client = null; //creates socket
          try {
                server = new ServerSocket( 8888 );
                
            } catch (IOException ex) {
                System.out.println("Error -- ServerSocket");
            }
        while(true) {
           
            
          
            
            try {
                System.out.println("Waiting for client request");
                //waits for client request
                client = server.accept();
            } catch (IOException ex) {
                System.out.println("Error in accepting request from client");;
            }
            try {
                sc = new Scanner( new InputStreamReader(client.getInputStream()));
            } catch (IOException ex) {
               System.out.println("Scanner error");
            }
            try {
                out = new PrintStream(client.getOutputStream());
            } catch (IOException ex) {
               System.out.println("printstream client error");
            }

           
            
            String lala = sc.nextLine();
            System.out.println(lala);
            out.println(getAction());
            out.flush();
              try {
                  Thread.sleep(100);
              } catch (InterruptedException ex) {
                 System.out.println("Thread sleep - client interrupted");
              }
             
        }
    }
    
}
