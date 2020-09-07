import java.awt.Color;

public class ThresholdingOperation implements ImageOperation {
	
	public Color[][] doOperation (Color[][] imageArray) {
		double brightnessScore = 0;
		int numOfRows = imageArray.length;
		int numOfColumns = imageArray[0].length;
		
		Color[][] result = new Color[numOfRows][numOfColumns];
		
		for (int i = 0; i < numOfRows; i++) {
			for (int j = 0; j < numOfColumns; j++) {
				brightnessScore = getBrightnessScore(imageArray[i][j]);
				if (brightnessScore > 100) {
					result[i][j] = new Color(255, 255, 255);
				}
				else {
					result[i][j] = new Color(0, 0, 0);
				}
			}
		}
		return result;
	}
	
	public double getBrightnessScore(Color pixel) {
		double brightnessScore = 0.21*pixel.getRed() + 0.71*pixel.getGreen() + 0.07*pixel.getBlue();
		return brightnessScore;
	}
}
