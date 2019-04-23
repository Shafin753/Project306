/*
 * This DDC contains information about the Game which is a subclass of Item superclass.
 * @author Asraful Haque Shafin, Pratikchha Dhungana
 * ashafin@gmu.edu (G00950667)
 * pdhungan@.gmu.edu (G00979220)
 */
public class Game extends Item {
	
	private boolean conditionNew;
	
	/*
	 * constructs a Game object
	 * @param name name of the game
	 * @param price is the price of the game 
	 * @param date is the date when item is added
	 * @param conditionNew checks the condition of the game
	 */
	public Game(String name, double price, String date, boolean conditionNew){
		super(name,price,date); //calling a super class
		this.conditionNew = conditionNew;
	}
	
	/*
	 * Returns the boolean value indicating whether the condition of game is new or not
	 * @return condition of the game
	 */
	public boolean getCondition() {
		return this.conditionNew;
	}
	
	/*
	 * Sets the condition of game
	 * @param conditionNew indicates whether the condition of game is new or not
	 */
	public void setCondition(boolean conditionNew) {
		this.conditionNew = conditionNew;
	}
	
	/*
	 * Returns a string representation of Game object
	 * @return toString of a Game object 
	 */
	public String toString() {
		
		return super.toString() + "; " + this.conditionNew;
	}
//end class
}
