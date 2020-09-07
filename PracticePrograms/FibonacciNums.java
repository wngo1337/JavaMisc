
public class FibonacciNums {

	/*
	 * THIS IS JUST OLD CODE USED FOR 3350 LOL
	 * 
	 * int i = 0; public FibonacciNums() { System.out.println("derpa"); }
	 * 
	 * public int recursiveFib(int n) { if (n < 2) { return n; }
	 * System.out.println(n + " is n we are calling fib on"); int n1 =
	 * recursiveFib(n-1); System.out.println(n1 + " is n1"); int n2 =
	 * recursiveFib(n-2); System.out.println(n2 + " is n2"); System.out.println((n1
	 * + n2) + " is the sum of n1 and n2"); return n1 + n2;
	 * 
	 */
	public int recursiveFib(int n) {
		if (n == 0) {
			return 0;
		}
		else if (n == 1) {
			return 1;
		}
		
		return recursiveFib(n - 1) + recursiveFib(n - 2);
	}

	public static void main(String[] args) {
		FibonacciNums aNum = new FibonacciNums();
		int result;
		for (int i = 0; i < 11; i++) {
			result = aNum.recursiveFib(i * 5);
			System.out.println("The " + Integer.toString(i * 5) + "th Fibonacci number is: " + Integer.toString(result));
		}
	}
}
