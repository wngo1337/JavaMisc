

public class testUniqueArray {

	public static void main(String[] args) {
		
		int arrayLength = 7;
		int myArray[] = new int[arrayLength];
		for (int i = 0; i < arrayLength; i++) {
			myArray[i] = (int)(Math.random()*20 + 1);
		}
		for (int derp : myArray) {
			System.out.print(derp + " ");
		}
		
		System.out.println();
		
		for (int i = 0; i < arrayLength; i++) {
			for (int j = i + 1; j < arrayLength; j++) {
				if (myArray[i] == myArray[j]) {
					System.out.println("We got a dupe, exiting");
					System.exit(0);
				}
			}
		}
		System.out.println("If we get here, no dupes in array");
	}
	
}
