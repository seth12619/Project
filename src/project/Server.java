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
     String actionToStop;
     String checker;
     
     Scanner sc;
     PrintStream out;
     
     Socket client; //creates socket
     
     int XAct;
     int YAct;
     
      
      
     int xSend;
     int ySend;
     
     boolean wait = true;
     boolean shoot = false;
     boolean left = false;
     boolean right = false;
     boolean up = false;
     boolean down = false;
  
    public Server() throws IOException {
          
                server = new ServerSocket( 8888 );
         
                //waits for client request
                client = server.accept();
                
                
                out = new PrintStream(client.getOutputStream());
                sc = new Scanner(new InputStreamReader(client.getInputStream()));
                
                 Thread s = new Thread(this);
                 s.start();
                 }
    
    public void setActionDone(String act) {
        actionDone = act;  
    }
    
    public void sendCommand (String act) {
        out.println(act);
        out.flush();
    }
    
    public String getAction () {
        return actionDone;
    }
    
    public String getActionToStop() {
        return actionToStop;
    }
    
    public void setActionToStop(String d) {
        actionToStop = d;
    }
    
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
         
    
            
       
      
      while (wait) {
          actionDone = "";
          checker = "";
           try {
               checker = sc.nextLine();
               if (checker.equals("shootFalse")) {
                   setShootFalse();
               }
               if (checker.equals("shoot")) {
                   setShootTrue();
               }
               if (checker.equals("moveLeftFalse")) {
                   setLeftFalse();
               }
               if (checker.equals("moveLeft")) {
                   setLeftTrue();
               }
               if (checker.equals("moveRightFalse")) {
                   setRightFalse();
               }
               if (checker.equals("moveRight")) {
                   setRightTrue();
               }
               if (checker.equals("moveUpFalse")) {
                   setUpFalse();
               }
               if (checker.equals("moveUp")) {
                   setUpTrue();
               }
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
