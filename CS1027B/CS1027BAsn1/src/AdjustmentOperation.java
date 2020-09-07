import java.awt.Color;

public class AdjustmentOperation implements ImageOperation {
	
	public Color[][] doOperation(Color[][] imageArray) {
		
		int numOfRows = imageArray.length;
		int numOfColumns = imageArray[0].length;
		double distance; // distance of the current pixel from left corner of screen
		final double maxDistance = Math.sqrt(Math.pow(numOfRows, 2) + Math.pow(numOfColumns, 2));
		double adjustBrightness; // ratio which we adjust based on
		Color[][] result = new Color[numOfRows][numOfColumns];
		Color currentPixel;
		
		for (int i = 0; i < numOfRows; i++) {
			for (int j = 0; i < numOfColumns; i++) {
				currentPixel = imageArray[i][j];
				distance = Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2));
				adjustBrightness = distance / maxDistance;
				result[i][j] = new Color((int)(currentPixel.getRed() * adjustBrightness), (int)(currentPixel.getGreen() * 
						adjustBrightness), (int)(currentPixel.getBlue() * adjustBrightness));
			}
		}
		return result;
	}
}
