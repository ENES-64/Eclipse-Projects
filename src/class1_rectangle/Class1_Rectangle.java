package class1_rectangle;

public class Class1_Rectangle {
	public double length;
	public double breadth;
	
	public double area() {
		return length * breadth;
	}
	public double perimeter() {
		return 2 * (length * breadth);
	}
	public boolean isSquare() {
		return length == breadth;
	}
}