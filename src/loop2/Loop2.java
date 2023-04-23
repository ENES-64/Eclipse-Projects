package loop2;
import java.util.Scanner;

public class Loop2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Reverse the entered number.
		System.out.println("Enter a number: ");
		long num = sc.nextLong(), reverse = 0, temp = num;
		if(num>0) {
			while(num>0) {
				reverse = reverse * 10 + num % 10;
				num /= 10;
			}
		}else
			while(num<0) {
				reverse = reverse * 10 + num % 10;
				num /= 10;
			}
		System.out.println(reverse);
		//Check if the number is palindrome or not.
		if(temp==reverse)
			System.out.println("The number is a palindrome.");
		else
			System.out.println("The number is not a palindrome.");
	}
}
