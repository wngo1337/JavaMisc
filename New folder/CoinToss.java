import java.util.*;

public class CoinToss {

	public static void main(String args[]) {
		Scanner myScanner = new Scanner(System.in);
		boolean toss;
		Random random = new Random();


		while (true) {
			System.out.print("Would you like to toss the coin (y/n): ");
			String confirm = myScanner.nextLine();
			if (confirm.equalsIgnoreCase("y")) {
				toss = random.nextBoolean();
				if (toss == true) {
					System.out.println("lolz u got heads");
				} else {
					System.out.println("lmao u got tails");
				}
			} else if (confirm.equalsIgnoreCase("n")) {
				System.out.println("fine, be that way, ho");
				System.exit(0);
			} else {
				System.out.println("Enter y or n next time dumbass");
			}
		}
	}
}
