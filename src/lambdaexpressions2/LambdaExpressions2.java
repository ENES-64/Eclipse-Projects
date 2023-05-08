package lambdaexpressions2;
@FunctionalInterface
interface LambdaDisplay { public void display(String str); }
@FunctionalInterface
interface LambdaCompare { public int compare(String str, String str2); }

public class LambdaExpressions2 {
	public LambdaExpressions2(String s) {
		System.out.println(s.toUpperCase());
	}
	public static void main(String[] args) {
		//Overriding the display method by making it function like println.
		//So, whatever String we pass, it prints automatically.
		//System is a class, out is an object, println is a method. :: is a scope resolution.
		LambdaDisplay le = System.out::println;
		le.display("Hello world.");
		//This one overrides display method with the contructor.
		LambdaDisplay le2 = LambdaExpressions2::new;
		le2.display("Hello world.");
		//This one overrides compare method with the compareTo method from String.
		LambdaCompare lc = String::compareTo;
		System.out.println(lc.compare("Hello world.", "hello world."));
	}
}