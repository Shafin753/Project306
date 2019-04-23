
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class TestClasses {

	public static void main(String[] args) throws IOException {
		
		String itemsPath = "./src/item.txt";
		
		//String name = "balsal";
		
		//if(name.indexOf([0-9]) == -1) {
		//	System.out.println("Bal");
		//}
		
		//Game game = new Game("balsal", 10.99, "Date", true);
		
		//System.out.println(game.toString());
		
		//String setNum = "(571)3541282";
		//String regexStr = "^(1\\-)?[0-9]{3}\\-?[0-9]{3}\\-?[0-9]{4}$";
		//if (setNum.matches(regexStr)) {
		//	System.out.println("it works");
		//}
		
		String name = "shafin";
		 Pattern letter = Pattern.compile("[a-zA-z]");
	     Pattern digit = Pattern.compile("[0-9]");
	     Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
	        
	      
	        //Matcher hasLetter = letter.matcher(name);
	     
	     	
	     
	        //System.out.println(hasNumberorSpecial("shfin"));
	     
	     
	     User user = new User();
	     user.setLastName("Shafin");
	     User user2 = new User();
	     user.setLastName("Haque");
	     Item item = new Game("newitem", 10.99,"date", true);
	     Item item2 = new Hardware("newitem", 10.99,"date", true);
	     Item item3 = new Merchandice("newitem", 10.99,"date", true);
	     user.setItem(item);
	     user.setItem(item2);
	     user.setItem(item3);
	     
	     
	     user2.setItem(item);
	     user2.setItem(item2);
	     
	     //System.out.println(user.toString());
	     
	     //int ifNew = JOptionPane.showConfirmDialog(null, "Is the condition new?", "Please select",JOptionPane.YES_NO_OPTION);
	     //System.out.println(ifNew);
		
	        
	     ArrayList<Item> itemList = new ArrayList<Item>();
	     
	     //itemList.add("Shafin");
	     //itemList.add("Haque");
	     
	     
	    // writingFile(itemList,itemsPath);
	     
	     
	     //for(int i=0; i<itemList.size(); i++){
	    //	 System.out.println("Paici");
		//	}
	     BufferedReader br = new BufferedReader(new FileReader(new File(itemsPath)));
			String line;
			Scanner scan = null;
			//int count = 0;
			//while( (line = br.readLine()) != null) {
			//	count++;
			//}
			
			br = new BufferedReader(new FileReader(new File(itemsPath)));
			Item a= null;
			String itemName;
			double price;
			String date;
			boolean condition;
			int i = 0;
			while((line = br.readLine()) != null) {
				scan = new Scanner(line);
				scan.useDelimiter(";");
				itemName = scan.next().trim();
				price = Double.parseDouble(scan.next().trim());
				date = scan.next().trim();
				condition = scan.next().trim() != null;
				a = new Game(itemName,price,date,condition);
			}
			
			
			//System.out.println(a.toString());
			String bal = "xBox; 60.0; 11/02/2019; false";
			String bal3 = bal.substring(bal.lastIndexOf(';')+1);
			System.out.println(bal3);
			
			

	}
	
	 public static boolean hasNumberorSpecial(String name) {
	    	Pattern digit = Pattern.compile("[0-9]");
		   Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
		   
		   boolean found =  digit.matcher(name).find() || special.matcher(name).find();
		   return found;	  
	 }  
	 
		public static String getStudents(String path, ArrayList<Item> itemList) throws FileNotFoundException, IOException{
			BufferedReader br = new BufferedReader(new FileReader(new File(path)));
			String line;
			Scanner scan = null;
			int count = 0;
			while( (line = br.readLine()) != null) {
				count++;
			}
			
			br = new BufferedReader(new FileReader(new File(path)));
			Item s;
			String name;
			double price;
			String date;
			boolean condition;
			int i = 0;
			while((line = br.readLine()) != null) {
				scan = new Scanner(line);
				scan.useDelimiter(":");
				name = scan.next().substring(3).trim();
				price = Double.parseDouble(scan.next().trim());
				
			}
			return "Hello";
		}
	 
		public static void writingFile(ArrayList<String> itemList, String outPath) {
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
	 
}
