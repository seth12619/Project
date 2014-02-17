/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import java.util.*;
import javax.swing.*;
import java.awt.*;

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
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
}
