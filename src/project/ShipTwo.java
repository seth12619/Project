package project;

import java.awt.Graphics;

public class ShipTwo implements Drawable
{
  int xPos;
  int yPos;
  int hitBoxLength;
  int hitBoxWidth;
  int shipLength;
  int shipWidth;
  int health;
  
  public ShipTwo (int xPos, int yPos, int hitBoxLength, int hitBoxWidth, int shipLength, int shipWidth, int health)
  {
    this.xPos = xPos;
    this.yPos = yPos;
    this.hitBoxLength = hitBoxLength;
    this.hitBoxWidth = hitBoxWidth;
    this.shipLength = shipLength;
    this.shipWidth = shipWidth;
    this.health = health;
  }
  
  public void draw()
  {
    //insert how to draw ship here
  }
  
  public void upMove()
  {
    yPos = yPos - 5;
  }
  
  public void downMove()
  {
    yPos = yPos - 5;
  }
  
  public void rightMove()
  {
    xPos = xPos + 5;
  }
  
  public void leftMove()
  {
    xPos = xPos -5;
  }
  
  public void shoot()
  {
    //probably creates a bullet at the current xPos and yPos
  }
  
  public void takeDamage(int damage)
  {
    //possible to implement animation for getting hit?
    health = health - damage;
  }

    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void animate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}
