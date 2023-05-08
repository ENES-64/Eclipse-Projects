package advancedclass10_innerclasses;

import advancedclass10_outer.AdvancedClass10_Outer;
//Nested classes are useful for big projects to avoid confusion.
public class AdvancedClass10_InnerClasses {
	public static void main(String[] args) {
		//This is a way to access inner class directly, 
		//but it is not recommended as outer class accessing inner class is the ideal way.
		AdvancedClass10_Outer.Inner oi =new AdvancedClass10_Outer().new Inner();
        oi.innerDisplay();
        
        AdvancedClass10_Outer.StaticInner o =new AdvancedClass10_Outer.StaticInner();
        o.staticInnerDisplay();
	}
}