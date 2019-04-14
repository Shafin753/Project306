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
	               //addUser
	               break;
	               
	             case 2:
	               //print the user and their items in a text file
	               break;
	               
	            case 3:
	               //Print just the item in a text file
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
}