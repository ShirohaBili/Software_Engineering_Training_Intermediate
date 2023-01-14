package info.gridworld.maze;
import info.gridworld.maze.*;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;
import info.gridworld.actor.Rock;
import java.awt.Color;

/**
 * This class runs a world that contains maze bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class MazeBugRunner
{
    public static void main(String[] args)
    {
        UnboundedGrid ugr=new UnboundedGrid();
        ActorWorld world = new ActorWorld();
        world.add(new Location(0,0),new MazeBug());
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j+=10){
                world.add(new Location(i,j),new Rock());
            }
        }
        for(int i=0;i<10;i+=10){
            for(int j=0;j<10;j++){
                world.add(new Location(i,j),new Rock());
            }
        }
        world.add(new Location(0,0), new MazeBug());
        world.add(new Location(1,1),new Rock());
        world.show();
    }
}