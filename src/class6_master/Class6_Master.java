package class6_master;
import java.util.Scanner;
import class6_customer.Class6_Customer;
import class6_product.Class6_Product;

public class Class6_Master {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Class6_Product product =new Class6_Product();
		System.out.println("Welcome to the generic store.");
		System.out.println("Enter you ID and name: ");
		Class6_Customer c =new Class6_Customer(sc.nextInt(), sc.nextLine());
		System.out.println("Welcome to the generic store.");
		System.out.println("Enter your address: ");
		c.setCustAddress(sc.nextLine());
		System.out.println("Enter your phone number: ");
		c.setCustTel(sc.next());
		for(int i=1;i>0;i++) {
			if(i!=1) {
				System.out.println("Welcome to the generic store.");
				System.out.println("Do you want to change your address?(Y/N)");
				if(sc.next().equalsIgnoreCase("y")) {
					System.out.println("Enter your address: ");
					c.setCustAddress(sc.next());
				}
				System.out.println("Do you want to change your phone number?(Y/N)");
				if(sc.next().equalsIgnoreCase("y")) {
					System.out.println("Enter your phone number: ");
					c.setCustTel(sc.next());
				}
			}
			System.out.println("Enter the product IDs with the amount(Enter a negative number for ID to finish):");
			String products = "";
			float cost = 0f;
			for(int j=1;j>=1;j++) {
				product.setItemNo(sc.nextInt());
				if(product.getItemNo()!=-1)
					product.setQuantity(sc.nextByte());
				if(product.getItemNo()==0) {
					System.out.println("ID is out of range.");
				}else if(product.getItemNo()<0 && j==1)
					System.out.println("You need to enter at least one product.");
				else if(product.getItemNo()<0)
					j = -1;
				else {
					cost += (float) (product.getPrice());
					if(j==1)
						products += (product.getItemName() + ' ' + product.getQuantity());
					else
						products += ("," + product.getItemName() + ' ' + product.getQuantity());
				}
			}
			System.out.println("Your cart:" + products + '.');
			System.out.println("Total: $" + cost + '.');
		}
	}
}