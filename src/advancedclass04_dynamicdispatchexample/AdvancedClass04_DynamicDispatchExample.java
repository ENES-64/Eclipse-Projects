package advancedclass04_dynamicdispatchexample;

import advancedclass04_sub.AdvancedClass04_Sub;
import advancedclass04_super.AdvancedClass04_Super;
//Method overloading is compile-time polymorhpism. Method overriding is run-time polymorhpism.
public class AdvancedClass04_DynamicDispatchExample {
	public static void main(String[] args) {
		AdvancedClass04_Super sup =new AdvancedClass04_Super();
		sup.method1();
		sup.method2();
		System.out.println();
		AdvancedClass04_Sub sub =new AdvancedClass04_Sub();
		sub.method1();
		sub.method2();
		sub.method3();
		System.out.println();
		//This is called 'Dynamic Method Dispatch.'
		AdvancedClass04_Super s =new AdvancedClass04_Sub();
		s.method1();
		//method 2 is overrided since the referance super class holds the sub class's object.
		s.method2();
		//method 3 not allowed since the referance is from super class.
		//s.method3();
	}
}