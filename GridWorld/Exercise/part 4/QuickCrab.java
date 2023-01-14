package Code;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;

public class QuickCrab extends CrabCritter
{
	public QuickCrab()
	{
		setColor(Color.ORANGE);
	}
	public ArrayList<Location> getMoveLocations()
	{
		ArrayList<Location> locs = new ArrayList<Location>();
		Grid g = getGrid();
		Location loc = getLocation();
		//两个方向，先取中间一段的判断是否可行
		Location LeftMid = loc.getAdjacentLocation(Location.LEFT);
		Location RightMid = loc.getAdjacentLocation(Location.RIGHT);

		//判断左边
		if(g.isValid(LeftMid) && g.get(LeftMid) == null)
		{
			Location des = LeftMid.getAdjacentLocation(Location.LEFT);  //第一格可以，则判断下一格
			if(g.isValid(des) && g.get(des) == null)
			{
				locs.add(des);	//两格都为空，则可以加入locs中
			}
		}

		//判断右边，代码和左边一致
		if(g.isValid(RightMid) && g.get(RightMid) == null)
		{
			Location des = RightMid.getAdjacentLocation(Location.RIGHT);
			if(g.isValid(des) && g.get(des) == null)
			{
				locs.add(des);
			}
		}

		//若是左右都不行，则直接使用CrabCritter中的move方法。
		if (locs.size() == 0)  
		{
			return super.getMoveLocations();
		}
		return locs;
	}
}