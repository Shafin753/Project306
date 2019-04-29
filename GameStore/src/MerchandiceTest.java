/**
 * This is the testing class for merchandice.java class
 * @author Asraful Haque Shafin, Pratikchha Dhungana
 */
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class MerchandiceTest {

	@Test
	void test() {
		Merchandice test = new Merchandice("Stickers", 20.5, "11/20/2019", false);
		// test the getCondition of the merchandise class
		assertEquals("getCondition should return the condition of the merchandise", false, test.getCondition());
		
		// testing the setCondition method
		test.setCondition(true);
		assertEquals("getCondition should return the condition of the merchandise", true, test.getCondition());
		
		// testing the toString method
		assertEquals("getString should return the String object ", "Stickers; 20.5; 11/20/2019; true", test.toString());
		
	}

}