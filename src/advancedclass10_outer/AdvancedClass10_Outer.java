package advancedclass10_outer;

public class AdvancedClass10_Outer {
	//If it's not static, inner classes won't be able to access it.
	static int x=10;
	//Creating an object of Inner class for the whole Outer class to access.
    Inner i=new Inner();
    //Nested class inside Outer class.
    public class Inner {
        int y=20;
        public void innerDisplay() {
            System.out.println(x+" "+y);
        }
    }
    //If an inner class is static, its object can be created 
    //without having to create an object for the Outer class first.
    //Only inner classes can be static.
    public static class StaticInner {
    	public void staticInnerDisplay() {
    		System.out.println("Static class.");
    	}
    }
	public void outerDisplay() {
		i.innerDisplay();
        System.out.println(i.y);
    }
}