

package project;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
        
        
        setTitle("Project version 0.000000000001");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,450);
        
        setLayout(new BorderLayout());
        
        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(3, 3, 5, 5));
        
        
        JButton join = new JButton("Join Game");
            join.addActionListener( new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Game start = new Game();
                }
            });
        
        JButton create = new JButton ("Create Game");
            create.addActionListener( new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //should start up server
                }
            });
        
        JButton exit = new JButton("Exit Game");
            exit.addActionListener( new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(1);
                }
            });
            
        
        menu.add(new JLabel(" ")); menu.add(new JLabel(" ")); menu.add(new JLabel(" "));
        menu.add(join);
        menu.add(create);
        menu.add(exit);
        menu.add(new JLabel(" "));menu.add(new JLabel(" "));menu.add(new JLabel(" "));  
        
    
        add(menu, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        
        setVisible(true);
    }
    
}
