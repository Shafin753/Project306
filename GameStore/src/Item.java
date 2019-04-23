/*
 * This DDC contains information about the Item superclass. Item is abstract and has 3 subclasses:
 *  Game, Hardware, and Merchandice.
 * @author Asraful Haque Shafin, Pratikchha Dhungana
 * ashafin@gmu.edu (G00950667)
 * pdhungan@.gmu.edu (G00979220)
 */
public abstract class  Item implements Comparable<Item> {
	//declaring variables
	private String name;
	double price;
	private String date;
	private static int numItems;
	
	/*
	 * Specific constructor for Item class; Item class cannot be instantiated as it is abstract.
	 * Variables of Item class are passes to its subclasses. 
	 * @param name is the name of an item
	 * @param price is the price of an item
	 * @param date is the date when item is added
	 */
	public Item(String name, double price, String date)
	{
		//validating values
		if(name == null || name.equals(""))
			throw new IllegalArgumentException("Name cannot be null");
		if(price<=0)
			throw new IllegalArgumentException("Price cannot be zero or less");
		if(date == null || date.equals(""))
			throw new IllegalArgumentException("Date cannot be null");
		//assigning values
		this.name = name;
		this.price = price;
		this.date = date;
		numItems++;
	}
	public String getName() {return this.name;} //returns the name of the item
	public double getPrice() {return this.price;} //returns the price of the item
	public String getDate() {return this.date;} //returns the date for that particular item
	public int getNumItems() {return numItems;} //returns the number of items 
	
	/*
	 * This method validates and sets the name of an item
	 * @param name is the name of the item
	 * @return none
	 */
	public void setName(String name)
	{
		if(name == null || name.equals(""))
			throw new IllegalArgumentException("Name cannot be null");
		this.name = name;
	}
	
	/*
	 * This method validates and sets the price of an item
	 * @param price is the cost of an item
	 * @return none
	 */
	public void setPrice(double price)
	{
		if(price<=0)
			throw new IllegalArgumentException("Price cannot be zero or less");
		this.price = price;
	}
	
	/*
	 * This method validates and sets the date for a item
	 * @param date is the date when item is added
	 * @return none
	 */
	public void setDate(String date)
	{
		if(date == null || date.equals(""))
			throw new IllegalArgumentException("Date cannot be null");
		this.date = date;
	}

	/*
	 * This method returns the string representation of the item
	 * @param none
	 * @return toString of Item 
	 */
	public String toString()
	{
		return this.getName() + "; " + this.getPrice() + "; " + this.getDate(); 
	}
	
	/*
	 * Compares two objects and returns integer
	 * @param o is the object 
	 */
	public int compareTo(Item o)
	{
		if(this.getName().compareToIgnoreCase(o.getName())<0)
			return -1;
		else if (this.getName().compareToIgnoreCase(o.getName())>0)
			return 1;
		else 
			return 0;
	}
//end class
}

