package class5_cylinder;

public class Class5_Cylinder {
	//Private.
	private double radius, height;
	//Read.
	public double getRadius() {return radius;}
	public double getHeight() {return height;}
	//Write.
	public void setRadius(double r) {radius = (r > 0 ? r : 0);}
	public void setHeight(double h) {height = (h > 0 ? h : 0);}
	public void setDimensions(double r, double h) {setRadius(r);setHeight(h);}
	//Non-parameterized constructor.
	public Class5_Cylinder() {setDimensions(10d,30d);}
	//Parameterized constructors.
	public Class5_Cylinder(double r) {setDimensions(r,1d);}
	public Class5_Cylinder(double r, double h) {setDimensions(r,h);}
	//Math
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