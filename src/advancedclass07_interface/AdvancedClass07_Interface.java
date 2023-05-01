package advancedclass07_interface;
/*
If an abstract class only has abstract methods, then instead of using an abstract class,
we can use interfaces. Interface's contents are already abstract and public by default, 
so we don't have to write them.
To use an interface in a class, instead of using 'extends', use 'implements'.
Unlike 'extends' which can only use one class, 'implements' can use multiple interfaces.
It is advised to put 'I' before the name of an interface to make it easier to
understand it is an interface when referring. For example, ICalculator instead of Calculator.
Methods cant' be private unless it's private, and if it's private, then it can't be abstract. 
Identifiers are static and final by default, but can't be private.
An interface can extend from another interface. For example:
public interface Interfaces2 extends Interfaces {}
 */
public interface AdvancedClass07_Interface {
	//This is an identifier. It is advised to use a capital letter for naming.
	int X = 10;
	//These are the public abstract methods.
	void method();
	void method2();
	//If a method is static, it can have contents. 
	//It can be called in the main class by just using interface's name since it's static.
	static void staticMethod() {
		System.out.println("Static Method.");
	}
	//A private method can also have contents, but it can only be used internally.
	private void privateMethod() {
		System.out.println("Private Method.");
	}
	//A default method can also have contents.
	//This is useful if you're modifying an interface later on and don't want existing
	//classes to become abstract for not overriding the added method.
	default void defaultMethod() {
		System.out.println("Default Method.");
		//It can call private methods as well.
		privateMethod();
	}
}