package class1_master;
import java.util.Scanner;
import class1_circle.Class1_Circle;
import class1_cylinder.Class1_Cylinder;
import class1_rectangle.Class1_Rectangle;
//Class vs object with explanation at the bottom.
public class Class1_Master {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Class1_Circle circle =new Class1_Circle();
		Class1_Circle circle2 =new Class1_Circle();
		Class1_Cylinder cylinder =new Class1_Cylinder();
		
		Class1_Rectangle rectangle =new Class1_Rectangle();
		
		System.out.println("Enter two different radiuses:");
		circle.radius = sc.nextDouble();
		circle2.radius = sc.nextDouble();
		System.out.println("First circle:");
		System.out.println("Area: " + circle.area());
		System.out.println("Perimeter: " + circle.perimeter());
		System.out.println("Circumference: " + circle.circumference());
		System.out.println("\nSecond circle:");
		System.out.println("Area: " + circle2.area());
		System.out.println("Perimeter: " + circle2.perimeter());
		System.out.println("Circumference: " + circle2.circumference());
		
		System.out.println("\nEnter a length and a breadth of a rectangle or a square:");
		rectangle.breadth = sc.nextDouble();
		rectangle.length = sc.nextDouble();
		
		if(rectangle.isSquare()==false)
			System.out.println("\nRectangle:");
		else
			System.out.println("\nSquare:");
		System.out.println("Area: " + rectangle.area());
		System.out.println("Perimeter: " + rectangle.perimeter());
		
		System.out.println("\nEnter a height and a radius of a cylinder:");
		cylinder.height = sc.nextDouble();
		cylinder.radius = sc.nextDouble();
		System.out.println("Lid area: " + cylinder.lidArea());
		System.out.println("Total surface area: " + cylinder.totalSurfaceArea());
		System.out.println("Volume: " + cylinder.volume());
		System.out.println("Circumference: " + cylinder.circumference());
	}
}
/*
1. Abstraction
	Things that should be presented to users. Like buttons.
2. Encapsulation
	Things that should be hidden to users. Like wiring and circuitry.
3. Inheritance (Specialization)
	Process of acquiring features of an existing class into a new class.
4. Polymorphism (Generalization)
	Naming things that are similar. Like TVs and cars.

An object is defined in terms of its properties and behavior.
A property is things like its color, material, which things are on or off.
A behavior is things that utilize or modify properties. Like a button to turn it on or off.
To define an object, write a summary of what it does. 
Nouns or adjectives are properties. Verbs are behaviors.
While programming, properties are converted to variables and behaviors are converted to methods.

A class is like a design of an object. Like how a blueprint is a design of a house.
A class can be used by objects many times.
*/