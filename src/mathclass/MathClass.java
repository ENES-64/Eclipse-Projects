package mathclass;

public class MathClass {
	public static void main(String[] args) {
		System.out.print("Absolute: ");
        System.out.println(Math.abs(-123));
        
        //StrictMath is a more accurate calculation which takes more time to process.
        //But Math class might still use methods from StrictMath class, 
        //which is decided by JVM.
        System.out.print("Strict Absolute: ");
        System.out.println(StrictMath.abs(-123));
  
        System.out.print("Cube Root: ");
        System.out.println(Math.cbrt(27));
        
        /* If we do this, number overflows.
        int i=Integer.MIN_VALUE;
        i--;
        System.out.println(i);
        */
        //But doing this will make sure to not overflow, and instead, throw an exception.
        System.out.print("Exact Decrement: ");
        try {
        	System.out.println(Math.decrementExact(Integer.MIN_VALUE));
        }catch (Exception e) {
        	System.out.println("Number overflowed.");
        }
        
        System.out.print("Exponent value in Floating Point Rep.: ");
        System.out.println(Math.getExponent(123.45));
            
        System.out.print("Round Division: ");
        System.out.println(Math.floorDiv(50, 9));
        
        System.out.print("E power x: ");
        System.out.println(Math.exp(1));
        
        System.out.print("Strict E power x: ");
        System.out.println(StrictMath.exp(1));

        System.out.print("Log base 10: ");
        System.out.println(Math.log10(100));
        
        System.out.print("Maximum of: ");
        System.out.println(Math.max(100, 50));
        
        System.out.print("Tan: ");
        System.out.println(Math.tan(45*Math.PI/180));
       
        System.out.print("Convert to Radians: ");
        System.out.println(Math.toRadians(90));
        
        System.out.print("Convert to Degree: ");
        System.out.println(Math.toDegrees(Math.atan(1)));

        System.out.print("Strict Convert To Degree: ");
        System.out.println(StrictMath.toDegrees(StrictMath.tanh(1)));

        System.out.print("Random: ");
        System.out.println(Math.random()*100);
        
        System.out.print("Power: ");
        System.out.println(Math.pow(2, 3));
        
        //Throws an exception if the result overflows.
        System.out.print("Excact Product: ");
        System.out.println(Math.multiplyExact(100, 200));
        
        System.out.print("Next Float Value: ");
        System.out.println(Math.nextAfter(12.5, 11));
	}
}