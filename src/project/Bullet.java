package project;


import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;



public class Bullet implements Drawable{

  private int xPos;
  private int yPos;
  private int length;
  private int width;
  private int speed;
  private int damage;
  private BufferedImage bulAv;
  ArrayList<Drawable> list;
  static int bulletNumber;
  private int whichBullet;
  
  public Bullet(int xPos, int yPos, int length, int width, int speed, int damage, ArrayList<Drawable> a){
    this.xPos = xPos;
    this.yPos = yPos;
    this.length = length;
    this.width = width;
    this.speed = speed;
    this.damage = damage;
    this.list = a;
    bulletNumber = bulletNumber +1;
    whichBullet = bulletNumber;
    try {    
        bulAv = ImageIO.read(getClass().getResource("Bullet.png"));
        } catch (IOException e) {
            System.out.println("Bullet image loading error");
        } 
  }

    /**
     *
     * @param g
     */
    @Override
        public void draw(Graphics g) {
        g.drawImage(bulAv, xPos, yPos, null);
    }

  @Override
        public void animate() {
            /*for (int i = 0; i < 100; i=i+2) {
                xPos = xPos + speed;
            }*/
            
            xPos = xPos + speed;
            if (xPos >= 800)
            {
                Bullet temp = null;
                for ( Drawable a : list)
                {
                    if (a instanceof Bullet)
                    {
                        temp = (Bullet)a;
                        if (temp.getBullet() == this.getBullet())
                        {
                            list.remove(temp);
                            //System.out.println("Deleted.");
                            break;
                        }
                    }
                }
            }
    }
    
    public int getBullet()
    {
        return whichBullet;
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
