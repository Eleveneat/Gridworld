/*  
 * @author Lishaokun
 */


import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Critter;

import java.awt.Color;

/**
 * A jumper is an actor that can move and turn and jump. It drops flowers as
 * it moves. but it doesn't drop flowers as it jump Constructs a red bug.
 */

public class Jumper extends Actor
{
    public Jumper()
    {
        setColor(Color.RED);
    }

    /**
     * Constructs a jumper of a given color.
     * @param jumperColor the color for this bug
     */
    public Jumper(Color jumperColor)
    {
        setColor(jumperColor);
    }

    /**
     * Jump if it can jump, if can not jump, move if it can move, turns otherwise.
     */
    public void act()
    {
        if (canJump()) 
	{
            jump();
	}
        else if (canMove())
	{
            move();
	}
	else
	{
	    turn();
	}
    }

    /**
     * Turns the bug 45 degrees to the right without changing its location.
     */
    public void turn()
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }

    /**
     * Moves the bug forward, and doesn't putting a flower into the location it previously
     * occupied.
     */
    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null) 
	{
            return;
	}
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
	{
            moveTo(next);
	}
        else
	{
            removeSelfFromGrid();
	}
    }

    /**
     * Tests whether this bug can move forward into a location that is empty or
     * contains a flower.
     * @return true if this bug can move.
     */
    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
	{
            return false;
	}
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next)) 
	{
            return false;
	}
        Actor neighbor = gr.get(next);
        return (neighbor == null) || (neighbor instanceof Flower);
        // ok to move into empty location or onto flower
        // not ok to move onto any other actor
    }


   /*we add a jump and a can jump method here*/
    public void jump()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
	{
            return;
	}
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next)) {
		Location next2 = next.getAdjacentLocation(getDirection());
	        if (gr.isValid(next2))
		{
	            moveTo(next2);
		}
	        else
		{
	            removeSelfFromGrid();
		}
	}
    }

    /**
     * Tests whether this bug can jmp forward into a location that is empty or
     * contains a flower.
     * @return true if this bug can jump.
     */
    public boolean canJump()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
	{
            return false;
	}
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());

	if (!gr.isValid(next))
	{
            return false;
	}
	Location next2 = next.getAdjacentLocation(getDirection());
        if (!gr.isValid(next2))
	{
            return false;
	}
        Actor neighbor = gr.get(next2);
        return (neighbor == null) || (neighbor instanceof Flower);
        // ok to move into empty location or onto flower
        // not ok to move onto any other actor
    }

}
