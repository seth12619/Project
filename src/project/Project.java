package project;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.*;

/**
 *
 * @author Seth Legaspi/Marco Santos
 * 
 * NOTE: 3/4/14 = The server client works; error is nullPointer, maybe once the stuff's there, it won't do this anymore
 *  + server and client are run on separate threads, so you can sort of have the moving stuff work separately, and
 * just have them do something with client and server respectively to change stuff.
 * 私は魔法少年うう！
 * 
 */
public class Project extends JFrame {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Project frame = new Project();
    }
    
    public Project() throws IOException {
        
        
        setTitle("Project version 0.000000000012");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,450);
        
        setLayout(new BorderLayout());
        
        final JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.LINE_AXIS));

        
        JButton join = new JButton("Join Game");
            join.addActionListener( new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    (new Thread(new createThread("client"))).start();
                    try { 
                        final Game start = new Game();
                        start.join();
                        add(start, BorderLayout.NORTH);
                    } catch (IOException ex) {
                        System.out.println("Fatal Error!");
                    }
                    
                    menu.setVisible(false);
                }
            });
        
        JButton create = new JButton ("Create Game");
            create.addActionListener( new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                      try {
                            //should start up server
                            
                            (new Thread(new createThread("server"))).start();
                          //  (new Thread(new createThread("client"))).start(); //create client for server
                            final Game start = new Game(); 
                            start.create();
                            add(start, BorderLayout.NORTH);
                            
                            //Should set WindowStatus to false upon closing
                               addWindowListener(new WindowAdapter() {
                                      @Override
                                     public void windowClosing(WindowEvent e) {
                                         start.setWindowStatus();
                                       }
                                     });
                            
                      } catch (IOException ex) {
                         System.out.println("Error");
                       }
                      
                    menu.setVisible(false);
                    
                }
            });
        
        JButton exit = new JButton("Exit Game");
            exit.addActionListener( new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(1);
                }
            });
            
       
            
        
        menu.add(new JLabel(" ")); menu.add(new JLabel("                                                                     ")); menu.add(new JLabel(" "));
        menu.add(join);
        menu.add(new JLabel("        "));
        menu.add(create);
        menu.add(new JLabel("        "));
        menu.add(exit);
        menu.add(new JLabel(" "));menu.add(new JLabel("              "));menu.add(new JLabel(" "));  
        
   // Game start = new Game();
   // add(start, BorderLayout.NORTH);
        add(menu, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        
        setVisible(true);
    }
}
