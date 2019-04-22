
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class StoreApplication {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<Item> itemList = new ArrayList<Item>();
		String usersPath = "./src/users.txt";
		String itemsPath = "./src/item.txt";
		
		
	      int menuChoice = getMenuOption();
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
	               break;
	            	
	            default:
	               // Program should never reach this condition if logic is correct
	               throw new RuntimeException("Unknown error in menu choice");
	         
	         }menuChoice = getMenuOption(); 
	      }     
	}
	
	public static void displayUser(ArrayList<User> userList) {
		String output = "";
		for(int i=0; i<userList.size(); i++){
		  	output += userList.toString();		
		}
		
		JOptionPane.showMessageDialog(null,output);
	}
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
	public static ArrayList<Item> readingFile(String path) throws FileNotFoundException, IOException{
		ArrayList<Item> itemList = new ArrayList<Item>();
		String line;
		Scanner scan = null;
		BufferedReader br = new BufferedReader(new FileReader(new File(path)));
		Item a= null;
		String itemName;
		double price;
		String date;
		boolean condition;
		while((line = br.readLine()) != null) {
			scan = new Scanner(line);
			scan.useDelimiter(";");
			itemName = scan.next().trim();
			price = Double.parseDouble(scan.next().trim());
			date = scan.next().trim();
			condition = scan.next().trim() != null;
			a = new Game(itemName,price,date,condition);
			itemList.add(a);
		}
		br.close();
		return itemList;

	}
	public static void writingFileUser(ArrayList<User> userList, String outPath) {
		try{
		
			FileOutputStream fis =new FileOutputStream(outPath);
			PrintWriter pw = new PrintWriter(fis);
			for(int i=0; i<userList.size(); i++){
				pw.write(userList.get(i).toString() +"\n");
			}
			pw.close();
	
		}
		catch(FileNotFoundException e){
			e.printStackTrace(); 
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
}