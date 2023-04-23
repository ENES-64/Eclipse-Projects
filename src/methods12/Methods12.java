package methods12;
import java.util.Scanner;

public class Methods12 {
	long max(long... x) {
		if(x.length == 0)
			return Long.MIN_VALUE;
		long max = x[0];
		for(long a : x)
			if(a>max)
				max = a;
		return max;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Methods12 method =new Methods12();
		int amount = 0;
		for(int i=0;i==0;) {
			System.out.println("Type the amount of numbers you want to enter: ");
			amount = sc.nextInt();
			if(amount<0)
				System.out.println("You can't enter a negative number.");
			else
				i++;
		}
		long nums[] =new long [amount];
		if(amount==1)
			System.out.println("Enter a number:");
		else if(amount!=0)
			System.out.println("Enter " + amount + " numbers:");
		for(int i=0;i<amount;i++)
			nums[i] = sc.nextLong();
		System.out.println("Maximum number you entered was " + method.max(nums) + '.');
	}
}