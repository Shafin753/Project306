
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class TestClasses {

	public static void main(String[] args) {
		
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
		
	        
	     ArrayList<String> itemList = new ArrayList<String>();
	     
	     itemList.add("Shafin");
	     itemList.add("Haque");
	     
	     
	     for(int i=0; i<itemList.size(); i++){
	    	 System.out.println("Paici");
			}
	     

	}
	
	 public static boolean hasNumberorSpecial(String name) {
	    	Pattern digit = Pattern.compile("[0-9]");
		   Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
		   
		   boolean found =  digit.matcher(name).find() || special.matcher(name).find();
		   return found;	  
	 }  
	 
}
