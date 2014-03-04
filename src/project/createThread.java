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
public class createThread implements Runnable {
    String checker;
    
    Socket sock;
    PrintStream testOut;
    Scanner in;
    private String ip;

    public createThread(String check) {
        checker = check;
    }
    
    @Override
    public void run() {
       if (checker.equals("server")){
           try {
            Server create = new Server(); //create server
            sleep(4000);
        } catch (IOException ex) {
            System.out.println("Error in Creating Server");
        }  catch (InterruptedException ex) {
               System.out.println("Thread Interrupted");
           }
       }
       
       
           else if (checker.equals("client")) {
               
        InetAddress ip = null;
        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            System.out.println("Error in obtaining local IP address");
        }
           try {
               sleep(5000);
           } catch (InterruptedException ex) {
               System.out.println("Socket Creation Interrupted");
           }
           try {
               sock = new Socket(ip, 8888);
           } catch (IOException ex) {
               System.out.println("Error in making Socket");
           }
        try {
            testOut = new PrintStream(sock.getOutputStream());
        } catch (IOException ex) {
            System.out.println("Error in getting OutputStream");
        }
       
        try {
            in = new Scanner(new InputStreamReader(sock.getInputStream()));
        } catch (IOException ex) {
            System.out.println("Error in getting InputStream");
        } 
                   }
                   
                   
      }     
}
       
        
        
