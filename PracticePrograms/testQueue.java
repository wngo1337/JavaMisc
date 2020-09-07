import java.util.Stack;

public class testQueue {

	public static void main(String[] args) {
		Stack<String> stringStack = new Stack<String>();
		
		System.out.println(stringStack.isEmpty());
		
		stringStack.push("fk");
		stringStack.push("Manny");
		stringStack.push("that");
		stringStack.push("stupid");
		stringStack.push("whiner");
		
		while (!stringStack.isEmpty()) {
			System.out.println(stringStack.pop());
		}
		System.out.println(stringStack.isEmpty());
	}

}
