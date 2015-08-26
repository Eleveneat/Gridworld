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

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

/**
 * This class runs a world that contains crab critters. <br />
 */
public final class BlusterRunner
{
    public static final int COURAGE = 3;
    public static final int[] ROW = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static final int[] COL = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    private BlusterRunner()
    {
    }

    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Location(ROW[0], COL[0]), new BlusterCritter(COURAGE));
        world.add(new Location(ROW[1], COL[1]), new BlusterCritter(COURAGE));
        world.add(new Location(ROW[0], COL[2]), new BlusterCritter(COURAGE));
        world.add(new Location(ROW[1], COL[3]), new BlusterCritter(COURAGE));
        world.add(new Location(ROW[0], COL[4]), new BlusterCritter(COURAGE));
        world.add(new Location(ROW[1], COL[5]), new BlusterCritter(COURAGE));
        world.add(new Location(ROW[0], COL[6]), new BlusterCritter(COURAGE));
        world.show();
    }
}
