package advancedclass12_staticexample;

import advancedclass12_static.AdvancedClass12_Static;

public class AdvancedClass12_StaticExample {
	public static void main(String[] args) {
        //It is possible to call static members of a class without creating an object of it.
		AdvancedClass12_Static.display();
		
		AdvancedClass12_Static t1=new AdvancedClass12_Static();
        t1.show();
        t1.x=30;
        t1.y=50; 
        
        AdvancedClass12_Static t2=new AdvancedClass12_Static();
        t2.show();
        
    }
}