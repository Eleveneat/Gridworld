//package info.gridworld.maze;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

/**
 * A <code>MazeBug2</code> can find its way in a maze. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class MazeBug2 extends Bug {
	public Location next;
	public Location last;
	public boolean isEnd = false;
	public Stack<ArrayList<Location>> crossLocation = new Stack<ArrayList<Location>>();
	public Integer stepCount = 0;
	boolean hasShown = false;//final message has been shown

    public boolean isVisit[][];
    ArrayList<Location> branch;
    int left, right, ahead, behind;

	/**
	 * Constructs a box bug that traces a square of a given side length
	 * 
	 * @param length
	 *            the side length
	 */
	public MazeBug2() {
        int size = 100;
		setColor(Color.GREEN);
		last = new Location(0, 0);
        isVisit = new boolean[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                isVisit[i][j] = false;
		Location loc = getLocation();

        branch = new ArrayList<Location>();
        branch.add(loc);

        left = 1;
        right = 1;
        ahead = 1;
        behind = 1;
	}

	/**
	 * Moves to the next location of the square.
	 */
	public void act() {
		boolean willMove = canMove();
		if (isEnd == true) {
		//to show step count when reach the goal		
			if (hasShown == false) {
				String msg = stepCount.toString() + " steps";
				JOptionPane.showMessageDialog(null, msg);
				hasShown = true;
			}
		} else if (willMove) {
            isVisit[next.getRow()][next.getCol()] = true;
			move();
			//increase step count when move 
			stepCount++;
		} else {
            goBack();
			stepCount++;
        }
	}

	/**
	 * Find all positions that can be move to.
	 * 
	 * @param loc
	 *            the location to detect.
	 * @return List of positions.
	 */
	public ArrayList<Location> getValid(Location loc) {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return null;
		ArrayList<Location> valid = new ArrayList<Location>();
        int row, col;
        int[] dirs =
            { Location.AHEAD, Location.LEFT, Location.RIGHT, Location.HALF_CIRCLE };

        for (int d : dirs) {
            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
            row = neighborLoc.getRow();
            col = neighborLoc.getCol();

            if (gr.isValid(neighborLoc)) {
                Actor a = gr.get(neighborLoc);
                if ((a == null || a instanceof Flower) && !isVisit[row][col]) {
                    valid.add(neighborLoc);
                } else if (a instanceof Rock) {
                    Color r = Color.RED;
                    if (r.equals(a.getColor()))
                        isEnd = true;
                }
            }
        }

		return valid;
	}

	/**
	 * Tests whether this bug can move forward into a location that is empty or
	 * contains a flower.
	 * 
	 * @return true if this bug can move.
	 */
	public boolean canMove() {
		ArrayList<Location> loc = getValid(getLocation());
        int romdom, locSize;

        if (loc.isEmpty()) {
            return false;
        } else {
            branch.add(getLocation());
            locSize = loc.size();

            if (locSize >= 2) {
                crossLocation.push(branch);
                branch = new ArrayList<Location>();
                next = betterDirection(loc);
            } else {
                next = loc.get(0);
            }
        }

        return true;
	}

    public Location betterDirection(ArrayList<Location> a) {
        int leftD, rightD, aheadD, behindD, random,direction;
        leftD = rightD = aheadD = behindD = 0;
        for (Location loc : a) {
            direction = getLocation().getDirectionToward(loc);
            if (direction == 0)
                aheadD = ahead;
            else if (direction == 90)
                rightD = right;
            else if (direction == 180)
                behindD = behind;
            else if (direction == 270)
                leftD = left;
        }
        random= 1 + (int)(Math.random() * (leftD + rightD + aheadD + behindD));
        if (random <= leftD) {
            direction = 270;
            left++;
         } else if (random <= (leftD + rightD)) {
            direction = 90;
            right++;
         } else if (random <= (leftD + rightD + aheadD)) {
            direction = 0;
            ahead++;
         } else {
            direction =180;
            behind++;
         }
        Location betterLoc = null;
        for (Location loc : a) {
            if (direction == getLocation().getDirectionToward(loc))
                betterLoc = loc;
        }
        return betterLoc;
    }


    
	/**
	 * Moves the bug forward, putting a flower into the location it previously
	 * occupied.
	 */
	public void move() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		Location loc = getLocation();
		if (gr.isValid(next)) {
			setDirection(getLocation().getDirectionToward(next));
			moveTo(next);
		} else
			removeSelfFromGrid();
		Flower flower = new Flower(getColor());
		flower.putSelfInGrid(gr, loc);
	}

    public void goBack() {
    	int branchSize;
        if (branch.isEmpty()) {
            branch = crossLocation.pop();
            Location loc = branch.get(branch.size() - 1);
            int direction = getLocation().getDirectionToward(loc);
            if (direction == 0) {
            	behind--;
            } else if (direction == 90) {
            	left--;
            } else if (direction == 180) {
            	ahead--;
            } else {
            	right--;
            }
        }
        branchSize = branch.size();
        next = branch.remove(branchSize - 1);
        move();
    }
}
