package Code;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import Code.KingCrab;


public class KingCrabRunner
{
	public static void main(String[] args)
	{
		//initialize the world
		ActorWorld world = new ActorWorld(); 
		
		//call the constructor
		KingCrab mon = new KingCrab();

		world.add(new Location(4, 3), mon);//place it at (4, 3)
		
		//creating the scene 
		world.add(new Location(7, 5), new Flower());
		world.add(new Location(5, 4), new Flower());
		world.add(new Location(7, 3), new Flower());
		world.add(new Location(4, 6), new Rock());
		world.add(new Location(7, 8), new Flower());
		world.add(new Location(3, 2), new Flower());
		world.add(new Location(3, 8), new Flower());
		world.add(new Location(3, 3), new Rock());
		world.add(new Location(6, 2), new Flower());
		world.add(new Location(7, 7), new Flower());
		
		//show the world
		world.show();  
	}
}