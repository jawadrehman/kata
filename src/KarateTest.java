import static org.junit.Assert.assertEquals;
import junit.framework.JUnit4TestAdapter;

import org.junit.Test;

public class KarateTest {

	public static void main(String... args) {
		junit.textui.TestRunner.run(suite());;
	}

	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(KarateTest.class);
	}

	@Test public void testCopy() {
	  KarateSearch ks = new KarateSearch();
	    assertEquals(-1, ks.chop(3, new int[]{1}));;
	  assertEquals(0,  ks.chop(1, new int[]{1}));;
//	    #
	    assertEquals(0, ks.chop(1, new int[]{1, 3, 5}));
	    assertEquals(1, ks.chop(3, new int[]{1, 3, 5}));
	    assertEquals(2, ks.chop(5, new int[]{1, 3, 5}));
	    assertEquals(-1,ks.chop(0, new int[]{1, 3, 5}));
	    assertEquals(-1,ks.chop(2, new int[]{1, 3, 5}));
	    assertEquals(-1,ks.chop(4, new int[]{1, 3, 5}));
	    assertEquals(-1,ks.chop(6, new int[]{1, 3, 5}));
//	    #
	    assertEquals(0, ks.chop(1, new int[]{1, 3, 5, 7}));
	    assertEquals(1, ks.chop(3, new int[]{1, 3, 5, 7}));
	    assertEquals(2, ks.chop(5, new int[]{1, 3, 5, 7}));
	    assertEquals(3, ks.chop(7, new int[]{1, 3, 5, 7}));
	    assertEquals(-1,ks.chop(0, new int[]{1, 3, 5, 7}));
	    assertEquals(-1,ks.chop(2, new int[]{1, 3, 5, 7}));
	    assertEquals(-1,ks.chop(4, new int[]{1, 3, 5, 7}));
	    assertEquals(-1,ks.chop(6, new int[]{1, 3, 5, 7}));
	    assertEquals(-1,ks.chop(8, new int[]{1, 3, 5, 7}));
  }
}