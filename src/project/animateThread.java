/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Seth Legaspi/Marco Santos
 */
public class animateThread implements Runnable {
String stubChecker;
    
    
    public animateThread(String stubParameter) {
        //add parameters to make it somehow choose what action it should do in thread
        
        stubChecker = stubParameter;
    }
    
    @Override
    public void run() { 
        if (stubChecker.equals("lalalalalala")) {
            //stub stuff it should do
            System.out.println("asaraerhakjhfjakhdkjahda");
            try {
                Thread.sleep(3000);  //will make thread sleep
            } catch (InterruptedException ex) {
                System.out.println("Thread's sleep thingie was interrupted");
            }
        }
        
        
    }
    
}
