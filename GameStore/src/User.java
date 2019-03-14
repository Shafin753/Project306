
public class User {
	private String firstName;
	private String lastName;
	private static int userID = 0;
	private String address;
	private String phoneNumber;
	
	public User() {
		userID++;
	}
	
	public String getFirstName() {return this.firstName;}
	public String getLastName() {return this.lastName;}
	public String addressName() {return this.address;}
	public String getPhoneNumber() {return this.phoneNumber;}
	public static int getUserID() {return userID;}
	
	
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
	
}
