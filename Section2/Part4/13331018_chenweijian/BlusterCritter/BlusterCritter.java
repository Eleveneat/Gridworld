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
        Grid<Actor> gr = getGrid();
        Location curLoc = getLocation();
        int x1, x2, y1, y2;
        int gridRowNum, gridColNum;

        gridRowNum = gr.getNumRows();
        gridColNum = gr.getNumCols();

        x1 = curLoc.getCol() - 2;
        x2 = curLoc.getCol() + 2;
        y1 = curLoc.getRow() - 2;
        y2 = curLoc.getRow() + 2;

        if (x1 < 0)
            x1 = 0;
        if (y1 < 0)
            y1 = 0;
        if (x2 >= gridColNum)
            x2 = gridColNum - 1;
        if (y2 >= gridRowNum - 1)
            y2 = gridRowNum - 1;

        for(int i = x1; i <= x2; i++) {
        	for(int j = y1; j < y2; j++) {
        		Location loc = new Location(j, i);
        		Actor a = gr.get(loc);
        		if (a != null) {
        			actors.add(a);
        		}
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
}
