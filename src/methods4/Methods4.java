package methods4;
import java.util.Scanner;

public class Methods4 {
	static boolean primeNumCheck(int x) {
		if(x<2)
			return false;
		else
			for(int i=2;i<x/2;i++)
				if(x%i==0)
					return false;
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		if(primeNumCheck(sc.nextInt())==true)
			System.out.println("It is a prime number.");
		else
			System.out.println("It is not a prime number.");
	}
}