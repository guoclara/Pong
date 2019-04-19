package Pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
        private int rightScore;
        private int leftScore;


	public Pong()
	{
		//set up all variables related to the game


                ball = new Ball(400,300,20,20,Color.BLUE,-2,3);
                leftPaddle = new Paddle(100,100,20,80, Color.GREEN,6);
                rightPaddle = new Paddle(650,100,20,80, Color.GREEN,6);
                rightScore = 0;
                leftScore = 0;

		keys = new boolean[4];

    
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
   {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
                
                
		Graphics graphToBack = back.createGraphics();
                
                

		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);


		//see if ball hits left wall or right wall
		if(ball.getX()<=20)
		{
			//ball.setXS(0);
			//ball.setYS(0);
                        rightScore++;
                        ball.setXS(-ball.getXS());
		}
                
                if(ball.getX()>=763){
                   
                    //ball.setXS(0);
                    //ball.setYS(0);
                    leftScore++;
                    ball.setXS(-ball.getXS());

                }

		
		//see if the ball hits the top or bottom wall 
                if(ball.getY()<=10 || ball.getY()>=getHeight()-ball.getHeight()-10)
		{
			ball.setYS(-ball.getYS());
		}



		//see if the ball hits the left paddle
		
		if(ball.didCollideLeft(leftPaddle)){
                   if(ball.didCollideBottom(leftPaddle) && ball.didCollideTop(leftPaddle)){
                       ball.setXS(-ball.getXS());
                   }
                }
                
		
		//see if the ball hits the right paddle
		
		if(ball.didCollideRight(rightPaddle)){
                    if(ball.didCollideBottom(rightPaddle) && ball.didCollideTop(rightPaddle)){
                        ball.setXS(-ball.getXS());
                    }
                }
		



		//see if the paddles need to be moved

                if(keys[0] == true)
		{
			leftPaddle.moveDownAndDraw(graphToBack);
		}
		if(keys[1] == true)
		{
                        leftPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[2] == true)
		{
                    rightPaddle.moveDownAndDraw(graphToBack);
		}
		if(keys[3] == true)
		{
                    rightPaddle.moveUpAndDraw(graphToBack);
		}










                graphToBack.setFont(new Font("Calibri", Font.BOLD, 14));
                graphToBack.drawString("Right Score: "+rightScore, 350, 20);
                graphToBack.drawString("Left Score: "+leftScore, 353, 40);
                graphToBack.setColor(Color.white);
                graphToBack.fillRect(350,0,100,50);
                graphToBack.setColor(Color.black);


		
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'M' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'Z' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'M' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
        
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}