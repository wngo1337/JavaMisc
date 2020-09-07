
public class ArrayStack<T> implements ArrayStackADT<T> {
	private T[] stack;
	private int top; // stores the position of the last item on the stack (cuz using array I guess)
	private int initialCapacity;
	private int sizeIncrease; // when full, stack size will increase by this much
	private int sizeDecrease; // if #data items < 1/4 size of array, stack size decrease by this much

	public ArrayStack(int initialCap, int sizeInc, int sizeDec) {
		this.initialCapacity = initialCap;
		this.sizeIncrease = sizeInc;
		this.sizeDecrease = sizeDec;
		this.stack = (T[]) new Object[initialCapacity]; // workaround because can create arrays of T itself
														// creation of the stack itself
		this.top = -1;
	}

	public void push(T dataItem) {

		/*
		 * If stack is full, then we must increase its size before pushing. If the stack
		 * is full, every index should have an element, so we just check whether the
		 * last element is null.
		 */

		if (stack[stack.length - 1] != null) {
			T[] biggerStack = (T[]) new Object[stack.length + sizeIncrease];
			for (int i = 0; i < this.size(); i++) { // copy elements of old stack into new
				biggerStack[i] = stack[i];
			}
			this.stack = biggerStack; // set reference to the new stack
		}
		top += 1;
		stack[top] = dataItem;
	}

	public T pop() throws EmptyStackException {
		if (this.isEmpty()) { // if the stack is empty, can't pop so throw exception
			throw new EmptyStackException("The stack is empty bro!!!");
		}
		T dataItem = stack[top]; // this is the data item we will be returning
		top -= 1; // updating the top of the stack after popping
		if (this.size() < this.length() / 4 && this.length() > initialCapacity) { // we need to shrink the stack size
			T[] smallerStack = (T[]) new Object[stack.length - sizeDecrease];
			for (int i = 0; i < this.size(); i++) { // copy all data items into new stack
				smallerStack[i] = stack[i];
			}
			this.stack = smallerStack; // set reference to new stack
		}
		return dataItem;
	}

	public T peek() throws EmptyStackException {
		if (this.isEmpty()) {
			throw new EmptyStackException("The stack is still empty bro...");
		}
		return stack[top]; // return the data item on the top of the stack
	}

	public boolean isEmpty() { // stack is empty if top = 0 because nothing has been pushed yet
		if (top == -1) {
			return true;
		}
		return false;
	}

	public int size() { // returns number of data items in stack, NOT the size of the array
						// but top is incremented by 1 for each data item, so it counts the size of
						// stack - 1 (because first element is stored in index 0)
		return this.top + 1;
	}

	public int length() { // this is actually the capacity of the stack
		return stack.length;
	}

	public String toString() {
		String stringRep = "Stack: ";
		for (int i = 0; i < this.size(); i++) {
			if (i == this.size() - 1) { // don't need a comma after the last item
				stringRep = stringRep + this.stack[i];
			} else {
				stringRep = stringRep + this.stack[i] + ", ";
			}
		}
		return stringRep;
	}

}
