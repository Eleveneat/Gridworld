import static org.junit.Assert.*;

import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import org.junit.Before;
import org.junit.Test;

import java.awt.Color;

public class JUnit4_test {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testBasicFeature() {
		ActorWorld world = new ActorWorld();
		Jumper a = new Jumper(Color.RED);
		Jumper b = new Jumper(Color.GREEN);
		Jumper c = new Jumper(Color.BLUE);

		world.add(new Location(2,0), a);
		a.act();
        assertEquals(0, a.getLocation().getRow());
        assertEquals(0, a.getLocation().getCol());
        assertEquals(Location.NORTH, a.getDirection());
        
        world.add(new Location(1,3), b);
        b.act();
        assertEquals(0, b.getLocation().getRow());
        assertEquals(3, b.getLocation().getCol());
        assertEquals(Location.NORTH, b.getDirection());
		b.act();
        assertEquals(0, b.getLocation().getRow());
        assertEquals(3, b.getLocation().getCol());
        assertEquals(Location.NORTHEAST, b.getDirection());
        b.act();
        assertEquals(0, b.getLocation().getRow());
        assertEquals(3, b.getLocation().getCol());
        assertEquals(Location.EAST, b.getDirection());
        b.act();
        assertEquals(0, b.getLocation().getRow());
        assertEquals(5, b.getLocation().getCol());
        assertEquals(Location.EAST, b.getDirection());
        
        world.add(new Location(0, 6), c);
		c.act();
        assertEquals(0, c.getLocation().getRow());
        assertEquals(6, c.getLocation().getCol());
        assertEquals(Location.NORTHEAST, c.getDirection());
        c.act();
        assertEquals(0, c.getLocation().getRow());
        assertEquals(6, c.getLocation().getCol());
        assertEquals(Location.EAST, c.getDirection());
        c.act();
        assertEquals(0, c.getLocation().getRow());
        assertEquals(8, c.getLocation().getCol());
        assertEquals(Location.EAST, c.getDirection());
	}

}
