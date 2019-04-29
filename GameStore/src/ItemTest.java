/**
 * This the testing class for item.java class
 * @author Asraful Haque Shafin, Pratikchha Dhungana
 */
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class ItemTest {

	@Test
	void test() {
		
		
		Item test = new Game("Mafia", 50.99, "12/20/2019", true); // because item is abstract
		
		// testing getName method
		assertEquals("getName should return the name of the game", "Mafia", test.getName());
		
		// testing getPrice method
		assertEquals( 50.99, test.getPrice(),"getPrice should return the price the item");
		
		//testing getDate method
		assertEquals("getDate should return the date ", "12/20/2019", test.getDate());
		
		//testing getNumItems method
		assertEquals("getNumItems should return the number of items", 1, test.getNumItems());
		
		
		
		test.setName("BatMan");
		test.setPrice(10.99);
		test.setDate("12/20/1996");
		
		// testing setName 
		assertEquals("getName should return the new name of the game", "BatMan", test.getName());
		// testing setPrice
		assertEquals( 10.99, test.getPrice(),"getPrice should return the new price the item");
		// testing setDate
		assertEquals("getDate should return the new date ", "12/20/1996", test.getDate());
		
		// testing the toString method 
		

		
		// testing the compateTo method
		Item test2 = new Game("Mafia", 50.99, "12/20/2019", true);
		assertEquals("getDate should return the new date ", -1, test.compareTo(test2));
		
		
	}

}
