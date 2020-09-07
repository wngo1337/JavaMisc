import java.awt.Color;

public class ContourOperation implements ImageOperation {

	public Color[][] doOperation(Color[][] imageArray) {
		int numOfRows = imageArray.length;
		int numOfColumns = imageArray[0].length;

		Color[][] result = new Color[numOfRows][numOfColumns];

		for (int i = 0; i < numOfRows; i++) {
			for (int j = 0; j < numOfColumns; i++) {

				Color[] neighbours = new Color[8];

				try {
					neighbours[0] = imageArray[i - 1][j - 1];
					neighbours[1] = imageArray[i - 1][j];
					neighbours[2] = imageArray[i - 1][j + 1];
					neighbours[3] = imageArray[i][j - 1];
					neighbours[4] = imageArray[i][j + 1];
					neighbours[5] = imageArray[i + 1][j - 1];
					neighbours[6] = imageArray[i + 1][j];
					neighbours[7] = imageArray[i + 1][j + 1];
				}

				catch (ArrayIndexOutOfBoundsException e) {
					System.out.printf("Oh shit, we went out of bounds at pixel [%s, %s]", i, j);
				}
				// MAYBE TRY CATCH ALL POSSIBLE POSITIONS AND THEN DUMP IN ARRAY AND THEN GO

				for (Color neighbour : neighbours) {
					int redDiff = imageArray[i][j].getRed() - neighbour.getRed();
					int greenDiff = imageArray[i][j].getGreen() - neighbour.getGreen();
					int blueDiff = imageArray[i][j].getBlue() - neighbour.getBlue();

					double totalDiff = Math.sqrt(Math.pow(redDiff, 2) + Math.pow(greenDiff, 2) + Math.pow(blueDiff, 2));

					if (totalDiff > 65) {
						result[i][j] = new Color(0, 0, 0); // black
					} else {
						result[i][j] = new Color(255, 255, 255); // white
					}
				}
			}
		}
		return result;
	}

}
