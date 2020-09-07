
public class Position {
	private int positionRow;
	private int positionColumn;

	public Position(int row, int col) { // constructor, sets the given row and column positions of the pair
		this.positionRow = row;
		this.positionColumn = col;
	}

	public int getRow() {
		return this.positionRow;
	}

	public int getCol() {
		return this.positionColumn;
	}

	public void setRow(int newRow) {
		this.positionRow = newRow;
	}

	public void setCol(int newCol) {
		this.positionColumn = newCol;
	}

	public boolean equals(Position otherPosition) {
		/*
		 * This method checks for equality b/t the Position object and another Position
		 * object by comparing the row and column values. If they are both equal, then
		 * the position is equal.
		 */

		if (this.positionRow == otherPosition.getRow() && this.positionColumn == otherPosition.getCol()) {
			return true;
		}
		return false;
	}
}
