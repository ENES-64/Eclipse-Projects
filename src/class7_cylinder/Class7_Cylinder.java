package class7_cylinder;
import class7_circle.Class7_Circle;

//Cylinder class inherits the Circle class:
public class Class7_Cylinder extends Class7_Circle {
	private double height;
	
	public double volume() {
		return area() * height;
	}
	
	public void setDimensions(double r, double h) {
		setRadius(r);
		setHeight(h);
	}
	public void setHeight(double h) {
		height = h < 0 ? 0 : h;
    }
    public double getHeight() {
    	return height;
    }
}