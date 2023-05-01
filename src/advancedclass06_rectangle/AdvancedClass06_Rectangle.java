package advancedclass06_rectangle;

import advancedclass06_shape.AdvancedClass06_Shape;

public class AdvancedClass06_Rectangle extends AdvancedClass06_Shape {
	//Overriding to make this class conrete.
	@Override
	public double area() {
		return length * breadth;
	}
	@Override
	public double perimeter() {
		return 2 * (length * breadth);
	}
	
	private double length, breadth;
	
	public void setDimensions(double length, double breadth) {
		this.length = length > 0 ? length : 0;
		this.breadth = breadth > 0 ? breadth : 0;
	}
	public boolean isSquare() {
		return length == breadth;
	}
}