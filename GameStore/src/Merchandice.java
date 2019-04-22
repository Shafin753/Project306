
public class Merchandice extends Item {
	
	private boolean conditionNew;
	
	public Merchandice(String name, double price, String date, boolean conditionNew){
		super(name,price,date);
		this.conditionNew = conditionNew;
	}
	
	
	public boolean getCondition() {
		return this.conditionNew;
	}
	
	public void setCondition(boolean conditionNew) {
		this.conditionNew = conditionNew;
	}
	
	public String toString() {
		
		return super.toString() + "; " + this.conditionNew;
	}

}