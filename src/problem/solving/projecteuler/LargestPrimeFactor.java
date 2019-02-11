package problem.solving.projecteuler;

/**
 * https://stackoverflow.com/questions/1801391/what-is-the-best-algorithm-for-checking-if-a-number-is-prime
 * https://en.wikipedia.org/wiki/Primality_test
 *
 */
public class LargestPrimeFactor {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		primeFactor(600851475143l, 2);
		System.out.println("Time taken in Nano seconds: " + (System.nanoTime() - startTime));
	}

	static void primeFactor(long number, int primeNumber) {
		if (number > 1) {
			if (number % primeNumber == 0) {
				primeFactor(number / primeNumber, nextPrime(primeNumber));
				System.out.println(primeNumber);
			} else {
				primeFactor(number, nextPrime(primeNumber));
			}
		}

	}

	static int nextPrime(int number) {
		while (true) {
			boolean isPrime = true;
			number++;
			int squareNumber = (int) Math.sqrt(number);
			for (int i = 2; i <= squareNumber; i++) {
				if (number % i == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime)
				return number;
		}
	}
}
