package problem.solving.projecteuler;

public class SumSquareDifference {

	public static void main(String[] args) {
		short range = 100;
		long sumOfSquares = 0;
		int squareOfSums = 0;
		for(short i=0; i <= range ; i++){
			sumOfSquares = sumOfSquares + square(i);
			squareOfSums = squareOfSums + i;
		}
		
		System.out.println("Difference between the sum of the squares of firs "+range+" natural numbers is "+ (square(squareOfSums) - sumOfSquares));
	}
	
	static long square(int number){
		if(number <= 0)
			return 0;
		return (number * number);
	}
}
