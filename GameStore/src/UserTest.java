/**
 * This is the testing class for user.java class
 * @author Asraful Haque Shafin, Pratikchha Dhungana
 */
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void test() {
		User test = new User();
		//setting values for User object
		test.setFirstName("Tom");
		test.setLastName("Jerry");
		test.setAddress("123 Test Rd");
		test.setPhoneNumber("5712335434");
		
		// test the getFirstName of the User class
		assertEquals("getFirstName should return the first name of the User", "Tom", test.getFirstName());
		
		//test the getLastName of the User class
		assertEquals("getLastName should return the last name of the User", "Jerry", test.getLastName());
		
		// testing the toString method
		assertEquals("getPhoneNumber should return the phone number of the user ", "5712335434", test.getPhoneNumber());

	}

}

