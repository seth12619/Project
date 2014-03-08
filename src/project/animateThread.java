package project;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;



/**
 *
 * @author Seth Legaspi/Marco Santos
 */
public class animateThread implements Runnable {
String stubChecker;
ArrayList <Drawable> list;
    
    
    public animateThread(ArrayList<Drawable> a) {
        //add parameters to make it somehow choose what action it should do in thread
        list = a;
    }
    
    @Override
    public void run() { 
            //stub stuff it should do
        while (true) {
            for ( Drawable a : list)
            {
                a.animate();
            }
            try {
                Thread.sleep(1);  //will make thread sleep
            } catch (InterruptedException ex) {
                System.out.println("Thread's sleep thingie was interrupted");
         }
        }
        
        
    }
    
}
