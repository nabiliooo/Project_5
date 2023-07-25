
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class HolidayBonusTestStudent {

	private double[][] dataSet1 = { {3, 5, 2, 7 }, { 6 }, { 12, 8, 3 } , {5, 2, 7, 1 } };

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalculateHolidayBonusA() {
		try {
			double[] result = HolidayBonus.calculateHolidayBonus(dataSet1);
			assertEquals(7000.0, result[0], .001);
			assertEquals(2000.0, result[1], .001);
			assertEquals(16000.0, result[2], .001);
			assertEquals(7000.0, result[3], .001);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}

	}

	@Test
	public void testCalculateTotalHolidayBonusA() {
		assertEquals(32000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet1), .001);
	}

}
