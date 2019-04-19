package Pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed;

   public Paddle()
   {
       super(10,10, 10, 10);
      speed =5;
   }
   
   public Paddle(int x, int y){
       super(x, y, 10, 10);
       speed =5;
       
   }
   
   public Paddle(int x, int y, int s){
       super(x,y, 10, 10);
       speed = s;
   }
   
   public Paddle(int x, int y, int w, int h, int s){
       super(x,y,w,h);
       speed = s;
   }
   
   public Paddle(int x, int y, int w, int h, Color c, int s){
       super(x,y,w,h,c);
       speed = s;
   }
   //add the other Paddle constructors


   public void moveUpAndDraw(Graphics window)
   {
       Color c = getColor();
       draw(window, Color.white);
       setY(getY()+speed);
       draw(window, c);

   }

   public void moveDownAndDraw(Graphics window)
   {
       Color c = getColor();
       draw(window, Color.white);
       setY(getY()-speed);
       draw(window, c);

   }

   //add get methods
   public int getSpeed(){
       return speed;
   }
   
   public void setSpeed(int s){
       speed = s;
   }
   
   
   //add a toString() method
   public String toString(){
       return super.toString()+" "+getSpeed();
   }
}