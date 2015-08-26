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
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;

import java.awt.Color;

/**
 * This class runs a world that contains jumper, bug, flower, rock. <br />
 */
public final class JumperRunner
{
    private JumperRunner()
    {
    }

    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        Jumper a = new Jumper(Color.RED);
		Jumper b = new Jumper(Color.GREEN);
		Jumper c = new Jumper(Color.BLUE);
        world.add(new Location(2,0), a);
        world.add(new Location(1,3), b);
        world.add(new Location(0, 6), c);
        //world.add(new Jumper());
        //world.add(new Bug());
        //world.add(new Flower());
        //world.add(new Rock());
        world.show();
    }
}
