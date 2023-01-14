import java.awt.Color;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class ChameleonKidRunner {
    public static void main(String args[])
    {
        ActorWorld world = new ActorWorld();
        world.add(new Location(7, 7), new Rock(Color.CYAN));
        world.add(new Location(5, 2), new Rock(Color.GRAY));
        world.add(new Location(6, 6), new Flower());
        world.add(new Location(5, 8), new ChameleonKid());
        world.show();
    }
}
