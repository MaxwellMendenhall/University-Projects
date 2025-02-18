package gamephysics;

import java.awt.Point;

import entities.Block;

public class Collision 
{
	public static boolean playerBlock(Point p, Block b)
	{
		return b.contains(p);
	}
}
