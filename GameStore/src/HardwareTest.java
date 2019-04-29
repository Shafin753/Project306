/**
 * This the testing class for hardware.java class
 * @author Asraful Haque Shafin, Pratikchha Dhungana
 */
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class HardwareTest {

	@Test
	void test() {
		Hardware test = new Hardware("Wire", 100.02, "12/20/2018", false);
		// test the getCondition of the hardware
		assertEquals("getCondition should return the condition of the hardware", false, test.getCondition());
		
		// testing the setCondition method
		test.setCondition(true);
		assertEquals("getCondition should return the condition of the hardware", true, test.getCondition());
		
		// testing the toString method
		assertEquals("getString should return the String object ", "Wire; 100.02; 12/20/2018; true", test.toString());
		
	}

}
