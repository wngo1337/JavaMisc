import java.awt.Color;

public class MagnifyOperation implements ImageOperation {
	
	public Color[][] doOperation(Color[][] imageArray) {
		int numOfRows = imageArray.length;
		int numOfColumns = imageArray[0].length;
		Color[][] result = new Color[numOfRows * 2][numOfColumns * 2];
		Color currentPixel;
		
		for (int i = 0; i < numOfRows; i++) {
			for (int j = 0; j < numOfColumns; j++) {
				// board is now 4x the original size, so just assign each pixel to the three pixels 
				// to the right, below, and diagonally right of it NVM THAT DOESN'T WORK
				
				currentPixel = imageArray[i][j];
				
				result[i][j] = currentPixel;
				result[i][j + 1] = currentPixel;
				result[i + 1][j] = currentPixel;
				result[i + 1][j + 1] = currentPixel;
			}
		}
		return result;
	}
	
}
