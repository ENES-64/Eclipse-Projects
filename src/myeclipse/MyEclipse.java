package myeclipse;
import java.util.Scanner;

//(x > y ? x : y) - compare.
public class MyEclipse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter 3 sides of the triangle");
		float a = sc.nextFloat();
		float b = sc.nextFloat();
		float c = sc.nextFloat();
		
		float s = (a+b+c)/2f;
		float area = (float) Math.sqrt(s*(s-a)*(s-b)*(s-c));
		
		System.out.println("Area of the triangle is: " + area);
	}
}