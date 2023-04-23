package methods3;
import java.util.Scanner;

public class Methods3 {
	static String userName(String email) {
		return email.substring(0, email.indexOf('@'));
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your email:");
		String name = userName(sc.nextLine());
		System.out.println("Your user name is: " + name.toUpperCase() + '.');
	}
}