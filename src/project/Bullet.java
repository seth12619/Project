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
  
}
