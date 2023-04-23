package class6_product;

public class Class6_Product {
	private int itemNo;
	private byte qty;
	private float[] price = {0f, 0.75f, 1.2f, 8.5f, 2.25f, 0.65f};
	private String[] itemName = {null, " apple", " apricot", " pizza", " pasta", " coke"};
	
	public int getItemNo() {return itemNo;}
	public int getQuantity() {return qty;}
	public float getPrice() {return price[itemNo];}
	public String getItemName() {return itemName[itemNo];}
	
	public void setItemNo (int itemNo) {
		if(itemNo>=price.length)
			//If a varible inside a method has the same name as a variable that is inside a class,
			//use 'this.' to refer to the variable that is outside of the method with the same name.
			this.itemNo = 0;
		else
			this.itemNo = itemNo;
	}
	public void setQuantity(byte q) {qty=(byte) (q > 0 ? q : 1);}
}