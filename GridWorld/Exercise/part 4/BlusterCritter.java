/* 
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
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Cay Horstmann
 */

import info.gridworld.actor.*;
import info.gridworld.gui.*;
import info.gridworld.grid.*;
import info.gridworld.world.*;

import java.awt.Color;
import java.util.ArrayList;

/**
 * This class runs a world that contains critters. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class BlusterCritter extends Critter
{
    private int courage;

    public BlusterCritter(int c){
        courage = c;
        setColor(Color.PINK);
    }


    public ArrayList<Location> getDirections(int[] angle){
        ArrayList<Location> firstStep = new ArrayList<Location>();
        ArrayList<Location> secondStep = new ArrayList<Location>();
        Grid map = getGrid();

        Location cur = getLocation();
        
        //Firststep.
        if (map.isValid(cur.getAdjacentLocation(45))) firstStep.add(cur.getAdjacentLocation(45));
        if (map.isValid(cur.getAdjacentLocation(135))) firstStep.add(cur.getAdjacentLocation(135));
        if (map.isValid(cur.getAdjacentLocation(-45))) firstStep.add(cur.getAdjacentLocation(-45));
        if (map.isValid(cur.getAdjacentLocation(-135))) firstStep.add(cur.getAdjacentLocation(-135));
        
	//secondStep
        for (Location loc : firstStep){
            for (int ang : angle){
                Location tmp = loc.getAdjacentLocation(ang + getDirection());
                if (map.isValid(tmp) && !secondStep.contains(tmp)){
                    secondStep.add(tmp);
                }
            }
        }
        
	//firststep should also add into location.
        for(Location loc : firstStep){
            if (!secondStep.contains(loc)) secondStep.add(loc);
        }

        return secondStep;
    }

    public ArrayList<Actor> getActors(){
        ArrayList<Actor> actors = new ArrayList<Actor>();

        int angle[] = {0, 45, 90, 135, 180, -45, -90, -135};
        for (Location loc : getDirections(angle)){
            Actor a = getGrid().get(loc);
            if (a instanceof Critter){
                actors.add(a);
            }
        }
        return actors;
    }

    public void processActors(ArrayList<Actor> actors) {
        int n = actors.size();
        Color c = getColor();
        int red, green, blue;
	
	//increase the RGB number
        if (n >= this.courage) {
           red = (int)(c.getRed() * 0.5);
           green = (int)(c.getGreen() * 0.5);
           blue = (int)(c.getBlue() * 0.5);
        } 
        else {	//decrease the RGB number
           red = (int)(c.getRed() * 1.1 );
           green = (int)(c.getGreen() * 1.1);
           blue = (int)(c.getBlue() * 1.1);
        }
        //make sure that the RGB number not more than 255.
           red = (red >= 255) ? 255 : red;
           green = (green >= 255) ? 255 : green;
           blue = (blue >= 255) ? 255 : blue;
        setColor(new Color(red, green, blue));
    }

}
