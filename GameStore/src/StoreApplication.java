import java.util.ArrayList;
import javax.swing.JOptionPane;

public class StoreApplication {

	public static void main(String[] args) {
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<Item> itemList = new ArrayList<Item>();
		String users = "./src/GameStore/users.txt";
		String items = "./src/GameStore/items.txt";
		
		
	      int menuChoice = getMenuOption();
	      while (menuChoice != 5) {
	         switch(menuChoice) {
	            case 1:
	               User user = getUser();
	               break;
	               
	             case 2:
	               //print the user and their items in a text file
	               break;
	               
	            case 3:
	               //Print just the item in a text file
	            	Item aItem = getItem();
	               break;
	            
	            case 4:
	               //sort the items and print in a text file 
	               break;
	               
	            default:
	               // Program should never reach this condition if logic is correct
	               throw new RuntimeException("Unknown error in menu choice");
	         
	         }menuChoice = getMenuOption(); 
	      }     
	}
	
	
	public static User getUser() {
		User auser=  new User();
		try {
			auser.setFirstName(JOptionPane.showInputDialog("Enter users first name"));
			auser.setLastName(JOptionPane.showInputDialog("Enter users last name"));
			auser.setAddress(JOptionPane.showInputDialog("Enter the users address"));
			auser.setPhoneNumber(JOptionPane.showInputDialog("Enter users last name"));
			do {
				
			}while (JOptionPane.showConfirmDialog(null, "Would you like to enter another Server?", "Create Server",
			         JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
		}
		catch(IllegalArgumentException e){
			JOptionPane.showMessageDialog(null, "User can not be created " + e.getMessage());
		}
		return auser;
	}
	
	
	public static int getMenuOption() {
		      int menuChoice;
				
		      do {
		         try {
		            menuChoice = Integer.parseInt(JOptionPane.showInputDialog(
		               "Enter your selection:"
		               + "\n(1) Add a user"
		               + "\n(2) Print user and their items in a text file"
		               + "\n(3) Print just the items in a text file"
		               + "\n(4) sort the items and print in a text file"
		               + "\n(5) Exit the Program"
		            ));
		         }
		         catch (NumberFormatException e) {
		            menuChoice = 0;
		         }
		         if (menuChoice < 1 || menuChoice > 5) {
		            JOptionPane.showMessageDialog(null, "Invalid choice. Please enter a valid menu option.");
		         }
		      } while (menuChoice < 1 || menuChoice > 5);
		      
		      return menuChoice;
	}
	
	public static Item getItem()
	{
		Item aItem = new Item();
		String name;
		String date;
		double price;
		do
		{
			try
			{
			    aItem.setName(JOptionPane.showInputDialog(null, "Enter item name: "));
				aItem.setPrice(Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the price of the item: ")));
				aItem.setDate(JOptionPane.showInputDialog(null,"Enter today's date: \n Date should be in the format mm/dd/yyyy"));
			}
			catch(IllegalArgumentException e)
			{
				JOptionPane.showMessageDialog(null, "Item couldn't be added, " + e.getMessage());
			}
		}
		while(JOptionPane.showConfirmDialog(null, "Do you want to add another Item?")==JOptionPane.YES_OPTION);
		return aItem;
	//end getItem
	}
}