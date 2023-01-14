package test;

import static org.junit.Assert.*;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import org.junit.Test;

public class JumperTest {
    @Test
    public void normalMove() {  //正常行走判定
      ActorWorld world = new ActorWorld();
      Jumper jumper = new Jumper();

      world.add(new Location(3, 0), jumper);
      jumper.act();
      assertEquals(1, jumper.getLocation().getRow());
      assertEquals(0, jumper.getLocation().getCol());
    }

    @Test
    public void RockMove() {  //检验在石头前Jumper的反应
      ActorWorld world = new ActorWorld();
      Jumper jumper = new Jumper();
      Rock rock = new Rock();

      world.add(new Location(2, 1), rock);
      world.add(new Location(4, 1), jumper);
      jumper.act();
      rock.act();
      assertEquals(4, jumper.getLocation().getRow());
      assertEquals(1, jumper.getLocation().getCol());
    }

    @Test
    public void FlowerMove() {  //检验在花前面Jumper的反应
      ActorWorld world = new ActorWorld();
      Jumper jumper = new Jumper();
      Flower flower = new Flower();

      world.add(new Location(4, 4), jumper);
      world.add(new Location(2, 4), flower);
      jumper.act();
      int direc = jumper.getDirection();
      Location loc = jumper.getLocation();
      Location loc2 = new Location(4, 4);
      assertTrue(loc.equals(loc2) && direc == Location.NORTHEAST);
    }

    @Test
    public void adjJumpers() {    //两只Jumper碰到了的时候的判定
      ActorWorld world = new ActorWorld();
      Jumper jumper1 = new Jumper();
      Jumper jumper2 = new Jumper();

      jumper1.setDirection(Location.EAST);
      jumper2.setDirection(Location.WEST);
      world.add(new Location(7, 0), jumper1);
      world.add(new Location(7, 4), jumper2);
      jumper1.act();
      jumper2.act();
      assertEquals(7, jumper1.getLocation().getRow());
      assertEquals(2, jumper1.getLocation().getCol());
      assertEquals(7, jumper2.getLocation().getRow());
      assertEquals(4, jumper2.getLocation().getCol());
    }

    @Test
    public void OutOfGrid() {  //检验是否有跳出Grid
      ActorWorld world = new ActorWorld();
      Jumper jumper = new Jumper();
      Flower flower = new Flower();

      world.add(new Location(1, 4), jumper);
      jumper.act();
      int direc = jumper.getDirection();
      Location loc = jumper.getLocation();
      Location loc2 = new Location(1, 4);
      assertTrue(loc.equals(loc2) && direc == Location.NORTHEAST);
    }
}
