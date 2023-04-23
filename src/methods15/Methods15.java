package methods15;
import java.util.Scanner;

public class Methods15 {
	static void countUp(int n) throws InterruptedException {
		if(n>0) {
			countUp(n-1);
			System.out.println(n);
			Thread.sleep(1000);
		}
	}
	static void countDown(int n) throws InterruptedException {
		if(n>=0) {
			System.out.println(n);
			Thread.sleep(1000);
			countDown(n-1);
		}
	}
	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Type 'u' if you want to count up.\nType 'd' if you want to count down.");
		String option = sc.nextLine();
		if(option.matches("u")==true) {
			System.out.println("Enter the amount of seconds to count up: ");
			countUp(sc.nextInt());
		}else if(option.matches("d")==true) {
			System.out.println("Enter the amount of seconds to count down: ");
			countDown(sc.nextInt());
		}else
			System.out.println("Wrong option entered.");
	}
}