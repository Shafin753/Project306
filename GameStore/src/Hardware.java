/*
 * This DDC contains information about the Hardware which is a subclass of Item superclass.
 * @author Asraful Haque Shafin, Pratikchha Dhungana
 */
public class Hardware extends Item {
	
	private boolean conditionNew;
	
	/*
	 * constructs a Hardware object
	 * @param name name of the hardware
	 * @param price is the price of the hardware
	 * @param date is the date when hardware is added
	 * @param conditionNew checks the condition of the hardware
	 */
	public Hardware(String name, double price, String date, boolean conditionNew){
		super(name,price,date);
		this.conditionNew = conditionNew;
	}
	
	/*
	 * Returns the boolean value indicating whether the condition of hardware is new or not
	 * @return condition of the hardware
	 */
	public boolean getCondition() {
		return this.conditionNew;
	}
	
	/*
	 * Sets the condition of hardware
	 * @param conditionNew indicates whether the condition of hardware is new or not
	 */
	public void setCondition(boolean conditionNew) {
		this.conditionNew = conditionNew;
	}
	
	/*
	 * Returns a string representation of Hardware object
	 * @return toString of a Hardware object 
	 */
	public String toString() {
		
		return super.toString() + "; " + this.conditionNew;
	}
//end class
}
