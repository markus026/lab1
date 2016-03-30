package sm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestStableMatching {
	private StableMatching sm;
	
	@Before
	public void setUp() throws Exception {
	
	}

	@Test
	public void test() {
		sm = new StableMatching(2);
		sm.setName(1, "Olle");
		sm.setName(2, "Bella");
		sm.setName(3, "Urban");
		sm.setName(4, "Frida");
		String[] p1 = {"4","2"};
		String[] p2 = {"1","3"};
		String[] p3 = {"4","2"};
		String[] p4 = {"3","1"};
		sm.setPreference(1, p1);
		sm.setPreference(2, p2);
		sm.setPreference(3, p3);
		sm.setPreference(4, p4);
		sm.match();
		assertEquals("Olle -- Bella\nUrban -- Frida", sm.matchToString());
	}
	
	@Test
	public void testtest() {
		sm = new StableMatching(2);
		sm.setName(1, "m");
		sm.setName(2, "w");
		sm.setName(3, "m'");
		sm.setName(4, "w'");
		String[] p1 = {"2","4"};
		String[] p3 = {"4","2"};
		String[] p2 = {"3","1"};
		String[] p4 = {"1","3"};
		sm.setPreference(1, p1);
		sm.setPreference(3, p3);
		sm.setPreference(2, p2);
		sm.setPreference(4, p4);
		sm.match();
		assertEquals("m -- w\nm' -- w'", sm.matchToString());
	}
	
	@Test
	public void testTwo() {
		sm = new StableMatching(3);
		sm.setName(1, "Ross");
		sm.setName(2, "Monica");
		sm.setName(3, "Chandler");
		sm.setName(4, "Phoebe");
		sm.setName(5, "Joey");
		sm.setName(6, "Rachel");
		String[] p1 = {"6","4","2"};
		String[] p2 = {"3","5","1"};
		String[] p3 = {"2","6","4"};
		String[] p4 = {"5","1","3"};
		String[] p5 = {"6","4","2"};
		String[] p6 = {"1","5","3"};
		sm.setPreference(1, p1);
		sm.setPreference(2, p2);
		sm.setPreference(3, p3);
		sm.setPreference(4, p4);
		sm.setPreference(5, p5);
		sm.setPreference(6, p6);
		sm.match();
		assertEquals("Ross -- Rachel\nChandler -- Monica\nJoey -- Phoebe", sm.matchToString());
	}
	
	@Test
	public void testThree() {
		sm = new StableMatching(5);
		sm.setName(1, "1");
		sm.setName(2, "2");
		sm.setName(3, "3");
		sm.setName(4, "4");
		sm.setName(5, "5");
		sm.setName(6, "6");
		sm.setName(7, "7");
		sm.setName(8, "8");
		sm.setName(9, "9");
		sm.setName(10, "10");
		String[] p1 = {"2","4","6","8","10"};
		String[] p2 = {"3","5","7","9","1"};
		String[] p3 = {"4","6","8","2","10"};
		String[] p4 = {"5","7","9","1","3"};
		String[] p5 = {"6","8","2","4","10"};
		String[] p6 = {"7","9","1","3","5"};
		String[] p7 = {"8","2","4","6","10"};
		String[] p8 = {"9","1","3","5","7"};
		String[] p9 = {"2","4","6","8","10"};
		String[] p10 = {"1","3","5","7","9"};
		sm.setPreference(1, p1);
		sm.setPreference(2, p2);
		sm.setPreference(3, p3);
		sm.setPreference(4, p4);
		sm.setPreference(5, p5);
		sm.setPreference(6, p6);
		sm.setPreference(7, p7);
		sm.setPreference(8, p8);
		sm.setPreference(9, p9);
		sm.setPreference(10, p10);
		sm.match();
		assertEquals("1 -- 10\n3 -- 2\n5 -- 4\n7 -- 6\n9 -- 8", sm.matchToString());
	}

}

