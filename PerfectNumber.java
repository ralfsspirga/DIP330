import java.util.ArrayList;
import java.util.Arrays;

public class PerfectNumber {

	public static void detect(int n) {
		int sum = -n;

		ArrayList<Integer> divisors = new ArrayList<Integer>();

		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				divisors.add(i);
				sum+= i;
			}
		}

		System.out.println("Divisor list for the number " + n + ":");
		System.out.println(Arrays.toString(divisors.toArray()));
		System.out.println("The sum of divisors, excluding the number itself, is: " + sum);

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

		PerfectNumber.detect(1);
		PerfectNumber.detect(6);
		PerfectNumber.detect(8);
		PerfectNumber.detect(20);
		PerfectNumber.detect(28);
	}
}
