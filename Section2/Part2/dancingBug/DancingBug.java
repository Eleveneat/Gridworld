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
 * A <code>DancingBug</code> traces out a random path. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class DancingBug extends Bug
{
    private int[] array;
    private int pos;

    /**
     * Constructs a dancing bug that "dances" by making different turns before each move.
     * @param arr The integer entries in the array represent how many times the bug turns 
     *            before it moves.
     */
    public DancingBug(int[] arr)
    {
        pos = 0;
        array = new int[arr.length];
        System.arraycopy(arr, 0, array, 0, arr.length);
    }

    /**
     * Turns and Moves to the next location.
     */
    public void act()
    {
        repeatTurn(array[pos++]);
        if (pos == array.length)
        {
            pos = 0;
        }
        if (canMove())
        {
            move();
        }
    }

    /**
     * Turns n times.
     */
    public void repeatTurn(int n)
    {
        int num = n;
        while (num-- != 0)
        {
            turn();
        }
    }
}
