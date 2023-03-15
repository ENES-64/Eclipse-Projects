package stringpracticeexpressionschallange;
import java.util.Scanner;

public class StringPracticeExpressionsChallange {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your email:");
		String email = sc.nextLine();
		
		if(email.matches(".*@.*[.].*")==false)
			System.out.println("The email you entered is invalid");
		else{
			String userName = email.substring(0, email.indexOf('@'));
			String domainAddress = email.substring(email.indexOf('@') + 1);
			String domainName = domainAddress.substring(0, domainAddress.indexOf('.'));
			
			System.out.println("User name is: " + userName);
			System.out.println("Domain address is: " + domainAddress);
			System.out.println("Domain name is: " + domainName);
			System.out.println("Is it Gmail?: " + domainName.equalsIgnoreCase("gmail"));
		}
	}
}