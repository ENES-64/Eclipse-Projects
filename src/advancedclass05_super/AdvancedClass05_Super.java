package advancedclass05_super;
//A class can be abstract even if it doesn't have any abstract methods.
//A class must be abstract if it has at least one abstract method.
//Abstract classes and methods are for inheritance only.
//Abstract classes and methods can't be final and static.
public abstract class AdvancedClass05_Super {
	public AdvancedClass05_Super() { System.out.println("Super Constructor"); }
	    
	public void meth1() {
	    System.out.println("Meth1 of Super");
	}
	    
	abstract public void meth2();
}