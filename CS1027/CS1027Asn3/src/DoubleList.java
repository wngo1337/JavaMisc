
public class DoubleList<T> {
	private DoubleNode<T> head;
	private DoubleNode<T> rear;
	private int numDataItems;
	
	public DoubleList() { // pretty sure head and rear are null by default, but just in case I guess...
		this.head = null;
		this.rear = null;
		this.numDataItems = 0;
	}
	
	/*
	 * addData creates a new node and adds it to the list in the specified index, throwing an exception
	 * if it encounters an invalid index.
	 */
	
	public void addData(int index, T newData) throws InvalidPositionException {
		if (index < 0 || index > numDataItems) {
			throw new InvalidPositionException("Bruh you chose a stupid index" + index + "when there are only"
					+ numDataItems + "data items");
		}
		if (index == 0) {	// 2 cases: list can be empty, or not empty
			if (numDataItems == 0) {	// list is empty, so just set the new head
				head = rear = new DoubleNode<T>(newData);
			}
			else {	// list is not empty, so create a new head and append the original list behind it
				DoubleNode oldHead = head;
				DoubleNode newHead = new DoubleNode(newData);
				newHead.setNext(oldHead);
				oldHead.setPrev(newHead);
				this.head = newHead;
			}
			numDataItems += 1;
		}
		else {	// add to arbitrary position in non-empty list
			DoubleNode<T> currentNode;	// used for traversing the doubly linked list
			DoubleNode<T> newNode = new DoubleNode(newData);	// the node being added
			currentNode = head;
			if (index == numDataItems) {	// add to the end of the list
				rear.setNext(newNode);
				newNode.setPrev(rear);
				rear = newNode;
			}
			else {	// loop through list until get to internal node #index, and add the new node behind it
//				for (int i = 0; i < index; i++) {
//					currentNode = currentNode.getNext();
//				}
				currentNode = this.getNode(index);
				// at this point, we are pointing to the node we want to add behind
				currentNode.getNext().setPrev(newNode);	// ORDER MIGHT BE IMPORTANT HERE BUT WHATEVER FOR NOW
				newNode.setNext(currentNode.getNext());
				currentNode.setNext(newNode);
				newNode.setPrev(currentNode);
			}
			numDataItems += 1;
		}
	}

	public DoubleNode<T> getNode(int index) throws InvalidPositionException {
		if (index < 0 || index >= numDataItems) {
			throw new InvalidPositionException("Bruh, don't pick a stupid index" + index + "when getting a node " +
					"because there are only " +numDataItems + " items");
		}
		DoubleNode<T> currentNode = head;
		for (int i = 0; i < index; i++) {	// may or may not cause an issue by being off by 1, we'll see
			currentNode = currentNode.getNext();
		}
		return currentNode;
	}
	public void removeData(int index) throws InvalidPositionException {
		if (index < 0 || index >= numDataItems) {
			throw new InvalidPositionException("Bruh, don't pick stupid index " + index + " when removing because" +
					"only " + numDataItems + "items exist");
		}

		//TODO: EXCEPTION HERE BECAUSE THIS ONLY WORKS WHEN WE HAVE MORE THAN 1 NODE
		// OTHERWISE WE ARE TRYING TO CALL SETPREV ON NULL

		if (index == 0) {
			if (numDataItems == 1) {	// special case: just make head = rear = null
				head = rear = null;
			}
			else {
				head = head.getNext();
				head.setPrev(null);
			}
		} else if (index == numDataItems - 1) {
			rear = rear.getPrev();
			rear.setNext(null);
		}
		else {
			DoubleNode<T> goneNode = this.getNode(index);
			DoubleNode<T> previousNode = goneNode.getPrev();	// for ease of access lol
			DoubleNode<T> nextNode = goneNode.getNext();
			previousNode.setNext(nextNode);	// make previous node jump over the current one
			nextNode.setPrev(previousNode);	// make next node jump backward over the current one
		}
		numDataItems -= 1;
	}
	public T getData(int index) throws InvalidPositionException {
		if (index < 0 || index >= numDataItems) {
			throw new InvalidPositionException("You tried to get data from index " + index + "when there are only"
			+numDataItems + " data items");
		}
		DoubleNode<T> dataNode = this.getNode(index);
		return dataNode.getData();
	}
	public void setData(int index, T newData) throws InvalidPositionException {
		if (index < 0 || index >= numDataItems) {
			throw new InvalidPositionException("You tried to set something at index" + index + " when only "
					+ numDataItems + " data items exist");
		}
		DoubleNode<T> changingNode = this.getNode(index);
		changingNode.setData(newData);
	}
}
