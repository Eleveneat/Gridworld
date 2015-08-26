/*
 * @author Lishaokun
 */
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;



public class JumperRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        Jumper alice = new Jumper();
	world.add(new Rock());
	world.add(new Flower());
        world.add(new Location(3, 4), alice);
        world.show();
    }
}
