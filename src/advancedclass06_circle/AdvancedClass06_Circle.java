package advancedclass06_circle;

import advancedclass06_shape.AdvancedClass06_Shape;

public class AdvancedClass06_Circle extends AdvancedClass06_Shape {
	//Overriding to make this class conrete.
	@Override
	public double perimeter() {
		return 2 * Math.PI * radius;
	}
	@Override
	public double area() {
		return Math.PI * radius * radius;
	}
	
	private double radius;
	
	public void setRadius(double radius) {
		this.radius = radius > 0 ? radius : 0;
	}
}