/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import java.io.*;
import java.net.*;

/**
 *
 * @author Seth Legaspi/Marco Santos
 */
public final class Server {
  
    public Server() throws IOException {
        startServer();
        
    }
    
    public void startServer() throws IOException {
        
        
        while(true) {
            ServerSocket serve = new ServerSocket(8888);
            Socket client = serve.accept();
                PrintWriter test = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader (
                    new InputStreamReader(client.getInputStream()));
             test.println(in.readLine());
        }
       
    }
    
}
