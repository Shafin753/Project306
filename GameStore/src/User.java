import java.util.regex.Pattern;

public class User {
	private String firstName;
	private String lastName;
	private int userID;
	private String address;
	private String phoneNumber;
	private Item[] items;
	private int numItems;
	public final static int MAX_ITEMS = 10000;
	
	public User() {
		userID++;
		this.items = new Item[MAX_ITEMS];
		
	}
	
	public String getFirstName() {return this.firstName;}
	public String getLastName() {return this.lastName;}
	public String getAddress() {return this.address;}
	public String getPhoneNumber() {return this.phoneNumber;}
	public int getUserID() {return this.userID;}
	public int getNumItems() {return this.numItems;}
	public Item getItem(int index) {
		if (index < 0 || index >= this.getNumItems()) {
			throw new IllegalArgumentException("Item does not exist at the specified index");
		}
		return this.items[index];
	}
	
	
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.equals("")){
	         throw new IllegalArgumentException("first name must be specified");
	     }
		if (hasNumberorSpecial(firstName)) {
			throw new IllegalArgumentException("Can't have special characters and numbers");
		}
		
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		if (lastName == null || lastName.equals("")){
	         throw new IllegalArgumentException("first name must be specified");
	     }
		if (hasNumberorSpecial(lastName)) {
			throw new IllegalArgumentException("Can't have special characters and numbers");
		}
		this.lastName = lastName;
	}
	
	public void setAddress(String address) {
		if (address == null || address.equals("")){
	         throw new IllegalArgumentException("first name must be specified");
	     }
		this.address = address;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		String regexStr = "^(1\\-)?[0-9]{3}\\-?[0-9]{3}\\-?[0-9]{4}$";
		if (!phoneNumber.matches(regexStr)) {
			 throw new IllegalArgumentException("Phone number must be stored in ########## or 1-########## or ###-###-####");
		}
		this.phoneNumber = phoneNumber;
	}
	
	public void setItem(Item item) {
		if(this.getNumItems() >= MAX_ITEMS) {
			throw new IllegalArgumentException("NO more space for another item");
		}
		this.items[this.numItems++] = item;
	}
	 public static boolean hasNumberorSpecial(String name) {
	    	Pattern digit = Pattern.compile("[0-9]");
		   Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
		   
		   boolean found =  digit.matcher(name).find() || special.matcher(name).find();
		   return found;	  
	 }
	 
	 public String toString() {
		 String output = " ID : " + getUserID()
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
	
}
