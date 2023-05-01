package advancedclass05_abstractexample;

import advancedclass05_sub.AdvancedClass05_Sub;
import advancedclass05_super.AdvancedClass05_Super;
//Abstract classes are there to impose standarts for sub classes to follow.
public class AdvancedClass05_AbstractExample {
	public static void main(String[] args) {
		//Object of an abstract class can't be created.
		//AdvancedClass05_Super super =new AdvancedClass05_Super();
		//But a reference can be created.
		AdvancedClass05_Super superReference;
		//And it can hold an object of its subclass if it overrides all the abstract methods.
		superReference =new AdvancedClass05_Sub();
		superReference.meth1();
		superReference.meth2();
    }    
}