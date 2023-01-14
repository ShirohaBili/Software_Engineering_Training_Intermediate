package test;/*
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 */


import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;

import java.awt.Color;

public class Jumper extends Actor
{
    //创建一个Jumper，默认为红色
    public Jumper()
    {
        setColor(Color.RED);
    }

    //提供个性化接口创建Jumper
    public Jumper(Color JumperColor)
    {
        setColor(JumperColor);
    }

    //要是能走就走，否则转向
    public void act()
    {
        if (canMove())
            move();
        else
            turn();
    }

    //转向的方向
    public void turn()
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }

    //走一步
    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = (loc.getAdjacentLocation(getDirection())).getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
        /*
        Flower flower = new Flower(getColor());
        flower.putSelfInGrid(gr, loc);
        */
    }

    //判断能不能走
    public boolean canMove() {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = (loc.getAdjacentLocation(getDirection())).getAdjacentLocation(getDirection());
        if (!gr.isValid(next))  //是否超界
            return false;
        Actor neighbor = gr.get(next);
        return (neighbor == null) ;  //是否没有东西，它要跳过花和石头，因此花和石头的时候不能动
    }
}
