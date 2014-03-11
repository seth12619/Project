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
  static int bulletNumber = 0;
  private int whichBullet;
  
  public Bullet(int xPos, int yPos, int length, int width, int speed, int damage, ArrayList<Drawable> a){
    this.xPos = xPos;
    this.yPos = yPos;
    this.length = length;
    this.width = width;
    this.speed = speed;
    this.damage = damage;
    this.list = a;
    whichBullet = bulletNumber;
    bulletNumber = bulletNumber +1;
    boolean colliding = false;
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
            
            xPos = xPos + speed;
            if (xPos >= 800)
            {
                list.remove(this);
            }
            
            Enemy place = null;
            for (Drawable e : list)
            {
                if (e instanceof Enemy)
                {
                    place = (Enemy) e;
                    if (place.getYPos() - this.width/4  <= this.yPos && place.getYPos() + place.getWidth() + 
                        this.width/4 >= this.yPos)
                        {
                            if (this.xPos + this.length > place.getXPos())
                            {
                                place.getHit(this.damage);
                                list.remove(this);
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
