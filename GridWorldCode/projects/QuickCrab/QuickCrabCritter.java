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

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

/**
 * A <code>QuickCrabCritter</code> moves to one of the two locations, randomly selected,
 * that are two spaces to its right or left, if that location and the intervening 
 * location are both empty.
 * <br />
 */
public class QuickCrabCritter extends CrabCritter
{
    /**
     * @return list of empty locations that are two spaces to its right or left.
     */
    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid gr = getGrid();

        Location loc1 = getLocation().getAdjacentLocation(getDirection() + Location.LEFT);
        if (gr.isValid(loc1) && gr.get(loc1) == null)
        {
            int[] dirs1 =
            { Location.LEFT };
            for (Location loc : getLocationsInDirections(dirs1, loc1))
                if (getGrid().get(loc) == null)
                    locs.add(loc);
        }

        Location loc2 = getLocation().getAdjacentLocation(getDirection() + Location.RIGHT);
        if (gr.isValid(loc2) && gr.get(loc2) == null)
        {
            int[] dirs2 =
            { Location.RIGHT };
            for (Location loc : getLocationsInDirections(dirs2, loc2))
                if (getGrid().get(loc) == null)
                    locs.add(loc);
        }

        if (locs.size() == 0) {
            return super.getMoveLocations();
        } else {
            return locs;
        }
    }

    /**
     * Finds the valid adjacent locations of giving position critter in different
     * directions.
     * @param directions - an array of directions (which are relative to the
     * current direction)
     * @param loc - A position inside the grid.
     * @return a set of valid locations that are neighbors of the current
     * location in the given directions
     */
    public ArrayList<Location> getLocationsInDirections(int[] directions, Location loc)
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid gr = getGrid();
    
        for (int d : directions)
        {
            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
            if (gr.isValid(neighborLoc))
                locs.add(neighborLoc);
        }
        return locs;
    }    
}
