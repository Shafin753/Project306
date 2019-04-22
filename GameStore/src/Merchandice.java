/*
 * This DDC contains information about Merchandice which is a subclass of Item superclass.
 * @author Asraful Haque Shafin, Pratikchha Dhungana
 */
public class Merchandice extends Item {
	
	private boolean conditionNew;
	
	/*
	 * constructs a Merchandise object
	 * @param name name of the Merchandise
	 * @param price is the price of the Merchandise
	 * @param date is the date when Merchandise is added
	 * @param conditionNew checks the condition of the Merchandise 
	 */
	public Merchandice(String name, double price, String date, boolean conditionNew){
		super(name,price,date);
		this.conditionNew = conditionNew;
	}
	
	/*
	 * Returns the boolean value indicating whether the condition of Merchandise is new or not
	 * @return condition of the Merchandise 
	 */
	public boolean getCondition() {
		return this.conditionNew;
	}
	
	/*
	 * Sets the condition of Merchandise
	 * @param conditionNew indicates whether the condition of Merchandise is new or not
	 */
	public void setCondition(boolean conditionNew) {
		this.conditionNew = conditionNew;
	}
	
	/*
	 * Returns a string representation of Merchandise object
	 * @return toString of a Merchandise object 
	 */
	public String toString() {
		
		return super.toString() + "; " + this.conditionNew;
	}

}