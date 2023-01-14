package Code;

import info.gridworld.actor.*;
import info.gridworld.grid.*;

import java.util.ArrayList;

public class KingCrab extends CrabCritter
{
	public void processActors(ArrayList<Actor> actors) {
		Grid gr = getGrid();
		Location loc = getLocation();
		int[] dirs = {-45, 0, 45};	//三个方向，西北，正北，东北

		Location northWest = loc.getAdjacentLocation(getDirection() + dirs[0]);
		Location north = loc.getAdjacentLocation(getDirection() + dirs[1]);
		Location northEast = loc.getAdjacentLocation(getDirection() + dirs[2]);

		for (Actor a : actors) {
			if (a.getLocation().equals(northWest)) {  //西北方向
				Location tmp = a.getLocation();
				Location next = tmp.getAdjacentLocation(getDirection() + dirs[0]);  //往对应的方向走
				if(gr.isValid(next) && gr.get(next) == null) {	//next可用，且为空时，将actor移过去
					a.moveTo(next);
				} else {  //否则吃掉
					a.removeSelfFromGrid();
				}
			} else if (a.getLocation().equals(north)) {  //正北方向
				Location tmp = a.getLocation();
				Location next = tmp.getAdjacentLocation(getDirection() + dirs[1]);
				if(gr.isValid(next) && gr.get(next) == null) {
					a.moveTo(next);
				} else {
					a.removeSelfFromGrid();
				}
			} else if (a.getLocation().equals(northEast)) {  //东北方向
				Location tmp = a.getLocation();
				Location next = tmp.getAdjacentLocation(getDirection() + dirs[2]);
				if(gr.isValid(next) && gr.get(next) == null) {
					a.moveTo(next);
				} else {
					a.removeSelfFromGrid();
				}
			}
		}
	}
}
