package main;

public class TestDivisionByZero {
	
	static double num1;
	static double num2;

	public static void main(String[] args) {
		divsion();
	}

	private static void divsion() {
		try {
			num1 = 10;
			num2 = 0;
			double a= 10/0;
			if(a == Double.POSITIVE_INFINITY || a == Double.NEGATIVE_INFINITY) {
				throw new ArithmeticException();

			}
			else{

				System.out.println(" The answer is " +a);
			}
		}catch(ArithmeticException e){
			System.out.println(" You can't divide by zero. Please try again.");
		}
	}
	

}
