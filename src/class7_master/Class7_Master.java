package class7_master;
import class7_cylinder.Class7_Cylinder;

public class Class7_Master {
	public static void main(String[] args) {
		Class7_Cylinder cylinder =new Class7_Cylinder();
		
		cylinder.setDimensions(7, 10);
		
		System.out.println("Set radius: " + cylinder.getRadius() + '.');
		System.out.println("Set height: " + cylinder.getHeight() + '.');
		System.out.println("Area: " + cylinder.area() + '.');
		System.out.println("Perimeter: " + cylinder.perimeter() + '.');
		System.out.println("Circumference: " + cylinder.circumference() + '.');
		System.out.println("Volume: " + cylinder.volume() + '.');
	}
}