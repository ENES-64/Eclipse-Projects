package loop6;

import java.util.Scanner;

public class Loop6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Fibonacci series.
		System.out.println("Enter the amount of terms: ");
		int terms = sc.nextInt(), a = 0, b = 1, c;
		if(terms==1) 
			System.out.print("0.");
		else if(terms>0)
			System.out.print("0, ");
		if(terms==2) 
			System.out.print("1.");
		else if(terms>1)
			System.out.print("1, ");
		terms -= 2;
		for(int i=0;i<terms;i++) {
			c = a + b;
			a = b;
			b = c;
			System.out.print(c);
			if(i == terms - 1) 
				System.out.print('.');
			else
				System.out.print(", ");
		}
	}
}
