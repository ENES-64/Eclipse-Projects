package advancedclass01_overriding;

import advancedclass01_sub.AdvancedClass01_Sub;
import advancedclass01_super.AdvancedClass01_Super;

public class AdvancedClass01_Overriding {
	public static void main(String[] args) {
		
		AdvancedClass01_Super superclass=new AdvancedClass01_Super();
		superclass.display();
		System.out.println();
		AdvancedClass01_Sub subclass =new AdvancedClass01_Sub();
		subclass.display();
		System.out.println();
		//The method will be called depending on the object not on referance.
		//When a super class referance which is holding an object of subclass and
		//an overrided method is called, then the method of object will be called.
		//This is called dynamic method dispatch.
		AdvancedClass01_Super superclass2=new AdvancedClass01_Sub();
		superclass2.display();
	}
}