package problem.solving.projecteuler;

public class SmallestMultiple {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		long smallestNumber = 2521;
		boolean smallestNumberNotFound = false;
		while (!smallestNumberNotFound) {
			for (int i = 1; i <= 20; i++) {
				smallestNumberNotFound = (smallestNumber % i == 0);
				if (!smallestNumberNotFound) {
					smallestNumber++;
					break;
				}
			}
		}
		System.out.println(smallestNumber + " is the smallest number divisible by 1 to 20");
		System.out.println((System.currentTimeMillis() - startTime) + " Milliseconds");
	}
}
