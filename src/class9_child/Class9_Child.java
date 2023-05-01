package class9_child;

import class9_parent.Class9_Parent;

public class Class9_Child extends Class9_Parent {
	public Class9_Child() {
		System.out.println("Child Non-Param Constuctor.");
	}
	public Class9_Child(int y) {
		System.out.println("Child Param Constuctor.");
	}
	public Class9_Child(int x, int y) {
		//Calls super class's constructer. Must be in the first line, else won't work.
		super(x);
		System.out.println("Child 2 Param Constuctor. Value: " + y);
	}
}