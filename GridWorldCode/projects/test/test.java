

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

public class test
{
    public static void main(String[] args)
    {
        Location loc1 = new Location(4, 3);
        Location loc2 = new Location(3, 4);
        int dir = loc1.getDirectionToward(new Location(3,4));
        System.out.println(dir);
    }
}
