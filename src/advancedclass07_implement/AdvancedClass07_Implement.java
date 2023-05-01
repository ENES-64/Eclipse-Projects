package advancedclass07_implement;

import advancedclass07_interface.AdvancedClass07_Interface;
//Using 'implements' to implement an interface.
public class AdvancedClass07_Implement implements AdvancedClass07_Interface {
	@Override
	public void method() {
		System.out.println("Method 1");
	}
	@Override
	public void method2() {
		System.out.println("Method 2");
	}
	
	public void method3() {
		System.out.println("Method 3");
	}
}