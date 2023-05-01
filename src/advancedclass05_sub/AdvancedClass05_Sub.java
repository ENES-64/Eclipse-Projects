package advancedclass05_sub;

import advancedclass05_super.AdvancedClass05_Super;
//If a sub class overrides all the abstract methods, it can be made as a conrete class.
public class AdvancedClass05_Sub extends AdvancedClass05_Super {
	public void meth2() {
		System.out.println("Meth2 of Sub");
	}
}