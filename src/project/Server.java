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
public final class Server {
     private static ServerSocket server = null; 
     private static int portNu = 8888;
     String actionDone;
  
    public Server(String action) throws IOException {
        startServer();
        actionDone = action;
    }
    
    public void startServer() {
        Scanner sc = null;
        PrintStream out = null;
        
          try {
                server = new ServerSocket( portNu );
                
            } catch (IOException ex) {
                System.out.println("Error -- ServerSocket");
            }
        while(true) {
           
            Socket client = null; //creates socket
          
            
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
            
            ObjectInputStream getCommand = null; //initializes Object input stream - The thing that will be given to this server
            
            try {
                getCommand = new ObjectInputStream(client.getInputStream());
            } catch (IOException ex) {
                System.out.println("Error - ObjectInputStream");
                System.exit(0);
            }
            
            String command = null; //initializes variable command
            try {
                command = (String)getCommand.readObject();
            } catch (IOException ex) {
                System.out.println("getCommand error - IOException");
            } catch (ClassNotFoundException ex) {
                System.out.println("getCommand error - ClassNotFoundException");
            }
            // do stuff with command
            if (command.equals("moveRight")) {
                System.out.println("right");
            }
            else if (command.equals("moveLeft")) {
                
            }
            else if (command.equals("moveUp")) {
                
            }
            else if (command.equals("moveDown")) {
                
            }
            
            
            //end of do stuff with command
            
            //stuff to send out to client
            ObjectOutputStream sendingCommand = null;
            try {
                sendingCommand = new ObjectOutputStream(client.getOutputStream());
            } catch (IOException ex) {
                System.out.println("Error - sendingCommand outputstream");
            }
             //stuff to send to client
            try {          
                sendingCommand.writeObject(actionDone);
            } catch (IOException ex) {
                System.out.println("Error - sendingCommand - Write Object");
            }
             //end of stuff to send to client
            
            //end of stuff to send out to client
            
                PrintWriter test;
            try {
                test = new PrintWriter(client.getOutputStream(), true);
            } catch (IOException ex) {
                System.out.println("Error in getting OutputStream");;
            }
            BufferedReader in;
            try {
                in = new BufferedReader (
                        new InputStreamReader(client.getInputStream()));
            } catch (IOException ex) {
                System.out.println("Error in getting InputStream");
            }
            
            String lala = sc.nextLine();
            System.out.println(lala);
            out.println("connect success");
            out.flush();
             
        }
       
    }
    
}
