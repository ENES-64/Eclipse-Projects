package lambdaexpressions;
//Functional interfaces only have one method. This annotation gives an error if the interface
//has more than one method.
@FunctionalInterface
interface MyLambda { void display(String str, String str2); }
@FunctionalInterface
interface Add { int addition(int x, int y); }
@FunctionalInterface
interface Lambda { void print(); }
//Using a passed lambda method as an 	object.
class UseLambda { public void callLambda(Lambda ml) {ml.print();} }

public class LambdaExpressions {
	public static void main(String[] args) {
		/* Instead of overriding in this way, we can override the method anonymously 
		 * using lambda expressions.
        MyLambda m =new MyLambda() {
            public void display()
            {
                System.out.println("Hello World");
        	}
        }; */
        //Lambda expression since there is '->'. Using just parentheses to indicate the method.
		//Since functional interfaces only have one method, there is no confusion.
		//We can just put s as an argument and the compiler will know it's a String.
		//Brackets are only needed if it has more than one statement.
		//Lambda expressions can only access local variables of a method where it's defined
		//if the variables are final or effectively final.
		//Lambda expressions can access instance variables and modify them as well.
        MyLambda lambda = (s, s2) -> { System.out.print(s); System.out.println(s2); };
        lambda.display("Hello", " world.");
        //No need to write return as it returns automatically.
        Add addThem = (a, b) -> a + b;
        System.out.println(addThem.addition(10, 20));
        //Passing lambda expression as an object. So, we are passing method as an object.
        UseLambda ul =new UseLambda();
        ul.callLambda(() -> System.out.println("Passed Lambda Object."));
    }
}