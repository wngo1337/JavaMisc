
public class testRecursion {
	int myInt;
	
	public testRecursion (int x) {
		myInt = x;
	}
	
	public int getInt() {
		return myInt;
	}
	
	public void intPrinter(int someInt) {
		if (someInt == 0) {
			System.out.println("We have printed all the numbers.");
		}
		
		else {
			System.out.println(someInt);
			intPrinter(someInt - 1);
		}
	}
	
	public static void main(String args[]) {
		testRecursion recurse = new testRecursion(10);
		recurse.intPrinter(recurse.getInt());
	}
}
