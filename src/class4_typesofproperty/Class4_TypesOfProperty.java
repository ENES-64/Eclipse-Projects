package class4_typesofproperty;

public class Class4_TypesOfProperty {
	//These data are write-only since there is a method that modifies these values,
	//but there are no methods that return any of these values.
	private int m1, m2, m3;
	
	public void setMarks(int x, int y, int z) {
		x = m1;
		y = m2;
		z = m3;
	}
	//This data is read-only since there is a method that returns one of these values,
	//but there are no methods that modify any of these values.
	private int roll;
	
	public int getRoll() {
		return roll;
	}
	//This data is readable and writable since there is a method that returns this value,
	//and a method that modifies this value.
	private String course;
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String c) {
		course = c;
	}
	/* Constructing the class.
	constractor is a method of a class, which is automatically called whenever an object is created.
	constractor will have the name same as the name of the class and it doesn't have a return type.
	Even if there isn't any constractor method in a class, Java will add a default constractor.
	A constractor can also be private. 
	You can overload the constractor.
	*/
	//This constractor is called if the object didn't have any arguments.
	public Class4_TypesOfProperty() {
		roll = 921;
		//Setting course directly.
		course = "Biology";
	}
	//This constractor is called if the object had an integer argument, and a string argument.
	public Class4_TypesOfProperty(int r, String c) {
		roll = r;
		//Setting course indirectly.
		setCourse(c);
	}
}