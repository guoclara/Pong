package Pong;
//� A+ Computer Science  -  www.apluscompsci.com
//Name - 
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public interface Collidable
{
	public abstract boolean didCollideLeft(Block obj);
	public boolean didCollideRight(Block obj);
	boolean didCollideTop(Block obj);
	boolean didCollideBottom(Block obj);
}