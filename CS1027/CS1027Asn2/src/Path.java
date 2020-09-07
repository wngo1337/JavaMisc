
public class Path {
	private Map cityMap;

	public Path(Map theMap) {
		this.cityMap = theMap;
	}

	public MapCell nextCell(MapCell cell) { // returns the next best mapcell to visit
		for (int i = 0; i < 4; i++) { // check all possible neighbours of the current cell
			MapCell maybeNeighbour = cell.getNeighbour(i);
			if (maybeNeighbour != null && !maybeNeighbour.isMarked()) { // haven't checked it yet
				if (maybeNeighbour.isDestination()) {
					return maybeNeighbour;
				}
				/*
				 * Intersections are all directions, so no need to check which directions are
				 * travelable
				 */
				else if (maybeNeighbour.isIntersection()) {
					return maybeNeighbour;
				}
				/*
				 * To enforce one-way roads, make sure that the index being searched matches up
				 * with the direction of the road type before allowing it to be traveled. e.g.
				 * north road is always located to the north, so must have index 0.
				 */
				else if (maybeNeighbour.isNorthRoad() && i == 0 || maybeNeighbour.isEastRoad() && i == 1
						|| maybeNeighbour.isSouthRoad() && i == 2 || maybeNeighbour.isWestRoad() && i == 3) {
					return maybeNeighbour;
				}
			}
		}
		return null; // return null if there isn't a cell that satisfies any of the conditions
	}

	public void findPath() throws EmptyStackException {
		ArrayStack<MapCell> myStack = new ArrayStack<MapCell>(50, 40, 30); // create a new stack
		MapCell startingCell = cityMap.getStart();
		MapCell currentCell, nextCell;
		boolean found = false;
		myStack.push(startingCell); // push the starting cell onto the stack and mark it
		startingCell.markInStack();

		/*
		 * This loop takes the starting cell and considers its best neighbour,
		 * continuing this process and essentially performing a depth-first search until
		 * either the program finds the destination (and thus a path to it), or it
		 * exhausts all reachable paths and doesn't find one.
		 */

		while (!myStack.isEmpty()) {
			currentCell = myStack.peek(); // get the next cell on the stack
			if (currentCell.isDestination()) { // if we are at the destination, exit the loop
				System.out.println("We found the destination.");
				System.out.println("Directions: " + myStack.toString());
				break;
			}
			nextCell = this.nextCell(currentCell); // get the best neighbour of the current cell
			if (nextCell != null) { // this means a neighbour exists, so add it to the stack
				myStack.push(nextCell);
				nextCell.markInStack();
			} else { // otherwise cell has no valid neighbours and we can't go anywhere, so pop it
				currentCell = myStack.pop();
				currentCell.markOutStack();
			}
		}
		if (!found) {
			System.out.println("Damn bruv, we didn't find a path :(");
			
		}
	}
}
