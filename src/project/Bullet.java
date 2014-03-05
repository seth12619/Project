package project;

import java.awt.Graphics;



public class Bullet implements Drawable{

  private int xPos;
  private int yPos;
  private int length;
  private int width;
  private int speed;
  private int damage;
  
  public Bullet(int xPos, int yPos, int length, int width, int speed, int damage){
    this.xPos = xPos;
    this.yPos = yPos;
    this.length = length;
    this.width = width;
    this.speed = speed;
    this.damage = damage;
  }
  
  public void travel(){
    xPos = xPos + speed;
  }
  
  public void draw(){
    //insert how to draw
  }

    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void animate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveDown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveRight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveLeft() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}
