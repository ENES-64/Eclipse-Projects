package objectmethod;
//Any class automatically inherits from the Object class, because Object class is a 
//super class of all classes.
class MyObject /*extends Object*/ {}

class MyObject2 extends MyObject {
	public String toString() {
		return "My Object.";
	}
	public int hashCode() {
		//Hash codes are unique for each created object and this method uses that to
		//create a number. Overriding this method will make all the objects have
		//the same number.
		return 100;
	}
	//Returns true if the hash code methods of the objects are the same
	//rather than the actual hash code.
	public boolean equals(Object o) {
		return this.hashCode() == o.hashCode();
	}
	//Other methods can't be overrided since those methods are final and used for
	//multi-threading.
}

public class ObjectMethod {
	public static void main(String[] args) {
		System.out.println("MyObject:");
		MyObject o1 =new MyObject();
		MyObject o2 =new MyObject();
		System.out.println(o1);
		System.out.println(o1.equals(o2));
		System.out.println(o1.hashCode());
		System.out.println(o2.hashCode());
		System.out.println("\nMyObject2:");
		MyObject2 mo1 =new MyObject2();
		MyObject2 mo2 =new MyObject2();
		System.out.println(mo1);
		System.out.println(mo1.equals(mo2));
		System.out.println(mo1.hashCode());
	}
}