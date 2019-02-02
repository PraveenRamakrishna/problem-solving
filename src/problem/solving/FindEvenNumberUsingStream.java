package problem.solving;

import java.util.stream.IntStream;

public class FindEvenNumberUsingStream {

	public static void main(String[] args) {
		IntStream.range(1, 100).filter(number ->((number % 2 )==0)).forEach(System.out::println);
	}

}
