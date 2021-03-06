package project;

 

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.*;

import javax.sound.sampled.*;
import sun.audio.*;


/**
 *
 * @author Seth Legaspi/Marco Santos
 */
public class Project extends JFrame {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Project frame = new Project();
    }
    
    public Project() throws IOException{
       
        setTitle("Adelardian Garden");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,505);
        
        setLayout(new BorderLayout());
        setResizable(false);
        
        final JPanel menu = new JPanel();
        final JPanel southMenu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.LINE_AXIS));
        southMenu.setLayout(new BoxLayout(southMenu,BoxLayout.LINE_AXIS));
        
        InputStream is = new FileInputStream("bgm.wav"); //it's somehow not reading the sound file
        final AudioStream audioStream = new AudioStream(is);
    
        
        JButton join = new JButton("Join Game");
            join.addActionListener( new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setTitle("Adelardian Garden - Player 2");
                    Game start = null;
                    try {                    
                        start = new Game(2);
                    } catch (IOException ex) {
                        System.out.println("Fatal Error!");
                    }
                    
                 
                    add(start, BorderLayout.NORTH);
                    AudioPlayer.player.start(audioStream);
                    menu.setVisible(false);
                }
            });
        
        JButton create = new JButton ("Create Game");
            create.addActionListener( new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setTitle("Adelardian Garden - Player 1 - Waiting for request from client...");
                    
                    Game start = null;
                    try {                    
                        start = new Game(1);
                    } catch (IOException ex) {
                        System.out.println("Fatal Error!");
                    }
                   
                 
                    add(start, BorderLayout.NORTH);    
                    setTitle("Adelardian Garden - Player 1");
                    AudioPlayer.player.start(audioStream);
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
            
       JButton help = new JButton("Help");
          help.addActionListener( new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
              JOptionPane.showMessageDialog(null, "Player 1 - Red | Player 2 - Green" + "\n" +
                                                  "Use the W-A-S-D buttons to move and 'm' to shoot" + "\n" +
                                                  "W - Move Up" + "\n" +
                                                  "A - Move Left" + "\n" +
                                                  "S - Move Down" + "\n" +
                                                  "D - Move Right" + "\n" +
                                                  "M - Shoot" + "\n" +
                                                  "Gates - Player of respective color must hit the btn of the same-colored gate to open" + "\n" +
                                                  "Meteors - You can only damage meteors that are your color, but you can only kill the meteors that are not your color" + "\n"
                                                  + "This game works on Local Area Network (LAN) only." +
                                                  "\n" + "\n" +
                                                  "This java game was developed by Marco Santos and Seth Legaspi for a CS21b final project");    
              }
          });
            
       
            
        
        menu.add(new JLabel(" ")); menu.add(new JLabel("                                                                     ")); menu.add(new JLabel(" "));
        menu.add(join);
        menu.add(new JLabel("        "));
        menu.add(create);
        menu.add(new JLabel("        "));
        menu.add(exit);
        menu.add(new JLabel(" "));menu.add(new JLabel("              "));menu.add(new JLabel(" "));  
        southMenu.add(new JLabel(" "));
        southMenu.add(help);
        southMenu.add(new JLabel(" "));
       
        
        
   // Game start = new Game();
   // add(start, BorderLayout.NORTH);
        add(menu, BorderLayout.CENTER);
        add(southMenu, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        
        setVisible(true);
    }

    
}
