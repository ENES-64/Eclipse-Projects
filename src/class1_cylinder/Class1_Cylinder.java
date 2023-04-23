package class1_cylinder;

public class Class1_Cylinder {
	public double radius;
	public double height;
	
	public double lidArea() {
		return Math.PI * radius * radius;
	}
	public double totalSurfaceArea() {
		return 2 * lidArea() + circumference() * height;
	}
	public double volume() {
		return 2 * Math.PI * radius;
	}
	public double circumference() {
		return lidArea() * height;
	}
}