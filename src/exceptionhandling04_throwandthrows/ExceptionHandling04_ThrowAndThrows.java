package exceptionhandling04_throwandthrows;

public class ExceptionHandling04_ThrowAndThrows {
	//Adding 'throws' to this method, because it can throw an exception.
	static int area(int x, int y) throws Exception {
		if(x < 0 || y < 0)
			//Throw an exception if the given numbers are negative.
			throw new Exception("Area can't be negative.");
		return x * y;
	}//If we don't want to handle the exception in this method, we can add 'throws' to
	//this method as well.
	static void meth2() throws Exception {
		area(-10, 5);
	}
	static void meth3() {
		//Catching the exception in this method.
		try {
			meth2();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
		meth3();
	}
}