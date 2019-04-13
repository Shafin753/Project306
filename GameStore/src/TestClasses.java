
public class TestClasses {

	public static void main(String[] args) {
		
		String name = "balsal";
		
		//if(name.indexOf([0-9]) == -1) {
		//	System.out.println("Bal");
		//}
		
		Game game = new Game("balsal", 10.99, "Date", true);
		
		System.out.println(game.toString());
		

	}

}
