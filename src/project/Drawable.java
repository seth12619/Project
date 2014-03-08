package project;

import java.awt.*;

public interface Drawable
{
  public void draw(Graphics g);
  public void moveUp();
  public void moveDown();
  public void moveRight();
  public void moveLeft();
  
  public void animate();
}
