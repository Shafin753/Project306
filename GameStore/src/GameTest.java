/**
 * This the testing class for game.java class
 * @author Asraful Haque Shafin, Pratikchha Dhungana
 */
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameTest {

	@Test
	void test() {
		Game test = new Game("Mafia", 50.99, "12/20/2019", true);
		// test the getCondition of the game
		assertEquals("getCondition should return the condition of the game", true, test.getCondition());
		
		// testing the setCondition method
		test.setCondition(false);
		assertEquals("getCondition should return the condition of the game", false, test.getCondition());
		
		// testing the toString method
		assertEquals("getString should return the String object ", "Mafia; 50.99; 12/20/2019; false", test.toString());
		
	}

}
