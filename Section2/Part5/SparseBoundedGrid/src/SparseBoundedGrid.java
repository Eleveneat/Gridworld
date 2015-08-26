/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2002-2006 College Entrance Examination Board 
 * (http://www.collegeboard.com).
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
 * @author Alyce Brady
 * @author APCS Development Committee
 * @author Cay Horstmann
 */


import java.util.ArrayList;
import java.util.LinkedList;

import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;

/**
 * A <code>SparseBoundedGrid</code> is a rectangular grid with a finite number of
 * rows and columns. <br />
 * The implementation of this class is testable on the AP CS AB exam.
 */
public class SparseBoundedGrid<E> extends AbstractGrid<E>
{
    private ArrayList<LinkedList<OccupantInCol>> occupantArray;
    private int row, col;

    /**
     * Constructs an empty bounded grid with the given dimensions.
     * (Precondition: <code>rows > 0</code> and <code>cols > 0</code>.)
     * @param rows number of rows in SparseBoundedGrid
     * @param cols number of columns in SparseBoundedGrid
     */
    public SparseBoundedGrid(int rows, int cols)
    {
        if (rows <= 0)
            throw new IllegalArgumentException("rows <= 0");
        if (cols <= 0)
            throw new IllegalArgumentException("cols <= 0");
        row = rows;
        col = cols;

        occupantArray = new ArrayList<LinkedList<OccupantInCol>>();
        for (int i = 0; i < row; i++) {
            LinkedList<OccupantInCol> newList = new LinkedList<OccupantInCol>();
            occupantArray.add(newList);
        }
    }

    public int getNumRows()
    {
        return row;
    }

    public int getNumCols()
    {
        return col;
    }

    public boolean isValid(Location loc)
    {
        return 0 <= loc.getRow() && loc.getRow() < getNumRows()
                && 0 <= loc.getCol() && loc.getCol() < getNumCols();
    }

    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> theLocations = new ArrayList<Location>();

        for (int r = 0; r < getNumRows(); r++)
        {
            LinkedList<OccupantInCol> list = occupantArray.get(r);
            for (int i = 0; i < list.size(); i++) {
                OccupantInCol object = list.get(i);
                theLocations.add(new Location(r, object.getCol()));
            }
        }

        return theLocations;
    }

    public E get(Location loc)
    {
        if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");

        int locRow = loc.getRow();
        int locCol = loc.getCol();

        LinkedList<OccupantInCol> list = occupantArray.get(locRow);
        for (int i = 0; i < list.size(); i++)
        {
            OccupantInCol object = list.get(i);
            if (object.getCol() == locCol)
            {
                return (E) object.getObject();
            }
        }

        return null;
    }

    public E put(Location loc, E obj)
    {
        if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        if (obj == null)
            throw new NullPointerException("obj == null");

        int locRow = loc.getRow();
        int locCol = loc.getCol();
        E oldOccupant = get(loc);
        OccupantInCol object;

        LinkedList<OccupantInCol> list = occupantArray.get(locRow);
        for (int i = 0; i < list.size(); i++)
        {
            object = list.get(i);
            if (object.getCol() == locCol)
            {
                object.setObject(obj);
                return oldOccupant;
            }
        }

        object = new OccupantInCol(obj, locCol);
        list.add(object);

        return oldOccupant;
    }

    public E remove(Location loc)
    {
        if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        
        // Remove the object from the grid.

        int locRow = loc.getRow();
        int locCol = loc.getCol();
        OccupantInCol object;
        E r = get(loc);

        LinkedList<OccupantInCol> list = occupantArray.get(locRow);
        for (int i = 0; i < list.size(); i++)
        {
            object = list.get(i);
            if (object.getCol() == locCol)
            {
                list.remove(i);
            }
        }
        
        return r;
    }
}
