package problem.solving;

public class ExceptionReturn {

	public static int methodWithFinally(){
		
		try {
			System.out.println("Throws Exception");
			throw new Exception();
			
		} catch (Exception e) {			
			System.err.println("In catch block");
			return 1;
		}finally{
			System.err.println("In finally block");
			return 2;
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("Main"+methodWithFinally());
	}
	
}
