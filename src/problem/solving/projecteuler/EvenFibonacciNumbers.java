package problem.solving.projecteuler;

public class EvenFibonacciNumbers {

	public static void main(String[] args) {
		final int MAX_RANGE = 4000000;
		int result = 0;
		int number = 1;
		int sumOfEvenValues = 0;
		while ((result = fibonacci(number)) < MAX_RANGE) {
			if (isEven(result)) {
				sumOfEvenValues = sumOfEvenValues + result;
			}
			number++;
		}
		System.out.println("Sum of even values terrms, whose value do not exceed "+MAX_RANGE+" is "+sumOfEvenValues);
	}

	static int fibonacci(int number) {
		if (number == 1 || number == 2)
			return 1;
		return fibonacci(number - 1) + fibonacci(number - 2);
	}

	static boolean isEven(int value) {
		return value % 2 == 0;
	}
}
