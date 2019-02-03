package problem.solving.projecteuler;

public class MultiplesOf3And5 {
	
	public static void main(String[] args) {
		final int MAX_RANGE = 1000;
		int sumOfMultiples = 0;
		int multiples = 0;
		int number = 1; 
		while((multiples = multiplesOf3Or5(number)) < MAX_RANGE){
				sumOfMultiples = sumOfMultiples + multiples;
				number++;
		}
		System.out.println("Sum of all the multiples of 3 or 5 below "+MAX_RANGE+" is "+sumOfMultiples);
	}

	static int multiplesOf3Or5(int number) {
		if(number % 3 == 0)
			return number;
		if(number % 5 == 0)
			return number;
		return 0;
	}	
}
