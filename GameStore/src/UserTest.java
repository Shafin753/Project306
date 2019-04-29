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
		Item aItem = new Hardware("Wire", 100.02, "12/20/2018", false);
		//setting values for User object
		test.setFirstName("Tom");
		test.setLastName("Jerry");
		test.setAddress("123 Test Rd");
		test.setPhoneNumber("5712335434");
		test.setItem(aItem);
		
		// test the getFirstName of the User class
		assertEquals("getFirstName should return the first name of the User", "Tom", test.getFirstName());
		
		//test the getLastName of the User class
		assertEquals("getLastName should return the last name of the User", "Jerry", test.getLastName());
		
		// testing the toString method
		assertEquals("getPhoneNumber should return the phone number of the user ", "5712335434", test.getPhoneNumber());

		//testing the getItem of the User class
		assertEquals(aItem, test.getItem(0));
		
		//testing the size of the Item array
		assertEquals(1,test.getNumItems());
		
		//testing the user if of the user
		assertEquals(1,test.getUserID());
		
		//testing the toString method of User class
		assertEquals("toString should return the string representation of user ","\n ID : 1"
		 + "\n First Name: Tom"
		 + "\n Last Name: Jerry"
		 + "\n Address: 123 Test Rd"
		 + "\n PhoneNumber: 5712335434"+ "\n  ------------------" +
		 "\n Item number "+ (1) +"\n" + "Wire; 100.02; 12/20/2018; false" +
		 "\n  ------------------", test.toString());
	
	}

}

