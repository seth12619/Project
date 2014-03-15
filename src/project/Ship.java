 package project;

import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;


/**
 *
 * @author Seth Legaspi/Marco Santos
 */
public final class Ship implements Drawable {
    Color shipColor;
    private BufferedImage shipAv; //Ship's image
    private BufferedImage bullet; //bullet's image
    
    int bulletNu;
    int xPos; //x position of image
    int yPos; // y position of image
    int hBLength; //length of hit box
    int hBWidth; //width of hit box
    int health; //how much damage before going dead
    int player;
    public ArrayList<Drawable> list;
    
   int bulletxPos;
   int bulletyPos;
   int delay = 7;
   boolean wasHit = false;
   int immunity = 0;
   
    
    //parameter - ArrayList<Drawable> a
    public Ship(int hum, ArrayList<Drawable> a) {
        bulletNu = -1;
        
        this.list = a;
        player = hum;
        if (player == 1) {
        this.xPos = 20;
        this.yPos = 50;
        this.hBLength =60;
        this.hBWidth = 60;
        this.health = 100;
        } 
        else if (player == 2) {
        this.xPos = 20;
        this.yPos = 290;
        this.hBLength =50;
        this.hBWidth = 100;
        this.health = 100;
        }
        
       // list = a;
        if (player == 1) {
         try {    
        shipAv = ImageIO.read(getClass().getResource("playerOne.png"));
        } catch (IOException e) {
            System.out.println("Sprite image loading error - shipAv Player 1");
        } }
        else if (player == 2) {
            try {
        shipAv = ImageIO.read(getClass().getResource("playerTwo.png"));
            } catch (IOException e) {
                System.out.println("Sprite image loading error - shipAv Player 2");
            }
        }
        
         
        //draw the hitbox here
    }
    
    public void setDelay() {
        delay = 7;
    }
    
    
    public void setPlayer(int hum) {
        player = hum;
    }
    
    
    /**
     * Will decrease y by 1 px by default, thus moving object 1px on screen
     */
    @Override
    public void moveUp() {
        if (yPos > 0) {
        yPos = yPos-5;
        }
        
    }
    
    /**
     * Will increase y by 1 px by default, thus moving object 1px on screen
     */
    @Override
    public void moveDown() {
        if (yPos + 50 < 410) {
        yPos = yPos+5;
        }
        
    }
    
    /**
     * Will increase x by 1 px by default, thus moving object 1px on screen
     */
    @Override
    public void moveRight() {
        if (xPos + 100 < 785) {
        xPos = xPos+5;
        }
       
    }
    
    /**
     * Will decrease x by 1 px by default, thus moving object 1px on screen
     */
    @Override
    public void moveLeft() {
        if (xPos > 0) {
         xPos = xPos-5;
        }
         
    }
    
    public void shoot() {
        //bulletxPos = xPos +5; bulletyPos = yPos+2;
        if ( player == 1) {
        if (delay == 7)
        {
            list.add( new Bullet (xPos +90, yPos+30, 40, 20, 15, 10, list , true)); 
            delay = 0;
            }
        }
        if ( player == 2) {
        if (delay == 7)
        {
            list.add( new Bullet (xPos +90, yPos+30, 40, 20, 15, 10, list , false)); 
            delay = 0;
            }
        }
        
        delay = delay + 1;
        //bulletNu++;
    }
    
    public void takeDamage(int damage) {
        health = health - damage;
        if (health <= 0)
        {
            //dies
        }
    }
	
    
    public int getXPos(){
        return xPos;
    }
    
    public int getYPos(){
        return yPos;
    }
    
    public int getHBLength(){
        return hBLength;
    }
    
    public int getHBWidth(){
        return hBWidth;
    }
    
    public int getHealth(){
        return health;
    }
    
    public void resetFire()
    {
        delay = 7;
    }

    @Override
        public void draw(Graphics g) {
        g.drawImage(shipAv, xPos, yPos, null);
        
       
    }

    @Override
        public void animate() {
        //list.get(bulletNu).animate();
        Enemy place = null;
        if(immunity == 150)
        {
            wasHit = false;
            immunity = 0;
        }
        
        if (wasHit == false)
        {
            for (Drawable e : list)
            {
                if (e instanceof Enemy)
                {
                    place = (Enemy) e;
                    if (place.getYPos()  <= this.yPos + this.hBWidth&& place.getYPos() + place.getWidth() 
                        >= this.yPos + this.hBWidth/8)
                        {
                            if (this.xPos + this.hBLength > place.getXPos() && this.xPos < place.getXPos()
                            + place.getLength())
                            {
                                health = health - place.getDamage();
                                wasHit = true;
                                System.out.println("Took Damage");
                                if (health <= 0)
                                {
                                    list.remove(this);
                                }
                            }
                        }
                }
            }
        }
        
        immunity = immunity + 1;
    }
    
}
