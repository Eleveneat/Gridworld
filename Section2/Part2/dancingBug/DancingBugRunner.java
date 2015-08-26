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
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

import java.util.*;
/**
 * This class runs a world that contains dancing bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public final class DancingBugRunner
{
    public static final int ARRAYSIZE = 100;
    public static final int MAXTURN = 8;
    public static final int ROW = 4;
    public static final int COL = 5;

    private DancingBugRunner()
    {
    }

    public static void main(String[] args)
    {
        Random random = new Random();
        int array[] = new int[ARRAYSIZE];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = random.nextInt(MAXTURN);
        }
        ActorWorld world = new ActorWorld();
        DancingBug alice = new DancingBug(array);
        alice.setColor(Color.ORANGE);
        world.add(new Location(ROW, COL), alice);
        world.show();
    }
}
