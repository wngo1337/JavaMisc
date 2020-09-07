
public class Snake {
	private int snakeLength;
	private Position[] snakeBody;

	public Snake(int row, int col) {
		this.snakeLength = 1;
		this.snakeBody = new Position[5];

		/*
		 * Create a new position object using the specified row and col values, and add
		 * to snakeBody that holds all positions that the snake occupies.
		 */

		Position startPosition = new Position(row, col);
		this.snakeBody[0] = startPosition; // add the starting position to the snake body
	}

	public int getLength() {
		return this.snakeLength;
	}

	public Position getPosition(int index) {
		if (index < 0 || index > this.snakeLength) {
			return null;
		}
		return this.snakeBody[index];
	}

	public void shrink() {
		this.snakeLength -= 1; // snakeLength = snakeLength - 1
	}

	public boolean snakePosition(Position pos) {
		for (int i = 0; i < this.snakeLength; i++) {	
			if (this.snakeBody[i].equals(pos)) {
				return true; // then the specified position is in the snake body
			}
		}
		return false;
	}

	public Position newHeadPosition(String direction) {
		// wanted to use switch but it just compiles to if statement anyway, so...
		Position newHead = new Position(this.snakeBody[0].getRow(), this.snakeBody[0].getCol());
		if (direction.equalsIgnoreCase("right")) { // row doesn't change, column changes by +1
			newHead.setCol(newHead.getCol() + 1);
		} else if (direction.equalsIgnoreCase("left")) { // row doesn't change, changes by -1
			newHead.setCol(newHead.getCol() - 1);
		} else if (direction.equalsIgnoreCase("up")) { // column doesn't change, row changes by -1
			newHead.setRow(newHead.getRow() - 1);
		} else if (direction.equalsIgnoreCase("down")) { // column doesn't change, row changes by +1
			newHead.setRow(newHead.getRow() + 1);
		}
		return newHead;
	}

	public void moveSnake(String direction) {
		for (int i = snakeLength - 2; i > -1; i--) { // shift everything except the last (empty) index
			snakeBody[i + 1] = snakeBody[i];
		}
		snakeBody[0] = this.newHeadPosition(direction); // computing the new head position of the snake
	}
	
	public void grow(String direction) {
		if (snakeLength == snakeBody.length) {	// if body is not big enough to expand, increase size
			increaseArraySize();
		}		
		this.snakeLength += 1;	// increment snake length 
		for (int i = snakeLength - 2; i > -1; i--) {
			snakeBody[i + 1] = snakeBody[i];
		}
		snakeBody[0] = newHeadPosition(direction);
	}
	
	private void increaseArraySize() {
		int doubleSize = snakeBody.length * 2;	// this is double the size of the original body
		Position[] newBody = new Position[doubleSize];	// creating the double size body
		for (int i = 0; i < snakeBody.length; i++) {	// copy each Position in the original body to new
			newBody[i] = snakeBody[i];
		}
		this.snakeBody = newBody;	// set the snakeBody var to point to the new array 
	}

}
