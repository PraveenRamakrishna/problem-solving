package problem.solving.projecteuler;

class Utils {
	private Utils() {}

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
