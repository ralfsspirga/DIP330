import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.Arrays;

public class PerfectNumber2 {

	public static void detect(int n) {
		int sum = 0;
		
		ArrayList<Integer> divisors = new ArrayList<Integer>();
		
		// How exactly would setting the range to 1..sqrt(n) work? For example, n = 16,
		// sqrt(n) = 4. The divisor '8' would get missed.
		IntStream.rangeClosed(1, n/2).filter(i -> n % i == 0).forEach(i -> divisors.add(i));		
		
		sum += divisors.stream().mapToInt(Integer::intValue).sum();
		
		System.out.println("Number: " + n);
		System.out.println("Divisor list, excluding the number itself:");
		System.out.println(Arrays.toString(divisors.toArray()));
		System.out.println("The sum of the divisor list: " + sum);

		if (sum == n) {
			System.out.println("The number " + n + " is a perfect number!");
		} else if (sum < n) {
			System.out.println("The number " + n + " is a deficient number!");
		} else {
			System.out.println("The number " + n + " is an abundant number!");
		}
		
		System.out.println("-----------------------------------------------------");
	}

	public static void main(String[] args) {
		PerfectNumber2.detect(1);
		PerfectNumber2.detect(6);
		PerfectNumber2.detect(8);
		PerfectNumber2.detect(20);
		PerfectNumber2.detect(28);
	}
}
