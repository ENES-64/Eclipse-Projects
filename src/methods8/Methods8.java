package methods8;
import java.util.Scanner;

public class Methods8 {
	double area(double l, double b) {
		return l * b;
	}
	double area(double r) {
		return Math.PI*r*r;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Methods8 method =new Methods8();
		System.out.println("Enter a length and a base of a rectangle: ");
		System.out.println("Area of the rectangle is: " + method.area(sc.nextDouble(),sc.nextDouble()));
		System.out.println("Enter a radius of a circle: ");
		System.out.println("Area of the rectangle is: " + method.area(sc.nextDouble()));
	}
}