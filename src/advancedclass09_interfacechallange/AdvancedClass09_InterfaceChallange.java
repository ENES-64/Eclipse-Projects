package advancedclass09_interfacechallange;

import advancedclass09_customer.AdvancedClass09_Customer;
import advancedclass09_store.AdvancedClass09_Store;

public class AdvancedClass09_InterfaceChallange {
	public static void main(String[] args) {
		AdvancedClass09_Customer cust =new AdvancedClass09_Customer("John Doe");
		AdvancedClass09_Customer cust2 =new AdvancedClass09_Customer("Jeremy Kenneth");
		AdvancedClass09_Customer cust3 =new AdvancedClass09_Customer("Nick Nickson");
		
		AdvancedClass09_Store store =new AdvancedClass09_Store();
		
		store.register(cust);
		store.register(cust2);
		store.register(cust3);
		
		store.inviteSale();
	}
}