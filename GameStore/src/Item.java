//This is a DDC for Item class

public abstract class  Item {
	private String name;
	double price;
	private String date;
	private static int numItems;
	
	public Item(String name, double price, String date)
	{
		if(name == null || name.equals(""))
			throw new IllegalArgumentException("Name cannot be null");
		if(price<=0)
			throw new IllegalArgumentException("Price cannot be zero or less");
		if(date == null || date.equals(""))
			throw new IllegalArgumentException("Date cannot be null");
		this.name = name;
		this.price = price;
		this.date = date;
		numItems++;
	}
	public String getName() {return this.name;}
	public double getPrice() {return this.price;}
	public String getDate() {return this.date;}
	public int getNumItems() {return numItems;}
	
	public void setName(String name)
	{
		if(name == null || name.equals(""))
			throw new IllegalArgumentException("Name cannot be null");
		this.name = name;
	}
	public void setPrice(double price)
	{
		if(price<=0)
			throw new IllegalArgumentException("Price cannot be zero or less");
		this.price = price;
	}
	public void setDate(String date)
	{
		if(date == null || date.equals(""))
			throw new IllegalArgumentException("Date cannot be null");
		this.date = date;
	}

	public String toString()
	{
		return this.getName() + "; " + this.getPrice() + "; " + this.getDate(); 
	}

}

