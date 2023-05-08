package exceptionhandling03_customexception;

@SuppressWarnings("serial")
//To make your own exception, you must inherit from the class Exception, 
//else it won't be an exception.
class LowBalanceException extends Exception {
	//Overriding toString to our custom message.
    public String toString() {
        return "Balance Should not be less than $100.";
    }
}

public class ExceptionHandling03_CustomException {
	static void fun1() {
        try {
        	//This line manually causes an exception.
            throw new LowBalanceException();
        }catch(LowBalanceException e) {
            System.out.println(e);
            //This prints the traced methods that were used before producing an expection error.
            //It isn't recommended since user shouldn't be bothered with this and
            //it can leak data to the user.
            e.printStackTrace();
        }
    }
    static void fun2() {
        fun1();
    }
    static void fun3() {
        fun2();
    }
    public static void main(String[] args) {
       fun3();
    }   
}