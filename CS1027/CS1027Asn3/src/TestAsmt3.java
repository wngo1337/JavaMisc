
public class TestAsmt3 {

	public static void main(String[] args) {
		boolean testPassed = true;
		BoardGameLinked board = null;
		SnakeLinked theSnake = null;
		String[][] matrix = {{"empty", "empty", "apple", "empty"},
								{"empty", "rock", "empty", "apple"},
								{"scissors", "empty", "empty", "empty"}};

		// Test 1. Test methods from class DoubleNode
		try {
		    DoubleNode<String> node = new DoubleNode("1");
		    DoubleNode<String> node2 = new DoubleNode();
		    if (!node.getData().equals("1")) testPassed = false;
		    if (node2.getData() != null) testPassed = false;
		    node2.setData("2");
		    if (!node2.getData().equals("2")) testPassed = false;
		    node.setNext(node2);
		    node2.setPrev(node);
		    if (node.getNext() != node2) testPassed = false;
		    if (node2.getPrev() != node) testPassed = false;
			if (testPassed)
				System.out.println("Test 1 passed");
			else
				System.out.println("Test 1 failed");
		} catch (Exception e) {
			System.out.println("Test 1 failed");
		}

		// Test 2. Test methods from class DoubleList: constructor, addData, getNode, getData
		testPassed = true;
		DoubleList<String> list = new DoubleList();
		try {
		    list.addData(1,"1");
		    testPassed = false;
			System.out.println("tes 2 failed if we got here because didn't catch exception");
		}
		catch (InvalidPositionException e) {
			System.out.println("Test 2 actually caught the exception so this part is ok");
		}
		catch (Exception e) {
			testPassed = false;
			System.out.println("test 2 failed cuz something crashed idiot");
		}
		try {
		    list.addData(0,"1");
		    list.addData(1,"2");
		    list.addData(2,"3");
		    String s = list.getData(2);
		    if (!s.equals("3")) {
		    	testPassed = false;
				System.out.println("test 2 failed cuz you either didn't add or get shit properly");
			}
		    DoubleNode<String> node = list.getNode(1);
		    if (!node.getData().equals("2")) {
		    	testPassed = false;
				System.out.println("test 2 failed again cuz you didn't get shit right");
		    }
			System.out.println("at least this shit works for tes 2");
		    if (testPassed) {
				System.out.println("Test 2 passed");
			}
		    else {
				System.out.println("Test 2 failed");
			}
		} catch (Exception e) {
			System.out.println("Test 2 failed cuz some other exception u dumbass");
		}

		// Test 3. Test methods from class DoubleList: removeData, getNode, getData
		testPassed = true;
		list = new DoubleList();
		try {
		    list.removeData(0);
		    testPassed = false;
		}
		catch (InvalidPositionException e) {}
		catch (Exception e) {testPassed = false;}
		try {
		    list.addData(0,"1");
		    list.addData(1,"2");
		    list.addData(2,"3");
		    list.removeData(0);
		    String s = list.getData(0);
		    if (!s.equals("2")) testPassed = false;
		    DoubleNode<String> node = list.getNode(1);
		    if (!node.getData().equals("3")) testPassed = false;
		    list.removeData(1);
		    s = list.getData(0);
		    if (!s.equals("2")) testPassed = false;
		    if (testPassed)
			   System.out.println("Test 3 passed");
		    else
			   System.out.println("Test 3 failed");
		} catch (Exception e) {
			System.out.println("Test 3 failed");
		}


		// Test 4. Constructor for class BoardGameLinked.
		// Also test methods setObject, get Length, and getWidth of class GameBoard
		try {
			testPassed = true;
			board = new BoardGameLinked("testboard.txt");
			// Check that the contents of the file testboard.txt was read correctly
			for (int i = 0; i < 3; ++i)
				for (int j = 0; j < 4; ++j)
					if (!board.getObject(i,j).equals(matrix[i][j])) {
						testPassed = false;
						System.out.println("test 4 failed cuz didn't return the right shizz");
						System.out.println("board has " + board.getObject(i, j) + "while matrix has " + matrix[i][j]);
					}
			board.setObject(2,3,"scissors");
			String s = board.getObject(2,3);
			if (!s.equals("scissors")) {
				testPassed = false;
				System.out.println("test 4 failed cuz didn't get scissors or some shit");
			}
			if (board.getLength() != 4 || board.getWidth() != 3) {
				testPassed = false;
				System.out.println("test 4 failed cuz YOU DIDN'T GET THE DIMENSIONS RIGHT WTF IDIOT??");
			}

			if (testPassed)
				System.out.println("Test 4 passed");
			else
				System.out.println("Test 4 failed");
		} catch (Exception e) {
			System.out.println("Test 4 failed CUZ SOME EXCEPTION DUMB FUCK");
		}

		// Test 5. Test methods from class DoubleList: addData, removeData, getNode, getData
		testPassed = true;
		list = new DoubleList();
		try {
		    for (int i = 9; i >= 0; --i)
			list.addData(0,""+i);

		    String s = list.getData(0);
		    if (!s.equals("0")) testPassed = false;
		    list.removeData(0);
		    list.removeData(2);
		    list.removeData(7);
		    if (!list.getData(0).equals("1")) testPassed = false;
		    if (!list.getData(2).equals("4")) testPassed = false;
		    if (!list.getData(6).equals("8")) testPassed = false;
		    if (testPassed)
			   System.out.println("Test 5 passed");
		    else
			   System.out.println("Test 5 failed");
		} catch (Exception e) {
			System.out.println("Test 5 failed");
		}

		// Test 6. Test method getSnakeLinked of class GameBoard and methods getLength and snakePosition of class SnakeLinked
		try {
			testPassed = true;
			Position pos;
			theSnake = board.getSnakeLinked();
			if (theSnake.getLength() != 1) {
				testPassed = false;
				System.out.println("test 6 fail cuz snake length wrong bitch");
			}
			pos = theSnake.getPosition(0);
			if (pos.getRow() != 2 || pos.getCol() != 2) {
				testPassed = false;
				System.out.println("test 6 fail cuz positions wrong idiot");
			}
			if (testPassed)
				System.out.println("Test 6 passed");
			else
				System.out.println("Test 6 failed");
		} catch (Exception e) {
			System.out.println("Test 6 failed cuz some exception dumb bitch");
		}

		// Test 7. Test method SnakeLinked, getPosition, shrink
		try {
			testPassed = true;
			theSnake = new SnakeLinked(4,7);
			if (!theSnake.getPosition(0).equals(new Position(4,7))) {
				System.out.println("test 7 failed because you didn't get the right position");
				testPassed = false;
			}
			if (theSnake.getPosition(-1) != null || theSnake.getPosition(1) != null) {
				System.out.println("test 7 failed because you tried to return an null position");
				testPassed = false;
			}
			theSnake.shrink();
			if (theSnake.getLength() != 0) {
				System.out.println("test 7 failed because the shrink function didn't work");
				testPassed = false;
			}
			if (testPassed)
				System.out.println("Test 7 passed");
			else
				System.out.println("Test 7 failed");
		} catch (Exception e) {
			System.out.println("Test 7 failed because some exception you dumb bitch");

		}

		// Test 8. Test newHeadPosition, snakePosition
		try {
			testPassed = true;
			theSnake = new SnakeLinked(1,1);
			Position up = new Position(0,1);
			Position down = new Position(2,1);
			Position right = new Position(1,2);
			Position left = new Position(1,0);
			if (!theSnake.newHeadPosition("up").equals(up)) testPassed = false;
			if (!theSnake.newHeadPosition("down").equals(down)) testPassed = false;
			if (!theSnake.newHeadPosition("left").equals(left)) testPassed = false;
			if (!theSnake.newHeadPosition("right").equals(right)) testPassed = false;
			if (!theSnake.snakePosition(new Position(1,1))) testPassed = false;
			if (theSnake.snakePosition(new Position(0,1))) testPassed = false;
			if (testPassed)
				System.out.println("Test 8 passed");
			else
				System.out.println("Test 8 failed");
		} catch (Exception e) {
			System.out.println("Test 8 failed");
		}

		// Test 9. Test method moveSnakeLinked
		try {

			testPassed = true;
			theSnake = new SnakeLinked(2,2);
			theSnake.moveSnakeLinked("right");
			if (!theSnake.snakePosition(new Position(2,3))) {
				System.out.println("test 9 failed because the new snake position wasn't in the body for test 1");
				testPassed = false;
			}
			if (theSnake.snakePosition(new Position(2,2))) testPassed = false;
			theSnake.moveSnakeLinked("up");
			if (!theSnake.snakePosition(new Position(1,3))) testPassed = false;
			if (theSnake.getLength() != 1) testPassed = false;
			theSnake.moveSnakeLinked("left");
			if (!theSnake.getPosition(0).equals(new Position(1,2))) testPassed = false;
			theSnake.moveSnakeLinked("down");
			if (!theSnake.getPosition(0).equals(new Position(2,2))) testPassed = false;
			if (testPassed)
				System.out.println("Test 9 passed");
			else
				System.out.println("Test 9 failed");
		} catch (Exception e) {
			System.out.println("Test 9 failed because of " + e.toString());
		}

		// Test 10. Test method grow
		try {
			testPassed = true;
			theSnake = new SnakeLinked(1,1);
			theSnake.grow("right");
			theSnake.grow("down");
			theSnake.grow("down");
			theSnake.grow("left");
			if (theSnake.getLength() != 5) testPassed = false;
			if (!theSnake.snakePosition(new Position(1,2))) testPassed = false;
			if (!theSnake.snakePosition(new Position(2,2))) testPassed = false;
			if (!theSnake.snakePosition(new Position(3,2))) testPassed = false;
			if (!theSnake.snakePosition(new Position(3,1))) testPassed = false;
			if (testPassed)
				System.out.println("Test 10 passed");
			else
				System.out.println("Test 10 failed");
		} catch (Exception e) {
			System.out.println("Test 10 failed");
		}

		// Test 11. Test method grow
		try {
			testPassed = true;
			theSnake = new SnakeLinked(1,0);
			for (int i = 0; i < 10; ++i) theSnake.grow("right");
			theSnake.grow("up");
			if (theSnake.getLength() != 12) testPassed = false;
			theSnake.grow("left");
			if (!theSnake.getPosition(0).equals(new Position(0,9))) testPassed = false;
			if (testPassed)
				System.out.println("Test 11 passed");
			else
				System.out.println("Test 11 failed");
		} catch (Exception e) {
			System.out.println("Test 11 failed");
		}

		// Test 12. Test moveSnakeLinked
		try {
			testPassed = true;
			theSnake = new SnakeLinked(1,1);
			theSnake.grow("right");
			theSnake.grow("down");
			theSnake.grow("down");
			theSnake.grow("left");
			theSnake.grow("up");
			theSnake.grow("left");
			theSnake.moveSnakeLinked("down");
			theSnake.moveSnakeLinked("down");
			// SOMEHOW ERROR HERE BECAUSE THERE IS NOTHING AT INDEX 6??? SHOULD BE 7 NODES IN THE SNAKE BUT ONLY 6
			// SHOULD BE 8 THINGS IN THE LIST, BUT REFERENCE TO HEAD IS NOT UPDATED WHEN ADDING
			// INSTEAD UP UPDATING REFERENCES, TRY USING ADDDATA METHOD LMAOS
			theSnake.moveSnakeLinked("right");
			if (!theSnake.getPosition(0).equals(new Position(4,1))) testPassed = false;
			if (!theSnake.getPosition(1).equals(new Position(4,0))) testPassed = false;
			if (!theSnake.getPosition(2).equals(new Position(3,0))) testPassed = false;
			if (!theSnake.getPosition(3).equals(new Position(2,0))) testPassed = false;
			if (!theSnake.getPosition(4).equals(new Position(2,1))) testPassed = false;
			if (!theSnake.getPosition(5).equals(new Position(3,1))) testPassed = false;
			if (!theSnake.getPosition(6).equals(new Position(3,2))) testPassed = false;
			if (testPassed)
				System.out.println("Test 12 passed");
			else
				System.out.println("Test 12 failed");

		} catch (Exception e) {
			System.out.println("Test 12 failed cuz exception u dumb bitch");
		}
	}

}
