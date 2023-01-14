package info.gridworld.maze;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.*;

import java.awt.Color;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

/**
 * A <code>MazeBug</code> can find its way in a maze. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class MazeBug extends Bug {
	public Location next;
	public Location last;
	public boolean isEnd = false;
	//没用上 不知道有啥用：public Stack<ArrayList<Location>> crossLocation = new Stack<ArrayList<Location>>();
	public Integer stepCount = 0;
	boolean hasShown = false;//final message has been shown
	Stack<Location> s = new Stack<Location>();
	ArrayList<Location> nextLocation = new ArrayList<Location>();
	int[] prob = {0,0,0,0};


	/**
	 * Constructs a box bug that traces a square of a given side length
	 *
	 */
	public MazeBug() {
		setColor(Color.GREEN);
		last = null;
		next = null;
	}

	/**
	 * Moves to the next location of the square.
	 */
	public void act() {
		last = getLocation();
		boolean willMove = canMove();
		if (isEnd == true) {
			//to show step count when reach the goal
			if (hasShown == false) {
				String msg = stepCount.toString() + " steps";
				JOptionPane.showMessageDialog(null, msg);
				hasShown = true;
			}
		} else if (willMove) {
			move();
			//increase step count when move
			stepCount++;
		}else{
			back();
		}
	}

	/**
	 * Find all positions that can be move to.
	 *
	 * @param loc
	 *            the location to detect.
	 * @return List of positions.
	 */
	public ArrayList<Location> getValid(Location loc) {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return null;
		ArrayList<Location> valid = new ArrayList<Location>();

		//四个方向
		int[] dir = {Location.NORTH,Location.RIGHT,Location.SOUTH,Location.WEST};

		for (int i=0;i<4;i++){
			Location tmp = loc.getAdjacentLocation(dir[i]);

			if (gr.isValid(tmp)){
				Actor act = gr.get(tmp);
				if (act == null){
					valid.add(tmp);
				}
				else if (act instanceof Rock && act.getColor().equals(Color.RED)){  //判断终点
					ArrayList<Location> end = new ArrayList<Location>();
					end.add(tmp);
					next = tmp;
					isEnd = true;
					return end;
				}
			}
		}
		return valid;
	}

	/**
	 * Tests whether this bug can move forward into a location that is empty or
	 * contains a flower.
	 *
	 * @return true if this bug can move.
	 */
	public boolean canMove() {
		Location cur = getLocation();
		nextLocation = getValid(cur);

		if (nextLocation.isEmpty()) return false;
		else return true;
	}
	/**
	 * Moves the bug forward, putting a flower into the location it previously
	 * occupied.
	 */
	public void move() {
		Grid<Actor> gr = getGrid();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Location formerLoc = getLocation();		//记录原位置，方便之后在原位置放花。

		if (gr == null)
			return;
		if (s.isEmpty()){  	//初始状态
			s.push(getLocation());
		}
		//根据选择的次数多少来决定选择方向的概率
		for (int i=0;i<nextLocation.size();i++){
			int tmp=getLocation().getDirectionToward(nextLocation.get(i));
			int dir = tmp /90;

			for (int j=0;j<prob[dir];j++){		//加入到一个数组中，越多越容易被选中
				arr.add(i);
			}
		}

		int choice = (int)(Math.random() * arr.size());  	 //随机挑选


		if (arr.size() == 0) next = nextLocation.get(0); 	//若arr为0时，默认选择第一个为方向
		else next = nextLocation.get(arr.get(choice));

		prob[getLocation().getDirectionToward(next) / 90]++;	//增加一次

		if (gr.isValid(next)) {
			setDirection(getLocation().getDirectionToward(next));
			s.push(next);
			moveTo(next);
			last = next;
			next = null;
		}

		Flower flower = new Flower(getColor());
		flower.putSelfInGrid(gr, formerLoc);
	}
	public void back(){
		Grid<Actor> gr = getGrid();
		last = s.peek();
		s.pop();

		Location tmp = s.peek();
		setDirection(getLocation().getDirectionToward(tmp));
		moveTo(tmp);	//先退出来

		prob[tmp.getDirectionToward(last)/90]--;	//这时候因为撞墙了，加点惩罚
		Flower flower = new Flower(getColor());
		flower.putSelfInGrid(gr, last);		//在上一位置放花，标记已走过。

		last = tmp;
		next = null;
		stepCount++;
	}

}
