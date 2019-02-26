package problem.solving.projecteuler;


import static problem.solving.projecteuler.Utils.nextPrime;

public class FindNthPrime {
	
	public static void main(String[] args) {
		int nthPrime = 10001;
		int nextPrime=2;
		int primeIndex = 1;
		while (primeIndex < nthPrime){
			nextPrime = nextPrime(nextPrime);
			primeIndex++;
		}
		System.out.println(nthPrime+"st prime number is "+nextPrime);
	}

}
