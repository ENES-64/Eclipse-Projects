package wrapperclasses;

public class WrapperClasses {
	@SuppressWarnings("unused")
	//There are 3 parts.
	public static void main(String[] args) {
		/* Part 1:
		 * All the variables that hold a numeric value inherit from the number class.
		 * Character and Boolean do not inherit from the number class.
		 */
		//Deprecated
		@SuppressWarnings("removal")
		Integer i=new Integer(10);
		Integer a=Integer.valueOf(10);
        Integer b=10;
        
        Byte c=15;
        Byte d=Byte.valueOf("15");
        
        Short f=Short.valueOf("123");
        
        Float g=12.3f;
        
        Double j=Double.valueOf(123.456);
        
        Character k=Character.valueOf('A');
        
        Boolean l=Boolean.valueOf("true");
        
        //This is called boxing. e is a reference to a primitive variable, bb.
        //So, we wrap this primitive type of value with an object.
        byte bb=15;
        Byte e=Byte.valueOf(bb);
        //This is called auto boxing since valueOf() is automatically called.
        Byte z=e;
        
        Float h=Float.valueOf("123.5");
        //This is called unboxing. x is a primitive type variable which gets assigned 
        //to a value of an object.
        //So, we unwrap this primitive type of value from an object.
        float x=h.floatValue();
        //This is called auto unboxing since floatValue() is automatically called.
        float y=h;
        
        int m=10;
        //Integer n=Integer.valueOf(m);
        //Auto boxing.
        Integer n=m;
        //int p=n.intValue();
        //Auto unboxing.
        int p=n;
        
        //Part 2:
        System.out.println("Part 2:");
        Integer num = 10;
        Integer num2 = num;
        System.out.println(num.compareTo(num2));
        System.out.println(num.equals(num2));
        num2 = 20;
        System.out.println(num.compareTo(num2));
        System.out.println(num.equals(num2));
        //Assigning number using binary.
        Integer num3 = Integer.valueOf("1010", 2);
        System.out.println("Binary to number: " + num3);
        //Assigning number using hexadecimal.
        num3 = Integer.valueOf("A7", 16);
        System.out.println("Hexadecimal to number: " + num3);
        //Reverse byte is a complicated topic.
        System.out.println("Reverse bytes of 128: " + Integer.reverseBytes(128));
        //There are many more that are useful.
        
        //Part 3:
        System.out.println("\nPart 3:");
        
        Float fl = 12.5f/0;
        System.out.println("Is 12.5 infinite? " + fl.isInfinite());
        
        fl = (float) Math.sqrt(-1);
        System.out.println("Is square root of -1 not a number? " + fl.isNaN());
	}
}