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
  
    public Server() throws IOException {
        startServer();
        
    }
    
    public void startServer() {
        Scanner sc = null;
        PrintStream out = null;
        
        while(true) {
            ServerSocket server = null;
            Socket client = null;
            try {
                server = new ServerSocket( 8888 );
                
            } catch (IOException ex) {
                System.out.println("Error -- ServerSocket");
            }
            
            try {
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
