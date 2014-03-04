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

/**
 *
 * @author Seth Legaspi/Marco Santos
 */
public final class Server {
  
    public Server() throws IOException {
        startServer();
        
    }
    
    public void startServer() {
        
        
        while(true) {
            ServerSocket serve = null;
            Socket client = null;
            try {
                serve = new ServerSocket(8888);
            } catch (IOException ex) {
                System.out.println("Error in making ServerSocket");
            }
            
            try {
                client = serve.accept();
            } catch (IOException ex) {
                System.out.println("Error in accepting request from client");;
            }
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
             
        }
       
    }
    
}
