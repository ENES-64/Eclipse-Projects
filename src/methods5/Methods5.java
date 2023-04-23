package methods5;
import java.util.Scanner;

public class Methods5 {
	static int findGCD(int x, int y) {
		if(x<0 || y<0)
			return -1;
		else if(x==0 || y==0)
			return (x > y ? x : y);
		while(x!=y)
			if(x>y)
				x -= y;
			else
				y -= x;
		return x;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 2 whole numbers: ");
		int gcd = findGCD(sc.nextInt(), sc.nextInt());
		if(gcd<0)
			System.out.println("You entered a negative number.");
		else
			System.out.println("Greatest common divisor of the two numbers is: " + 	gcd);
	}
}