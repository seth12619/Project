package project;

import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
public class EnemyLinker implements Drawable
{
    // instance variables - replace the example below with your own
    private int yPosA;
    private int yPosB;
    private boolean killedBy;
    private int health;
    private int damage;
    private int speed;
    private int length;
    private int width;
    private ArrayList<Drawable> list;
    private Enemy one;
    private Enemy two;

    /**
     * Constructor for objects of class EnemyLinker
     */
    public EnemyLinker(int yPosA, int yPosB, boolean killedBy, int health, int damage, int speed, int length,
                       int width, ArrayList<Drawable>list)
    {
        // initialise instance variables
        this.yPosA = yPosA;
        this.yPosB = yPosB;
        this.killedBy = killedBy;
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.length = length;
        this.width = width;
        this.list = list;
        
        one = new Enemy (800, yPosA, length, width, speed, damage, list, health, killedBy);
        two = new Enemy (800, yPosB, length, width, speed, damage, list, health, killedBy);
        
        list.add(one);
        list.add(two);
    }

    @Override
    public void draw(Graphics g)
    {
        
    }
    
    @Override
    public void moveUp()
    {
    }
    
    @Override
    public void moveDown()
    {
    }
    
    @Override
    public void moveRight()
    {
    }
    
    @Override
    public void moveLeft()
    {
    }
    
    @Override
    public void animate()
    {
        if (list.contains(one) == false)
        {
            list.remove(two);
            list.remove(this);
        }
        
        if (list.contains(two) == false)
        {
            list.remove(one);
            list.remove(this);
        }
        
    }
}
