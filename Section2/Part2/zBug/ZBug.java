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

import info.gridworld.actor.Bug;

/**
 * A <code>ZBug</code> traces out a "z" path of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class ZBug extends Bug
{
    private int steps;
    private int sideLength;
    private int totalLength;
    public static final int EAST = 90;
    public static final int SOUTHWEST = 225;
    public static final int SIDES_NUM_OF_TRIANGLE = 3;

    /**
     * Constructs a z bug that traces a "z" of a given side length
     * @param length the side length
     */
    public ZBug(int length)
    {
        steps = 0;
        sideLength = length;
        totalLength = SIDES_NUM_OF_TRIANGLE * length;
        setDirection(EAST);
    }

    /**
     * Moves to the next location of the "z".
     */
    public void act()
    {
        if (steps < totalLength && canMove())
        {
            move();
            steps++;
            if (steps % sideLength == 0 && steps / sideLength == 1)
            {
                setDirection(SOUTHWEST);
            } else if (steps % sideLength == 0 && steps / sideLength == 2)
            {
                setDirection(EAST);
            }
        }
    }
}
