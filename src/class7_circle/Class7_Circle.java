package class7_circle;

public class Class7_Circle {
	private double radius;
    
    public double area() {
        return Math.PI * radius *radius;
    }
    public double perimeter() {
        return 2*Math.PI*radius;
    }
    public double circumference() {
        return perimeter();
    }
    
    public void setRadius(double r) {
    	radius = r < 0 ? 0 : r;
    }
    public double getRadius() {
    	return radius;
    }
}