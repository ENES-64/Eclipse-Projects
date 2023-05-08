package advancedclass11_outer;

abstract class AbstractClass {
	abstract public void show();
}

public class AdvancedClass11_Outer {
	public void display() {
		//Creating an class for this method only.
		class Inner {
			public void show() {
				System.out.println("An inner class.");
			}
		}
		//Calling the method inside of Inner class without a reference
		//which will create a nameless object.
		new Inner().show();
	}
	public void display2() {
		//Instead of creating a whole class for inheritance, 
		//we can override the methods on the fly and create an
		//anonymous class with no name, but a referenace. 
		//Same can be done to interfaces.
		AbstractClass a =new AbstractClass() {
			public void show() {
				System.out.println("An anonymous inner class.");
			}
		//Semi-colon at the end is required.
		};
		a.show();
	}
	public void display3() {
		//It can also be done without a reference to be used once.
		//It's an anonymous class with an anonymous reference.
		//Same can be done to interfaces.
		new AbstractClass() {
			public void show() {
				System.out.println("An anonymous inner class with an anonymous reference.");
			}
		}.show();
	}
}