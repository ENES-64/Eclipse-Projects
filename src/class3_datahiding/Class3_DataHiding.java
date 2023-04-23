package class3_datahiding;
//Private variables, objects and methods can't be accessed outside of its own class.
public class Class3_DataHiding {
	private int length;
	private int breadth;
	
	public void setLength(int l) {
		if(l>0)
			length = l;
		else
			length = 0;
	}
	public void setBreadth(int b) {
		if(b>0)
			breadth = b;
		else
			breadth = 0;
	}
	public int getLength() {
		return length;
	}
	public int getBreadth() {
		return breadth;
	}
	//Calling length and breadth directly.
	private int area() {
		return length * breadth;
	}
	//Calling length and breadth indirectly.
	private int perimeter() {
		return 2 * (getLength() * getBreadth());
	}
	public String toString() {
		return ("Area: " + area() + "\nPerimeter: " + perimeter());
	}
}