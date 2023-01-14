import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.gui.*;
import info.gridworld.world.*;
import java.util.ArrayList;
import java.util.LinkedList;

class OccupantInCol
{
      private Object occupant;
      private int col;

      public OccupantInCol(Object o, int c) {
            this.occupant = o;
            this.col = c;
      }

      public Object getOccupant() {
           return this.occupant;
     }

      public int getCol() {
           return this.col;
      } 
}


public class SparseBoundedGrid<E> extends AbstractGrid<E>
{
    private ArrayList<LinkedList<OccupantInCol>> occupantArray;     //使用LinkList实现
    private int COL, ROW;

    public SparseBoundedGrid(int rows, int cols)
    {
        if (rows <= 0)
            throw new IllegalArgumentException("rows <= 0");
        if (cols <= 0)
            throw new IllegalArgumentException("cols <= 0");

        COL = cols;
        ROW = rows;
        occupantArray = new ArrayList<LinkedList<OccupantInCol>>();
        for (int i = 0; i < ROW; i++) {
            occupantArray.add(null);
        }
    }

    public int getNumRows()
    {
        return ROW;
    }

    public int getNumCols()
    {
        return COL;
    }

    //判定是否有效，不可违反Grid的上限和下限
    public boolean isValid(Location loc)
    {
        return 0 <= loc.getRow() && loc.getRow() < getNumRows()
                && 0 <= loc.getCol() && loc.getCol() < getNumCols();
    }

    //获取被占用的位置
    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> theLocations = new ArrayList<Location>();

        for (int r = 0; r < getNumRows(); r++)
        {
            if (occupantArray.get(r) == null) 
               continue;
            for (int c = 0; c < occupantArray.get(r).size(); c++)
            {
                //System.out.println("hhh");
                OccupantInCol tmp = occupantArray.get(r).get(c);
                Location loc = new Location(r, tmp.getCol());
                theLocations.add(loc);
            }
        }

        return theLocations;
    }

    //获取某个位置上的情况
    public E get(Location loc)
    {
        if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        if (occupantArray.get(loc.getRow()) == null)     //一整列都是空的，返回空
           return null;
        for (int i = 0; i < occupantArray.get(loc.getRow()).size(); i++) {    //在该列中遍历查询
            OccupantInCol tmp = occupantArray.get(loc.getRow()).get(i);
            if (tmp.getCol() == loc.getCol())
                return (E) tmp.getOccupant();
        }
        return null;
    }

    //增加一个Object
    public E put(Location loc, E obj)
    {
        if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        if (obj == null)
            throw new NullPointerException("obj == null");

        E oldOccupant = get(loc);
        if (occupantArray.get(loc.getRow()) == null)    //若当前行从未创建过，新建一行
            occupantArray.set(loc.getRow(), new LinkedList<OccupantInCol>());
        OccupantInCol tmp = new OccupantInCol(obj, loc.getCol());
        occupantArray.get(loc.getRow()).add(tmp);    //接到邻接链表末尾上去

	return oldOccupant;
    }
    
    //删除一个Object
    public E remove(Location loc)
    {
        if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        
        E r = get(loc);
        if (r != null) {
	    for (int i = 0; i < occupantArray.get(loc.getRow()).size(); i++) {
            OccupantInCol tmp = occupantArray.get(loc.getRow()).get(i);
            if (tmp.getCol() == loc.getCol())
                occupantArray.get(loc.getRow()).remove(i);    //从邻接链表的末尾删除
          }
        }
        return r;
    }

}

