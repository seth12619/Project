package project;

import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;

public class EnemyGenerator
{
   
    private int delay;
    private ArrayList<Drawable> list;
    private int time = 0;
    /**
     * Constructor for objects of class EnemyGenerator
     * @param delay -
     * @param list - 
     */
    public EnemyGenerator(int delay, ArrayList<Drawable> list)
    {
        this.delay = delay;
        this.list = list;
    }


    public static int getYPosA()
    {
        return (0 + (int) (Math.random() * ((175 - 0 ) +1)));
    }
    
    public static int getYPosB()
    {
        return (225 + (int) (Math.random() * ((370 - 225 ) +1)));
    }
    
    public static int getType()
    {
       return (0 + (int) (Math.random() * ((2 - 0 ) +1))); 
    }
    
    public void generate(int yPosA, int yPosB, int type)
    {
        
        if(time == delay)
        {
            
            
            if(type == 1)
            {  
                list.add(new EnemyLinker(yPosA, yPosB, true, 50, 10, 1, 100, 50, list));
            }
            
            if (type == 2)
            {
                list.add(new EnemyLinker(yPosA, yPosB, false, 50, 10, 1, 100, 50, list));
            }
            
            time = 0;
        }
        
        time = time + 1;
        
    }
}
