import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class HWTest {
	
	private static HelloWorld hw = new HelloWorld();

	// @Before
	// public void setUp() throws Exception {
	// 	hw.clear();
	// }

	@Test
	public void testStr() {
		hw.hello();
		assertEquals("Hello World!", hw.getStr());
	}
 }