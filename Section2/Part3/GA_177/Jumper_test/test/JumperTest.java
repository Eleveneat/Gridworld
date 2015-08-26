import static org.junit.Assert.*;

import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.awt.Color;

public class JumperTest {
    ActorWorld world = new ActorWorld();

    @Before
        public void setUp() throws Exception {
        }
    @After
        public void tearDown() throws Exception {
        }

    @Test
        public void testBasicFeature() {
            
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

    @Test
        public void testmeetActor() {
            //ActorWorld world = new ActorWorld();
            Jumper j=new Jumper(Color.PINK);
            Jumper j2=new Jumper(Color.ORANGE);
            Rock r=new Rock(Color.GREEN);
            Flower f=new Flower(Color.RED);
            Bug b=new Bug(Color.GRAY);
            //jump over.
            world.add(new Location(3,3),j);
            world.add(new Location(2,3),r);
            j.act();
            assertEquals(1,j.getLocation().getRow());
            assertEquals(3,j.getLocation().getCol());
            assertEquals(Location.NORTH,j.getDirection());

            //no jump but turn.
            //world.add(new Location(5,5),j);
            j.moveTo(new Location(5,5));
            //world.add(new Location(3,5),r);
            r.moveTo(new Location(3,5));
            j.act();
            assertEquals(4,j.getLocation().getRow());
            assertEquals(5,j.getLocation().getCol());
            assertEquals(Location.NORTH,j.getDirection());

            //jump to flower.
            //world.add(new Location(6,6),j);
            j.moveTo(new Location(6,6));
            world.add(new Location(4,6),f);
            //f.moveTo(new Location(4,6));
            j.act();
            assertEquals(4,j.getLocation().getRow());
            assertEquals(6,j.getLocation().getCol());
            assertEquals(Location.NORTH,j.getDirection());

            //jump over flower.
            //world.add(new Location(3,3),j);
            j.moveTo(new Location(3,3));
            world.add(new Location(2,3),f);
            //f.moveTo(new Location(2,3));
            j.act();
            assertEquals(1,j.getLocation().getRow());
            assertEquals(3,j.getLocation().getCol());
            assertEquals(Location.NORTH,j.getDirection());

            //two Jumpers face north.
            //world.add(new Location(5,5),j);
            j.moveTo(new Location(5,5));
            world.add(new Location(3,5),j2);
            j2.act();
            j.act();
            assertEquals(1,j2.getLocation().getRow());
            assertEquals(5,j2.getLocation().getCol());
            assertEquals(Location.NORTH,j2.getDirection());
            assertEquals(3,j.getLocation().getRow());
            assertEquals(5,j.getLocation().getCol());
            assertEquals(Location.NORTH,j.getDirection());

            //two Jumpers face to each other.
            //world.add(new Location(7,7),j);
            j.moveTo(new Location(7,7));
            //world.add(new Location(5,7),j2);
            j2.moveTo(new Location(5,7));
            j2.setDirection(Location.HALF_CIRCLE);
            j2.act();
            j.act();
            assertEquals(6,j2.getLocation().getRow());
            assertEquals(7,j2.getLocation().getCol());
            assertEquals(Location.SOUTH,j2.getDirection());
            assertEquals(5,j.getLocation().getRow());
            assertEquals(7,j.getLocation().getCol());
            assertEquals(Location.NORTH,j.getDirection());
        }     
}

