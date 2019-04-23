/*
 * This is a DDC for User object. This class contains information about the User and consists of different
 * variables, constructor, and getters and setters. 
 * @author Asraful Haque Shafin, Pratikchha Dhungana
 * ashafin@gmu.edu (G00950667)
 * pdhungan@.gmu.edu (G00979220)
 */
import java.util.regex.Pattern;

public class User {
	//declaring variables
	private String firstName;
	private String lastName;
	private int userID;
	private static int numUser;
	private String address;
	private String phoneNumber;
	private Item[] items;
	private int numItems;
	public final static int MAX_ITEMS = 10000; 
	
	/*
	 * Constructs User object
	 * @param none
	 * @return none
	 */
	public User() {
		numUser++;
		this.userID = numUser;
		this.items = new Item[MAX_ITEMS];
		
	}
	
	public String getFirstName() {return this.firstName;} //returns the first name of User
	public String getLastName() {return this.lastName;} //returns the last name of User
	public String getAddress() {return this.address;} //returns the address of User
	public String getPhoneNumber() {return this.phoneNumber;} //returns the phone number of User
	public int getUserID() {return this.userID;} //returns the userID of User
	public int getNumItems() {return this.numItems;} //returns number of Items
	
	/*
	 * Validates the index and returns the item at that particular index
	 * @param index is the index of items array whose value will be passed
	 * @return item at given index
	 */
	public Item getItem(int index) {
		if (index < 0 || index >= this.getNumItems()) {
			throw new IllegalArgumentException("Item does not exist at the specified index");
		}
		return this.items[index];
	}
	
	/*
	 * Validates and sets the first name of the User
	 * @param firstName is the first name of the User
	 * @return none
	 */
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.equals("")){
	         throw new IllegalArgumentException("first name must be specified");
	     }
		if (hasNumberorSpecial(firstName)) {
			throw new IllegalArgumentException("Can't have special characters and numbers");
		}
		
		this.firstName = firstName;
	}
	
	/*
	 * Validates and sets the last name of the User
	 * @param lastName is the last name of the User
	 * @return none
	 */
	public void setLastName(String lastName) {
		if (lastName == null || lastName.equals("")){
	         throw new IllegalArgumentException("first name must be specified");
	     }
		if (hasNumberorSpecial(lastName)) {
			throw new IllegalArgumentException("Can't have special characters and numbers");
		}
		this.lastName = lastName;
	}
	
	/*
	 * Validates and sets the address of the User
	 * @param address is the address of the User
	 * @return none 
	 */
	public void setAddress(String address) {
		if (address == null || address.equals("")){
	         throw new IllegalArgumentException("first name must be specified");
	     }
		this.address = address;
	}
	
	/*
	 * Validates and sets the phone number of the User
	 * @param phoneNumber is the phone number of the user
	 * @return none
	 */
	public void setPhoneNumber(String phoneNumber) {
		String regexStr = "^(1\\-)?[0-9]{3}\\-?[0-9]{3}\\-?[0-9]{4}$";
		if (!phoneNumber.matches(regexStr)) {
			 throw new IllegalArgumentException("Phone number must be stored in ########## or 1-########## or ###-###-####");
		}
		this.phoneNumber = phoneNumber;
	}
	
	/*
	 * Checks for the space availability and stores item into items array
	 * @param item is the item to be stored in the items array
	 * @return none
	 */
	public void setItem(Item item) {
		if(this.getNumItems() >= MAX_ITEMS) {
			throw new IllegalArgumentException("NO more space for another item");
		}
		this.items[this.numItems++] = item;
	}
	
	/*
	 * Checks whether name has any special characters
	 * @param name is the name of the User
	 * @return found is the boolean value 
	 */
	 public static boolean hasNumberorSpecial(String name) {
	    	Pattern digit = Pattern.compile("[0-9]");
		   Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
		   
		   boolean found =  digit.matcher(name).find() || special.matcher(name).find();
		   return found;	  
	 }
	 
	 /*
	  * Returns the string representation of User object
	  * @param none
	  * @return output which contains information about User
	  */
	 public String toString() {
		 String output = "\n ID : " + this.getUserID()
		 + "\n First Name: " + this.getFirstName()
		 + "\n Last Name: " + this.getLastName()
		 + "\n Address: " + this.getAddress()
		 + "\n PhoneNumber: " + this.getPhoneNumber(); 
		 for (int i = 0; i< this.getNumItems(); i++) {
			 output +="\n  ------------------" +
					 "\n Item number "+ (i+1) +"\n" + this.getItem(i).toString() +
					 "\n  ------------------";
		 }
		 return output;
	 }
//end class	
}
