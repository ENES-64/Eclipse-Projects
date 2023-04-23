package methods10;
import java.util.Scanner;

public class Methods10 {
	boolean validate(String name) {return name.matches("[a-zA-Z\\s]+");}
	
	boolean validate(int age) {return (age<=15 && age>=3);}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Methods10 method =new Methods10();
		System.out.println("Enter your name: ");
		for(int i=0;i==0;) {
			if(method.validate(sc.nextLine())==false) {
				System.out.println("Your name was not validated.");
				System.out.println("Enter your name: ");
			}else {
				System.out.println("Enter your age: ");
				if(method.validate(sc.nextInt())==false)
					System.out.println("Your age was not validated.");
				else
					i = 1;
			}
		}
		System.out.println("Your name and age was validated.");
	}
}