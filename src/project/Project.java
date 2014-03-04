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
 */
public class Project extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Project frame = new Project();
    }
    
    public Project() {
        
        
        setTitle("Project version 0.000000000002");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,450);
        
        setLayout(new BorderLayout());
        
        final JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.LINE_AXIS));
       // menu.setLayout(new GridLayout(3, 3, 5, 5));
        
        
        
        JButton join = new JButton("Join Game");
            join.addActionListener( new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    menu.setVisible(false);
                }
            });
        
        JButton create = new JButton ("Create Game");
            create.addActionListener( new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                      try {
                            //should start up server
                            final Game start = new Game(); //create client for server
                            start.create();
                            
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
        
    
        add(menu, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        
        setVisible(true);
    }
    
}
