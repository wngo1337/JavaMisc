import java.util.Scanner;
public class Factorial {
	private int factorialNum;
	private int result;
	
	public Factorial(int num) {
		factorialNum = num;
	}
	
	public int computeFactorial(int num) {
		if (num == 1) {
			return 1;
		}
		
		else {
			return num * computeFactorial(num - 1);
		}
	}
	
	public static void main (String[] args) {
		Scanner userInput = new Scanner(System.in);
		int number, result;
		System.out.print("Enter an integer: ");
		number = Integer.parseInt(userInput.next());
		System.out.println("We are going to compute " +number + " factorial.");
		Factorial newFact = new Factorial(5);
		result = newFact.computeFactorial(number);
		System.out.println(result);
		
	}
}
