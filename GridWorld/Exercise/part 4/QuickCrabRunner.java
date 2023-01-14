package Code;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;
import Code.QuickCrab;

public class QuickCrabRunner
{
	public static void main(String[] args)
	{
		//initialize the world
		ActorWorld world = new ActorWorld(); 
		
		//call the constructor
		QuickCrab mon = new QuickCrab();

		world.add(new Location(4, 4), mon);//place it at (4, 4)
		
		//creating the scene 
		world.add(new Location(7, 5), new Flower());
		world.add(new Location(5, 4), new Bug());
		world.add(new Location(7, 8), new Flower());
		world.add(new Location(3, 2), new Flower());
		world.add(new Location(3, 8), new Flower());
		world.add(new Location(6, 5), new Bug());
		world.add(new Location(5, 3), new Bug());
		//show the world
		world.show();  
	}
}