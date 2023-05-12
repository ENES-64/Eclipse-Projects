package stringbufferbuilder;

public class StringBufferBuilder {
	public static void main(String[] args) {
		//This one creates an array of characters with the size of the given String.
		//This String object is immutable
		String s1=new String("Hello");
        //This one creates an array of characters with the default size of 16.
		//This String object is mutable and thread safe. So, it will run slower.
        StringBuffer s2=new StringBuffer("Hello");
        //This one is the same, but it's not thread safe. So, if more than one thread
        //accesses this object, there is a risk of losing data.
        StringBuilder s3=new StringBuilder("Hello");
        
        s1.concat(" World");
        s2.append(" World");
        s3.append(" World");
        
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
	}
}