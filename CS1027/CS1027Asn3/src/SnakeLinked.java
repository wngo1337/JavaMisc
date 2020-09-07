public class SnakeLinked {
    private int snakeLength;
    private DoubleList<Position> snakeBody; // holds the position objects that the snake occupies on the board

    public SnakeLinked(int row, int col) {
        this.snakeLength = 1;
        this.snakeBody = new DoubleList<Position>();
        Position startingPosition = new Position(row, col);
        this.snakeBody.addData(0, startingPosition);
    }

    public int getLength() {
        return this.snakeLength;
    }

    public Position getPosition(int index) {
        if (index < 0 || index >= snakeLength) {
            return null;
        }
        return snakeBody.getData(index);  // get the Position object stored in the correct node of the body
    }

    public boolean snakePosition(Position position) {
        for (int i = 0; i < snakeLength; i++) {
            if (snakeBody.getData(i).equals(position)) {    // the Position specified is in the snake body
                return true;
            }
        }
        return false;
    }

    public Position newHeadPosition(String direction) {
        // wanted to use switch but it just compiles to if statement anyway, so...
        // need to get the current head position
        Position newHead = new Position(snakeBody.getData(0).getRow(), snakeBody.getData(0).getCol());
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

    public void moveSnakeLinked(String direction) {
        /*
        This method takes a direction as a parameter, and it moves the snake in that direction by deleting the
        rear node, and then adding the new head at the front.
         */

        /*
        Thought about this the wrong way. Originally wanted to just remove the tail and add the new head in front,
        but that is a problem when the snake is length 1 because removing would make it length 0...
        Thus, we just play with references instead to avoid the index error lol
         */


        DoubleNode<Position> newHead = new DoubleNode<Position>(this.newHeadPosition(direction));
        DoubleNode<Position> oldHead = snakeBody.getNode(0);

        if (snakeLength == 1) { // new snake: just replace the old head position with the new one
            oldHead.setData(this.newHeadPosition(direction));
        }
        else {
            snakeBody.addData(0, this.newHeadPosition(direction));

        }   // PPARENTLY THIS DOESN'T WORK SOMEHOW?

    }

    public void shrink() {
        snakeBody.removeData(snakeLength - 1);  // delete the tail to shrink the snake
        snakeLength -= 1;   // make sure to update the snake length
    }

    void grow(String direction) {
        snakeBody.addData(0, this.newHeadPosition(direction));  // the snake grows by adding a new head
        snakeLength += 1;
    }
}
