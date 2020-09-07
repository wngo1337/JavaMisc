
public class BoardGame {
	private int board_length;
	private int board_width;
	private Snake theSnake;	// currently not implemented, error should disappear after
	String[][] matrix;	// 2D matrix that stores the contents of each square on the board
	// each square can be one of the following: empty, apple, scissors, rock
	
	public BoardGame(String boardFile) {	// takes the board setup file name as a parameter
		// we will need to read from the file later, so need to use MyFileReader lol
		
		MyFileReader fileReader = new MyFileReader(boardFile);
		
		fileReader.readInt();	// skip the first two lines
		fileReader.readInt();
		
		this.board_length = fileReader.readInt();	// board dimensions for game to read, don't need here
		this.board_width = fileReader.readInt();
		
		int initialRow = fileReader.readInt();	// initial starting positions of the snake
		int initialColumn = fileReader.readInt();
		
		this.theSnake = new Snake(initialRow, initialColumn);	// creating the new snake object		
		this.matrix = new String[board_width][board_length];	// initializing the game board
		
		for (int i = 0; i < board_width; i++) {	// initially, the board is filled with "empty" squares
			for (int j = 0; j < board_length; j++) {
				this.matrix[i][j] = "empty";
			}
		}
		
		int tempLength, tempWidth;	// outside loop declaration for efficiency
		String tempItem;
		while (!fileReader.endOfFile()) {	// read the rest of the file in 3-line pieces
			tempWidth = fileReader.readInt();	// reading the item locations, and then the item itself
			tempLength = fileReader.readInt();
			tempItem = fileReader.readString();
			
			this.matrix[tempWidth][tempLength] = tempItem;			
		}
	}	
	public String getObject(int row, int col) {
		return this.matrix[row][col];
	}
	public void setObject(int row, int col, String newObject) {
		this.matrix[row][col] = newObject;
	}
	public Snake getSnake() {
		return this.theSnake;
	}
	public void setSnake(Snake newSnake) {
		this.theSnake = newSnake;
	}
	public int getLength() {
		return this.board_length;
	}
	public int getWidth() {
		return this.board_width;
	}
	public String getType(int row, int col) {
		return this.matrix[row][col];
	}
}
