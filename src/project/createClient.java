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
    PrintStream sendOut;
    Scanner in;
    private String ip;
    int player;
    
    
    
    String command;
    String receivedCommand;
    
    int xOrder;
    int yOrder;
    
    int xSend;
    int ySend;
    
    InetAddress host = null;
    
    boolean wait = true;
    

    /**
     *
     */
    public createClient() throws UnknownHostException, IOException {
               host = InetAddress.getLocalHost();
      
       
               ip = host.getHostAddress();
        
       
               sock = new Socket(ip, 8888);
               
          
        sendOut = new PrintStream(sock.getOutputStream());
        in = new Scanner(new InputStreamReader(sock.getInputStream()));
        
        Thread client = new Thread(this);
        client.start();
   
    }
    
    public void sendCommand (String act) {
        sendOut.println(act);
    }

    
    public String getCommand() {
        return command;
    }
    
    public void setCommand(String d) {
        command = d;
    }
    
   
    
    @Override
    public void run() {
       //Client below
        
       while (wait) {
           command = "";
           
           
           try {
           setCommand(in.nextLine());
           } catch (Exception e) {
               wait = false;
               break;
           }
      System.out.println("the command: " + command);
           
       }

    }
    
}
       
        
        
