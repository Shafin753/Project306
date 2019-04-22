/*
 * StoreApplication is a implementation class which allows Game Store employees to add users and items, sort and print them.
 *  The input data are stored in a text file and are printed to the users upon request. In this class, users are prompted to 
 *  choose an action that they would like to perform and based on the user input it either adds items and users, sorts, or prints
 *  report. The program prompts for User and Item information if they are to be added. 
 *  @author Asraful Haque Shafin, Pratikchha Dhungana
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class StoreApplication {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {

		ArrayList<User> userList = new ArrayList<User>(); //creating arrayList for users
		ArrayList<Item> itemList = new ArrayList<Item>(); //creating arrayList for items 
		String usersPath = "./src/users.txt";
		String itemsPath = "./src/item.txt";
		
		
	      int menuChoice = getMenuOption(); //can choose from list of activities to perform
	      while (menuChoice != 5) {
	         switch(menuChoice) {
	            case 1:
	               User user = getUser(itemList); // passing itemList so that items can be stored in a different list than users
	               userList.add(user);
	               break;
	               
	             case 2:
	            	// read item from a text file and display items
	               writingFile(itemList,itemsPath); 
		           //itemList = readingFile(itemsPath);
		           displayItem(itemList);
		           break;
	            case 3:
	               // read users from the text file and display user and items
	            	writingFileUser(userList,usersPath);
	               displayUser(userList);
	               break;
	            case 4:
	               //sort the just items and display the sorted list
	            	sortItems(itemList);
	               break;
	            	
	            default:
	               // Program should never reach this condition if logic is correct
	               throw new RuntimeException("Unknown error in menu choice");
	         
	         }menuChoice = getMenuOption(); 
	      }     
	//end main method 
	}
	
	/*
	 * Prints all users in the arrayList
	 * @param userList is the arrayList that stores users
	 * @return none
	 */
	public static void displayUser(ArrayList<User> userList) {
		String output = "";
		for(int i=0; i<userList.size(); i++){
		  	output += userList.toString();		
		}
		
		JOptionPane.showMessageDialog(null,output);
	}
	
	/*
	 * Prints all items in the itemList
	 * @param itemList is the arrayList that stores all items 
	 * @return none
	 */
	public static void displayItem(ArrayList<Item> itemList) {
		String output = "";
		for(int i=0; i<itemList.size(); i++){
		  	output += "Item Name : " + itemList.get(i).getName()
		  		 +  "\nPrice : "    + itemList.get(i).getPrice()
		  		 +  "\nDate : "    + itemList.get(i).getDate()
		  		 +  "\nNew Condition : "    + itemList.get(i).getPrice()
		  		 + "\n______________________\n"; 			
		}
		
		JOptionPane.showMessageDialog(null,output);
	}
	
	/*
	 * Reads a text file and writes item into a itemList which is the arrayList for Items
	 * @param path is the path to the item text file
	 * @return itemList which is the arrayList
	 */
	public static ArrayList<Item> readingFile(String path) throws FileNotFoundException, IOException{
		ArrayList<Item> itemList = new ArrayList<Item>(); //creating arrayList for Item
		String line;
		Scanner scan = null;
		BufferedReader br = new BufferedReader(new FileReader(new File(path)));
		Item a= null;
		String itemName;
		double price;
		String date;
		boolean condition;
		while((line = br.readLine()) != null) { //reads line from text file while there is more line to read
			scan = new Scanner(line);
			scan.useDelimiter(";");
			itemName = scan.next().trim();
			price = Double.parseDouble(scan.next().trim());
			date = scan.next().trim();
			condition = scan.next().trim() != null;
			a = new Game(itemName,price,date,condition);
			itemList.add(a); //item is stores in a itemList
		}
		br.close();
		return itemList;

	}
	
	/*
	 * Reads the arrayList of User and writes the content into a text file, one user at a time
	 * @param userList is the arrayList that contains all User
	 * @outPath is the file path to store the User information
	 * @return none
	 */
	public static void writingFileUser(ArrayList<User> userList, String outPath) {
		try{
		
			FileOutputStream fis =new FileOutputStream(outPath);
			PrintWriter pw = new PrintWriter(fis);
			for(int i=0; i<userList.size(); i++){
				pw.write(userList.get(i).toString() +"\n"); //writing userList object into a text file
			}
			pw.close();
	
		}
		catch(FileNotFoundException e){
			e.printStackTrace(); 
		}
	}
	
	/*
	 * Writes items into a text file, one Item at a time
	 * @param itemList is the arrayList that contains all Item
	 * @outPath is the file path where Item information is stored
	 * @return none
	 */
	public static void writingFile(ArrayList<Item> itemList, String outPath) {
		try{
		
			FileOutputStream fis =new FileOutputStream(outPath);
			PrintWriter pw = new PrintWriter(fis);
			for(int i=0; i<itemList.size(); i++){
				pw.write(itemList.get(i).toString() +"\n"); //writing itemList object to itemList
			}
			pw.close();
	
		}
		catch(FileNotFoundException e){
			e.printStackTrace(); 
		}
	}
	
	/*
	 * Creates User object and prompts for User information. 
	 * Bases on user entry, creates Item object and prompts for Item information.
	 * @param itemList is the arrayList for Item
	 * @return auser is a User object
	 */
	public static User getUser(ArrayList<Item> itemList) {
		String[] options = {"Game","Hardware","Mechandice"}; //types of Item 
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
			        	aItem = new Game(name, price, date, condition); //creating Game object
			        }
			        else if (x == 1){
			        	aItem = new Hardware(name, price, date, condition); //creating Hardware object
			        }
			        else if(x == 3) {
			        	aItem = new Merchandice(name, price, date, condition); //creating Merchandice object
			        }
			        
			        auser.setItem(aItem); //storing item for the user
			        itemList.add(aItem); //storing item into a itemList
			        	
			    }catch(IllegalArgumentException e)
				{
					JOptionPane.showMessageDialog(null, "Item couldn't be added, " + e.getMessage());
				}
				
			}while (JOptionPane.showConfirmDialog(null, "Would you like to add a another item?", "Create item",
			         JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION); //loops as long as user selects YES
		}catch(IllegalArgumentException e){
			JOptionPane.showMessageDialog(null, "User can not be created " + e.getMessage());
		}
		return auser;
	}
	
	/*
	 * Asks to select from menu options to perform desired activity
	 * @param none
	 * @return menuChoice is the option that was selected to perform 
	 */
	public static int getMenuOption() {
		      int menuChoice;
				
		      do {
		         try {
		            menuChoice = Integer.parseInt(JOptionPane.showInputDialog( 
		               "Enter your selection:"
		            		   + "\n(1) Add a user"
				               + "\n(2) Read the Items from the file and display"
				               + "\n(3) Read the Users and their Items from the file and dispaly"
				               + "\n(4) Sort the Items and display"
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
	
	/*
	 * Sorts items on the arrayList based on name and price of the item
	 * Prints message if the itemList is empty
	 * @param itemList is the arrayList that contains Item 
	 * @return none
	 */
	public static void sortItems(ArrayList<Item>itemList)
	{
		if(itemList.size()==0)
		{
			JOptionPane.showMessageDialog(null, "No item is stored in the Item list; try adding items first");
		}
		else {
				int option = Integer.parseInt(JOptionPane.showInputDialog(null, "Select one of the following option(1 or 2) to sort item: \n 1. By Name \n 2. By Price" ));
				if(option==1 || option==2)
				{
					if(option==1) 
						sortByName(itemList); //calls method to sort item by name
					else
						sortByPrice(itemList); //calls method to sort item by price
				}
				else
					JOptionPane.showMessageDialog(null, "You entered invalid option"); //invalid option selected
		}
	}
	
	/*
	 * This method sorts and prints object in itemList by price
	 * @param itemList is the arrayList that stored items 
	 * @return none
	 */
   	public static void sortByPrice(ArrayList<Item>itemList)
	{
		for(int i=0;i<itemList.size();i++)
		{
			int k = i;
			for(int j=i; j<itemList.size(); j++)
			{
				if(itemList.get(j).getPrice()<itemList.get(k).getPrice())
				{
					k=j;
				}
			}
			Item temp = itemList.get(k);
			itemList.set(k, itemList.get(i));
			itemList.set(i,temp);
		}
		//accumulating and printing sorted item based on price
		String output = "Items are sorted based on Price: \n"; 
		for(int i=0; i<itemList.size(); i++){
		  	output += "Item Name : " + itemList.get(i).getName()
		  		 +  "\nPrice : "    + itemList.get(i).getPrice()
		  		 +  "\nDate : "    + itemList.get(i).getDate()
		  		 +  "\nNew Condition : "    + itemList.get(i).getPrice()
		  		 + "\n______________________\n"; 			
		}
		
		JOptionPane.showMessageDialog(null,output);
	 }
   	
   	/*
   	 * This method sorts Item by their name and prints them to the user
   	 * @param itemList is the arrayList that stores Item
   	 * @return none
   	 */
   	public static void sortByName(ArrayList<Item>itemList)
   	{
   		for(int i=0;i<itemList.size();i++)
   		{
   			int k = i;
   			for(int j=i; j<itemList.size();j++)
   			{
   				if(itemList.get(j).getName().compareTo(itemList.get(k).getName())<0)
   					k=j;
   			}
   			Item temp = itemList.get(k);
   			itemList.set(k, itemList.get(i));
   			itemList.set(i, temp);
   		}
   		//accumulating and printing sorted items based on name
        String output = "Items are sorted based on name: \n";
        Iterator<Item> it = itemList.iterator();
        while(it.hasNext())
        {
           output += it.next() + "\n";
        }
        JOptionPane.showMessageDialog(null, output);
        
       }
//end class
}