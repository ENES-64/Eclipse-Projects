package advancedclass07_interfacesexample;

import advancedclass07_implement.AdvancedClass07_Implement;
import advancedclass07_interface.AdvancedClass07_Interface;
//Interfaces are meant for only overriding.
//Interfaces are useful for achieving run-time polymorhism.
public class AdvancedClass07_InterfacesExample {
	public static void main(String[] args) {
		//This is dynamic method dispatch.
		AdvancedClass07_Interface interFace =new AdvancedClass07_Implement();
		interFace.method();
		interFace.method2();
		
		AdvancedClass07_Implement implement =new AdvancedClass07_Implement();
		implement.method3();
		
		System.out.println("\nInterface identifier: " + AdvancedClass07_Interface.X);
		AdvancedClass07_Interface.staticMethod();
		interFace.defaultMethod();
	}
}