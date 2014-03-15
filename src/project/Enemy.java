  package project;

import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;

public class Enemy implements Drawable{

  private int xPos;
  private int yPos;
  private int length;
  private int width;
  private int speed;
  private int damage;
  private BufferedImage enAv;
  ArrayList<Drawable> list;
  static int enemyNumber = 0;
  private int whichEnemy;
  private int health;
  private boolean killedBy;
  private Enemy linkedTo;
  private int type;
  private EnemyLinker link;
  
  public Enemy(int xPos, int yPos, int length, int width, int speed, int damage, ArrayList<Drawable> a,
               int health, boolean killedBy, int type, EnemyLinker link)
  {
    this.xPos = xPos;
    this.yPos = yPos;
    this.length = length;
    this.width = width;
    this.speed = speed;
    this.damage = damage;
    this.list = a;
    this.health = health;
    this.killedBy = killedBy;
    this.type = type;
    this.link = link;
    
    if (type == 1)
    {
        try {    
            enAv = ImageIO.read(getClass().getResource("EnemyRed.png"));
            } catch (IOException e) {
                System.out.println("Bullet image loading error");
            } 
    }
    
    if (type == 2)
    {
        try {    
            enAv = ImageIO.read(getClass().getResource("EnemyGreen.png"));
            } catch (IOException e) {
                System.out.println("Bullet image loading error");
            } 
    }
    
    if (type ==3)
    {
        try {    
            enAv = ImageIO.read(getClass().getResource("GateRed.png"));
            } catch (IOException e) {
                System.out.println("Bullet image loading error");
            } 

    }
    
    if (type == 4)
    {
        try {    
            enAv = ImageIO.read(getClass().getResource("ButtonRed.png"));
            } catch (IOException e) {
                System.out.println("Bullet image loading error");
            } 

    }
    
    if (type == 5)
    {
        try {    
            enAv = ImageIO.read(getClass().getResource("GateGreen.png"));
            } catch (IOException e) {
                System.out.println("Bullet image loading error");
            } 
            
 
    }
    
    if(type == 6)
    {
        try {    
            enAv = ImageIO.read(getClass().getResource("ButtonGreen.png"));
            } catch (IOException e) {
                System.out.println("Bullet image loading error");
            } 

    }
    
  }
  
  @Override
        public void draw(Graphics g) {
        g.drawImage(enAv, xPos, yPos, null);
    }
    
  @Override
  public void animate() {
            /*for (int i = 0; i < 100; i=i+2) {
                xPos = xPos + speed;
            }*/
            
            xPos = xPos - speed;
            if (xPos + this.length <= 0)
            {
                list.remove(this);
            }
    }
    
    public int getEnemy()
    {
        return whichEnemy;
    }
    
    public int getYPos()
    {
        return yPos;
    }
    
    public int getXPos()
    {
        return xPos;
    }
    
    public int getWidth()
    {
        return width;
    }
    
    public void getHit(int damage, boolean flag)
    {
        if(type == 6 || type == 4)
        {
            if( flag == killedBy)
            {
                list.remove(this);
            }
        }
        
        else
        {
            if( flag != killedBy)
            {
                this.reduceHealth(damage);
                Enemy temp = link.getOther(this);
                temp.reduceHealth(damage);
            }
            
            if (health <= 0 && flag == killedBy)
            {
                list.remove(this);
            }
        }
    }
    
    public int getLength()
    {
        return length;
    }
    
    public int getDamage()
    {
        return damage;
    }
    
    public void reduceHealth(int damage)
    {
        health = health - damage;
    }
    
    @Override
    public void moveUp() {
       
    }

    @Override
    public void moveDown() {
        
    }

    @Override
    public void moveRight() {
       
    }

    @Override
    public void moveLeft() {
      
    }
}
