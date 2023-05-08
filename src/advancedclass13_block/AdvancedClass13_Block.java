package advancedclass13_block;

public class AdvancedClass13_Block {
	public static int s;
	//Static blocks are executed as the class loads.
	//This is not commonly used as static variables and methods are preferred alternatives.
	static {
		System.out.println("Block 1.");
		s = 10;
	}
	static {
		System.out.println("Block 2.");
	}
}