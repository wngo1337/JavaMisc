public class BoardGameLinked {
    private int boardLength;
    private int boardWidth;
    private SnakeLinked theSnake;
    private DoubleList<String>[] board; // array of doubly linked lists

    public BoardGameLinked(String boardFile) {    // takes the board setup file name as a parameter
        // we will need to read from the file later, so need to use MyFileReader lol

        MyFileReader fileReader = new MyFileReader(boardFile);

        fileReader.readInt();    // skip the first two lines
        fileReader.readInt();

        this.boardLength = fileReader.readInt();    // board dimensions for game to read, don't need here
        this.boardWidth = fileReader.readInt();

        int initialRow = fileReader.readInt();    // initial starting positions of the snake
        int initialColumn = fileReader.readInt();

        this.theSnake = new SnakeLinked(initialRow, initialColumn);    // creating the new snake object
        // TODO: FIND THE DAMN ERROR THAT DOESN'T CAST PROPERLY
        this.board = (DoubleList<String>[])new DoubleList[boardWidth];    // initializing the game board

        for (int i = 0; i < board.length; i++) {
            board[i] = new DoubleList<String>();    // initialize all the DoubleLists
        }

        for (int i = 0; i < boardWidth; i++) {    // initially, the board is filled with "empty" squares
            for (int j = 0; j < boardLength; j++) {
                this.board[i].addData(j, "empty");  // ALL ENTRIES ARE INITIALized here now...
            }
        }

        // lmao forgot to read the actual objects into the board
        int tempRow, tempColumn;
        String tempObject;
        while (!fileReader.endOfFile()) {   // q read the object locations and store them in the board
            tempRow = fileReader.readInt();
            tempColumn = fileReader.readInt();
            tempObject = fileReader.readString();

            this.setObject(tempRow, tempColumn, tempObject);
        }
    }
    public String getObject(int row, int col) throws InvalidPositionException {
        if (row < 0 || col < 0 || row >= boardWidth || col >= boardLength) {
            throw new InvalidPositionException("Yea, you tried accessing something that isn't there idiot");
        }
        String myObject = board[row].getData(col);  // get the linked list which represents row, then the object
                                                    // at the index that represents the column
        return myObject;
    }
    public void setObject(int row, int col, String newObject) throws InvalidPositionException {
        if (row < 0 || col < 0 || row >= boardWidth || col >= boardLength) {
            throw new InvalidPositionException("Yea, you tried accessing something that isn't there idiot \n" +
                    "row, col, boardwidth, and boardlength are: " + row + " " + col + " " + boardWidth + " "
                    + boardLength);
        }
        board[row].setData(col, newObject);
    }
    public SnakeLinked getSnakeLinked() {
        return theSnake;
    }

    public void setSnakeLinked(SnakeLinked newSnake) {
        this.theSnake = newSnake;
    }
    public int getLength() {
        return boardLength;
    }
    public int getWidth() {
        return boardWidth;
    }
}
