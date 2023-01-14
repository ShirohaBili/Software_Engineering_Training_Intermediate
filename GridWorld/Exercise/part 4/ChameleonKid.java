import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

//p4.2
public class ChameleonKid extends ChameleonCritter
{
    public ChameleonKid(){

    }

    public ArrayList<Actor> getActors(){
        ArrayList<Actor> neighbors = new ArrayList<Actor>();
        Grid<Actor> grid = getGrid();
        Location front = getLocation().getAdjacentLocation(getDirection() + Location.AHEAD);
        Location behind = getLocation().getAdjacentLocation(getDirection() + Location.HALF_CIRCLE);
        if (grid.isValid(front)){
            Actor a = grid.get(front);
            if(a != null){
                neighbors.add(a);
            }
        }
        if (grid.isValid(behind)){
            Actor a = grid.get(behind);
            if(a != null){
                neighbors.add(a);
            }
        }
        return neighbors;
    }
}
