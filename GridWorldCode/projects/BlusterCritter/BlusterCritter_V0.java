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
 * A <code>BlusterCritter</code> looks at all of the neighbors within two steps of its current location.
 * <br />
 */
public class BlusterCritter extends Critter
{
    private static final double FACTOR = 0.15;
    private static final int MAXRGB = 255;
    private static final int MINRGB = 0;

    // lose 5% of color value in each step if can not change color.

    private int courage;

    public BlusterCritter(int n)
    {
        courage = n;
    }

    public int getCourage() {
        return courage;
    }

    public int getN() {
        return getActors().size();
    }
    public int getRed() {
        Color c = getColor();
        return c.getRed();
    }
    /**
     * A crab gets the actors within two steps of its current location.
     * @return a list of actors occupying these locations
     */
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        Grid gr = getGrid();

        Location loc = getLocation();
        int[] dirs =
            { Location.AHEAD, Location.HALF_LEFT, Location.HALF_RIGHT, Location.LEFT, Location.RIGHT, Location.LEFT + Location.HALF_LEFT, Location.RIGHT + Location.HALF_RIGHT, Location.HALF_CIRCLE };
        for (Location l : getLocationsInDirections(dirs, loc))
        {
            Actor a = getGrid().get(l);
            if (a instanceof Critter)
                actors.add(a);
        }

        Location loc1 = loc.getAdjacentLocation(getDirection() + Location.HALF_LEFT);
        if (gr.isValid(loc1))
        {
            int[] dirs1 = { Location.AHEAD, Location.HALF_LEFT, Location.LEFT, Location.LEFT + Location.HALF_LEFT };
            for (Location l : getLocationsInDirections(dirs1, loc1))
            {
                Actor a = getGrid().get(l);
                if (a instanceof Critter)
                    actors.add(a);
            }
        }

        Location loc2 = loc.getAdjacentLocation(getDirection() + Location.HALF_RIGHT);
        if (gr.isValid(loc2))
        {
            int[] dirs2 = { Location.AHEAD, Location.HALF_LEFT, Location.HALF_RIGHT, Location.RIGHT };
            for (Location l : getLocationsInDirections(dirs2, loc2))
            {
                Actor a = getGrid().get(l);
                if (a instanceof Critter)
                    actors.add(a);
            }
        }

        Location loc3 = loc.getAdjacentLocation(getDirection() + Location.LEFT + Location.HALF_LEFT);
        if (gr.isValid(loc3))
        {
            int[] dirs3 = { Location.LEFT, Location.LEFT + Location.HALF_LEFT, Location.HALF_CIRCLE, Location.RIGHT + Location.HALF_RIGHT };
            for (Location l : getLocationsInDirections(dirs3, loc3))
            {
                Actor a = getGrid().get(l);
                if (a instanceof Critter)
                    actors.add(a);
            }
        }

        Location loc4 = loc.getAdjacentLocation(getDirection() + Location.RIGHT + Location.HALF_RIGHT);
        if (gr.isValid(loc4))
        {
            int[] dirs4 = { Location.RIGHT, Location.RIGHT + Location.HALF_RIGHT, Location.HALF_CIRCLE, Location.HALF_RIGHT };
            for (Location l : getLocationsInDirections(dirs4, loc4))
            {
                Actor a = getGrid().get(l);
                if (a instanceof Critter)
                    actors.add(a);
            }
        }
        

        return actors;
    }

    public void processActors(ArrayList<Actor> actors)
    {
        int n = actors.size();
        Color c = getColor();
        if (n >= courage)
        {
            int red = (int) (c.getRed() * (1 - FACTOR));
            int green = (int) (c.getGreen() * (1 - FACTOR));
            int blue = (int) (c.getBlue() * (1 - FACTOR));
            if (red < MINRGB)
            {
                red = MINRGB;
            }
            if (green < MINRGB)
            {
                green = MINRGB;
            }
            if (blue < MINRGB)
            {
                blue = MINRGB;
            }

            setColor(new Color(red, green, blue));
        } else {
            int red = (int) (c.getRed() * (1 + FACTOR));
            int green = (int) (c.getGreen() * (1 + FACTOR));
            int blue = (int) (c.getBlue() * (1 + FACTOR));
            if (red > MAXRGB)
            {
                red = MAXRGB;
            }
            if (green > MAXRGB)
            {
                green = MAXRGB;
            }
            if (blue > MAXRGB)
            {
                blue = MAXRGB;
            }
            setColor(new Color(red, green, blue));
        }
    }
    
    /**
     * Finds the valid adjacent locations of giving location in different
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
