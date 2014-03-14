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
    
    Socket sock;
    PrintStream sendOut;
    Scanner in;
    private String ip;

    

    String stopCommand;
    String checker;

    
    InetAddress host = null;
    
    boolean wait = true;
    boolean shoot;
    boolean left;
    boolean right;
    boolean up;
    boolean down;
    

    /**
     *
     * @throws java.net.UnknownHostException
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
        sendOut.flush();
    }
   
    //shoot
    public void setShootTrue() {
        shoot = true;
    }
    public void setShootFalse() {
        shoot = false;
    }
    public boolean getShoot() {
        return shoot;
    }
    //left
    public void setLeftTrue() {
        left = true;
    }
    public void setLeftFalse() {
        left = false;
    }
    public boolean getLeft() {
        return left;
    }
    //right
    public void setRightTrue() {
        right = true;
    }
    public void setRightFalse() {
        right = false;
    }
    public boolean getRight() {
        return right;
    }
    //up
    public void setUpTrue() {
        up = true;
    }
    public void setUpFalse() {
        up = false;
    }
    public boolean getUp() {
        return up;
    }
    //down
    public void setDownTrue() {
        down = true;
    }
    public void setDownFalse() {
        down = false;
    }
    public boolean getDown() {
        return down;
    }
    
    @Override
    public void run() {
       //Client below
        
       while (wait) {
           checker = "";
           try {
               checker = in.nextLine();
               //shoot
               if (checker.equals("shootFalse")) {
                   setShootFalse();
               }
               if (checker.equals("shoot")) {
                   setShootTrue();
               }
               //left
               if (checker.equals("moveLeftFalse")) {
                   setLeftFalse();
               }
               if (checker.equals("moveLeft")) {
                   setLeftTrue();
               }
               //right
               if (checker.equals("moveRightFalse")) {
                   setRightFalse();
               }
               if (checker.equals("moveRight")) {
                   setRightTrue();
               }
               //up
               if (checker.equals("moveUpFalse")) {
                   setUpFalse();
               }
               if (checker.equals("moveUp")) {
                   setUpTrue();
               }
               //down
               if (checker.equals("moveDownFalse")) {
                   setDownFalse();
               }
               if (checker.equals("moveDown")) {
                   setDownTrue();
               }
         
           } catch (Exception e) {
               wait = false;
               break;
           }
      System.out.println("the command: " + checker);
           
       }

    }
    
}
       
        
        
