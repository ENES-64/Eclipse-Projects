package advancedclass06_challange;

import java.util.Scanner;

import advancedclass06_circle.AdvancedClass06_Circle;
import advancedclass06_rectangle.AdvancedClass06_Rectangle;

public class AdvancedClass06_Challange {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		AdvancedClass06_Circle circle =new AdvancedClass06_Circle();
		AdvancedClass06_Rectangle rectangle =new AdvancedClass06_Rectangle();
		
		System.out.println("Enter a radius: ");
		circle.setRadius(sc.nextDouble());
		System.out.println("Perimeter: " + circle.perimeter());
		System.out.println("Area: " + circle.area());
		System.out.println("\nEnter a length and a breadth: ");
		rectangle.setDimensions(sc.nextDouble(), sc.nextDouble());
		System.out.println("Perimeter: " + rectangle.perimeter());
		System.out.println("Area: " + rectangle.area());
		if(rectangle.isSquare()==true)
			System.out.println("It is a square.");
	}
}