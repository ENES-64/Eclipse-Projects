package class6_customer;

public class Class6_Customer {
	private int custId;
	private String custTel, custName, custAddress;
	
	public int getCustId() {return custId;}
	public String getCustTel() {return custTel;}
	public String getCustName() {return custName;}
	public String getCustAddress() {return custAddress;}
	
	public void setCustTel(String t) {custTel = t;}
	public void setCustAddress(String a) {custAddress = a;}
	
	public Class6_Customer(int i, String n) {
		custId = i;
		custTel = "";
		custName = n;
		custAddress = "";
	}
}