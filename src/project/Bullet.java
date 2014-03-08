import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;


public class Bullet implements Drawable{

  private int xPos;
  private int yPos;
  private int length;
  private int width;
  private int speed;
  private int damage;
  private BufferedImage bulAv;
  
  public Bullet(int xPos, int yPos, int length, int width, int speed, int damage){
    this.xPos = xPos;
    this.yPos = yPos;
    this.length = length;
    this.width = width;
    this.speed = speed;
    this.damage = damage;
    try {    
        bulAv = ImageIO.read(getClass().getResource("Bullet.png"));
        } catch (IOException e) {
            System.out.println("Sprite image loading error - shipAv Player 1");
        } 
  }

    @Override
    public void draw(Graphics g) {
        g.drawImage(bulAv, xPos, yPos, null);
    }

    @Override
    public void animate() {
        xPos = xPos + speed;
    }
}
