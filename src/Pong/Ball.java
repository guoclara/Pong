package Pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
	}
        
        public Ball(int x, int y){
            super(x, y, 10, 10, Color.black);
            xSpeed = 3;
            ySpeed = 1;
        }
        public Ball(int x, int y, int w, int h){
            super(x, y, w, h, Color.black);
            xSpeed = 3;
            ySpeed = 1;
        }
        public Ball(int x, int y, int w, int h, Color c){
            super(x, y, w, h, c);
            xSpeed = 3;
            ySpeed = 1;
        }
        
        public Ball(int x, int y, int w, int h, Color c, int xs, int ys){
            super(x, y, w, h, c);
            xSpeed = xs;
            ySpeed = ys;
        }


	//add the other Ball constructors
	

	   
   //add the set methods
   public void setXS(int x){
       xSpeed = x;
   }
   
   public void setYS(int y){
       ySpeed = y;
   }

   public int getXS(){
       return xSpeed;
   }
   
   public int getYS(){
       return ySpeed;
   }
   

   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location

      draw(window, Color.white);
      setX(getX()+xSpeed);
      setY(getY()+ySpeed);
      draw(window, Color.blue);
		//setY

		//draw the ball at its new location
   }
   
public boolean equals(Ball obj)
    {

        if(super.equals(obj) && obj.getXS() == xSpeed && obj.getYS() == ySpeed){
            return true;
        }


	return false;
    }   

   //add the get methods

   //add a toString() method
    public String toString(){
        return super.toString()+" "+getXS()+" "+getYS();
    }
}