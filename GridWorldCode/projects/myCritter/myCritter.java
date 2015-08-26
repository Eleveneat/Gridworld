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
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;

/**
 * A <code>myCritter</code> removes any rocks around it. <br />
 */
public class myCritter extends Critter
{
    private boolean isEat;
    private boolean isMoveRock;

    public void act()
    {
        if (getGrid() == null)
            return;
        ArrayList<Actor> actors = getActors();
        processActors(actors);
        if (!isEat && !isMoveRock)
        {
            ArrayList<Location> moveLocs = getMoveLocations();
            Location loc = selectMoveLocation(moveLocs);
            makeMove(loc);
        }
    }

    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        Location curLoc = getLocation();
        int[] dirs =
            { Location.AHEAD, Location.LEFT, Location.RIGHT, Location.HALF_CIRCLE };
        for (Location loc : getLocationsInDirections(dirs, curLoc))
        {
            Actor a = getGrid().get(loc);
            if (a != null)
                actors.add(a);
        }

        return actors;
    }

    public void processActors(ArrayList<Actor> actors)
    {
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();
        for (Actor a : actors)
        {
            if (a instanceof Rock)
            {
                Location aLoc = a.getLocation();
                int direction = loc.getDirectionToward(aLoc);
                Location awayLoc = aLoc.getAdjacentLocation(direction);
                if (gr.isValid(awayLoc) && gr.get(awayLoc) == null) {
                    a.moveTo(awayLoc);
                    isMoveRock = true;
                    return;
                }   
            } else if (!(a instanceof Critter))
            {
                Location aLoc = a.getLocation();
                int direction = loc.getDirectionToward(aLoc);
                setDirection(direction);
                a.removeSelfFromGrid();
                isEat = true;
                return;
            }
        }
        isEat = false;
        isMoveRock = false;
    }

    public ArrayList<Location> getMoveLocations()
    {
        int x, y, row, col;
        Location aheadLoc, leftLoc, rightLoc, behindLoc, loc1, loc2, currentLoc;
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid<Actor> gr = getGrid();

        currentLoc = getLocation();
        row = currentLoc.getRow();
        col = currentLoc.getCol();
        Actor a = gr.get(currentLoc);


        aheadLoc = new Location(row - 1, col);
        if (gr.isValid(aheadLoc))
        {
            a = gr.get(aheadLoc);
            if (a == null)
            {
                loc1 = new Location(row - 2, col - 1);
                if (gr.isValid(loc1))
                {
                    Actor b = gr.get(loc1);
                    if (b == null)
                        locs.add(loc1);
                }

                loc2 = new Location(row - 2, col + 1);
                if (gr.isValid(loc2))
                {
                    Actor c = gr.get(loc2);
                    if (c == null)
                        locs.add(loc2);
                }
            }
        }

        leftLoc = new Location(row, col - 1);
        if (gr.isValid(leftLoc))
        {
            a = gr.get(leftLoc);
            if (a == null)
            {
                loc1 = new Location(row - 1, col - 2);
                if (gr.isValid(loc1))
                {
                    Actor b = gr.get(loc1);
                    if (b == null)
                        locs.add(loc1);
                }

                loc2 = new Location(row + 1, col - 2);
                if (gr.isValid(loc2))
                {
                    Actor c = gr.get(loc2);
                    if (c == null)
                        locs.add(loc2);
                }
            }
        }

        rightLoc = new Location(row, col + 1);
        if (gr.isValid(rightLoc))
        {
            a = gr.get(rightLoc);
            if (a == null)
            {
                loc1 = new Location(row - 1, col + 2);
                if (gr.isValid(loc1))
                {
                    Actor b = gr.get(loc1);
                    if (b == null)
                        locs.add(loc1);
                }

                loc2 = new Location(row + 1, col + 2);
                if (gr.isValid(loc2))
                {
                    Actor c = gr.get(loc2);
                    if (c == null)
                        locs.add(loc2);
                }
            }
        }

        behindLoc = new Location(row + 1, col);
        if (gr.isValid(behindLoc))
        {
            a = gr.get(behindLoc);
            if (a == null)
            {
                loc1 = new Location(row + 2, col - 1);
                if (gr.isValid(loc1))
                {
                    Actor b = gr.get(loc1);
                    if (b == null)
                        locs.add(loc1);
                }

                loc2 = new Location(row + 2, col + 1);
                if (gr.isValid(loc2))
                {
                    Actor c = gr.get(loc2);
                    if (c == null)
                        locs.add(loc2);
                }
            }
        }
        //return getGrid().getEmptyAdjacentLocations(getLocation());
        return locs;
    }

    public Location selectMoveLocation(ArrayList<Location> locs)
    {
        int n = locs.size();
        if (n == 0)
            return getLocation();
        int r = (int) (Math.random() * n);
        return locs.get(r);
    }

    public void makeMove(Location loc)
    {
        if (loc == null)
            removeSelfFromGrid();
        else
            moveTo(loc);
    }

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
