import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class StoreApplication {
	
	public static void main(String[] args) {
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<Item> itemList = new ArrayList<Item>();
		String usersPath = "./src/GameStore/users.txt";
		String itemsPath = "./GameStore/src/items.txt";
		
		
	      int menuChoice = getMenuOption();
	      while (menuChoice != 5) {
	         switch(menuChoice) {
	            case 1:
	               User user = getUser(itemList); // passing itemList so that items can be stored in a different list than users
	               userList.add(user);
	               break;
	               
	             case 2:
	               //print the user and their items in a text file
	               break;
	               
	            case 3:
	               //Print just the item in a text file
	               writingFile(itemList,itemsPath);
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
	
	public static void writingFile(ArrayList<Item> itemList, String outPath) {
		try{
		
			FileOutputStream fis =new FileOutputStream(outPath);
			PrintWriter pw = new PrintWriter(fis);
			for(int i=0; i<itemList.size(); i++){
				pw.write(itemList.get(i).toString() +"\n");
			}
			pw.close();
	
		}
		catch(FileNotFoundException e){
			e.printStackTrace(); 
		}
	}
	public static User getUser(ArrayList<Item> itemList) {
		String[] options = {"Game","Hardware","Mechandice"};
		User auser=  new User();
		Item aItem = null;
		boolean condition = true;
		try {
			auser.setFirstName(JOptionPane.showInputDialog("Enter user's first name"));
			auser.setLastName(JOptionPane.showInputDialog("Enter user's last name"));
			auser.setAddress(JOptionPane.showInputDialog("Enter the user's address"));
			auser.setPhoneNumber(JOptionPane.showInputDialog("Enter user's phone number"));
			do {
				try {
					int x = JOptionPane.showOptionDialog(null, "Choose the item types from the option below",
			                "Click a button",
			                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
			        System.out.println(x);
			        String name = (JOptionPane.showInputDialog(null, "Enter item name: "));
					double price =  (Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the price of the item: ")));
					String  date = (JOptionPane.showInputDialog(null,"Enter today's date: \n Date should be in the format mm/dd/yyyy"));
					int ifNew = JOptionPane.showConfirmDialog(null, "Is the condition new?", "Please select",JOptionPane.YES_NO_OPTION);
					if (ifNew==0) {
						condition = true;
					}
					else {
						condition = false;
					}
					
			        if (x == 0) {
			        	aItem = new Game(name, price, date, condition);
			        }
			        else if (x == 1){
			        	aItem = new Hardware(name, price, date, condition);
			        }
			        else if(x == 3) {
			        	aItem = new Merchandice(name, price, date, condition);
			        }
			        
			        auser.setItem(aItem);
			        itemList.add(aItem);
			        	
			    }catch(IllegalArgumentException e)
				{
					JOptionPane.showMessageDialog(null, "Item couldn't be added, " + e.getMessage());
				}
				
			}while (JOptionPane.showConfirmDialog(null, "Would you like to add a another item?", "Create item",
			         JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
		}catch(IllegalArgumentException e){
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
}