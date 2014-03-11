/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
  
  public Enemy(int xPos, int yPos, int length, int width, int speed, int damage, ArrayList<Drawable> a,
               int health)
  {
    this.xPos = xPos;
    this.yPos = yPos;
    this.length = length;
    this.width = width;
    this.speed = speed;
    this.damage = damage;
    this.list = a;
    this.health = health;
    whichEnemy = enemyNumber;
    enemyNumber = enemyNumber +1;
    try {    
        enAv = ImageIO.read(getClass().getResource("Enemy.png"));
        } catch (IOException e) {
            System.out.println("Enemy sprite loading error");
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
            if (xPos <= 0)
            {
                Enemy temp = null;
                for ( Drawable a : list)
                {
                    if (a instanceof Enemy)
                    {
                        temp = (Enemy)a;
                        if (temp.getEnemy() == this.getEnemy())
                        {
                            list.remove(temp);
                            //System.out.println("Deleted.");
                            break;
                        }
                    }
                }
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
    
    public void getHit(int damage)
    {
        health = health - damage;
        if (health <= 0)
        {
            list.remove(this);
        }
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
