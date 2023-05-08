package exceptionhandling05_finally;

public class ExceptionHandling05_Finally {
	static void meth() throws Exception {
		try {
			throw new Exception("Exception.");
		//finally executes whether there is an expection or not. 
		//If there is a catch after try, then finally is unnecessary since 
		//it will continue executing anyway, unless there are multiple catch blocks,
		//inwhich a finally block assures the code will get executed.
		}finally {
			System.out.println("Final Message.");
		}
	}
	//If main method throws an exception, it goes to JVM, then the program crashes.
	public static void main(String[] args) throws Exception {
		meth();
	}
}