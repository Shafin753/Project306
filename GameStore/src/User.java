
public class User {
	private String firstName;
	private String lastName;
	private static int userID = 0;
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
	public String addressName() {return this.address;}
	public String getPhoneNumber() {return this.phoneNumber;}
	public static int getUserID() {return userID;}
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
		
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		if (lastName == null || lastName.equals("")){
	         throw new IllegalArgumentException("first name must be specified");
	     }
		this.lastName = lastName;
	}
	
	public void setItem(Item item) {
		if(this.getNumItems() >= MAX_ITEMS) {
			throw new IllegalArgumentException("NO more space for another item");
		}
		this.items[this.numItems++] = item;
	}
	
}
