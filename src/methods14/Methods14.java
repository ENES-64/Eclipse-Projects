package methods14;
import java.util.Scanner;

public class Methods14 {
	double discount(double... prices) {
		int sum = 0;
		for(int i=0;i<prices.length;i++)
			sum += prices[i];
		if(sum<500)
			return sum * 0.10;
		else if(sum<1000)
			return sum * 0.15;
		else
			return sum * 0.20;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Methods14 method =new Methods14();
		int amount = 0;
		for(int i=0;i==0;) {
			System.out.println("How many items did you buy?");
			amount = sc.nextInt();
			if(amount<1)
				System.out.println("You can't enter less than 1.");
			else
				i++;
		}
		double items[] =new double[amount];
		System.out.println("Enter the prices of the items you bought: ");
		for(int i=0;i<amount;i++) {
			items[i] = sc.nextDouble();
			if(items[i]<=0) {
				System.out.println("You can't enter 0 or a negative number.");
				i--;
			}
		}
		System.out.println("Your discount is $" + method.discount(items) + '.');
	}
}