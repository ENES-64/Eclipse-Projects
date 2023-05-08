package advancedclass12_static;

public class AdvancedClass12_Static {
	public static int x=10;
    public int y=20;
    
    public void show() {
        System.out.println(x+" "+y);
    }
    //Static methods can only access static varibles and methods within a class.
    public static void display() {
        System.out.println(x);
    }
}