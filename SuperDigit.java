public class SuperDigit {

	public static long superDigit(long n){
		if (n == 0) return 0; 
		long sum = (n % 10 + superDigit(n / 10));
		if(sum < 10 && sum > -10) return sum;
		return superDigit(sum);
	}
	
	public static void main(String[] args) {
		System.out.print("Super digit of 9875: ");
		System.out.println(superDigit(9875));
		System.out.print("Super digit of 1680116: ");
		System.out.println(superDigit(1680116));
		System.out.print("Super digit of 99999999: ");
		System.out.println(superDigit(99999999));
	}
}
