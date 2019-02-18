package problem.solving.projecteuler;

public class LargestPalindromeProduct {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		System.out.println(largestPalindrome(999));
		System.out.println(System.nanoTime() - startTime);
	}

	private static long largestPalindrome(int number) {
		int i = number;		
		int product = 0;
		long largetPalindrome=0;
		while(i>99){
			int  j = number;
			while(j>99){
				product = i*j;
				if(product==reverse(product)){
					largetPalindrome = largetPalindrome < product ? product : largetPalindrome;
					break;
				}
				j--;
			}
			i--;
		}
		return largetPalindrome;
	}

	static int reverse(int number) {
		int reverse = 0;
		while (number > 0) {
			reverse = reverse * 10;
			reverse = reverse + number % 10;
			number = number / 10;
		}
		return reverse;
	}
}
