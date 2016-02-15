import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BullsAndCows {

	public static void main(String[] args) {
		Random rand = new Random();
		int[] random = numberGenerator();
		System.out.println("The computer has chosen a 4 digit number (no digits in the number repeat).\n"
				+ "You will get a bull for every guessed number on it's position and a cow for every guessed number which is not on its place. Try to guess the number.");
		System.out.println("The number of the computer is: " + Arrays.toString(random));
		int cows = 0;
		int bulls = 0;
		boolean guessed = false;
		while (bulls != 4) {
			int[] guess = getGuess();
			cows = 0;
			bulls = 0;
			for (int i = 0; i < random.length; i++) {
				if (random[i] == guess[i]) {
					bulls++;
				} else if (random[i] == guess[0] || random[i] == guess[1] || random[i] == guess[2]
						|| random[i] == guess[3]) {
					cows++;
				}

			}
			if (bulls == 4) {
				guessed = true;
			}

			if (guessed == true) {
				System.out.println("You made it. Congratulations!!!");
			} else {
				System.out.println(cows + " cows and " + bulls + " bulls.");
			}
		}
	}

	public static int[] getGuess() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter your guess: ");
		String input = keyboard.nextLine();
		if (input.length() != 4) {
			System.out.println("You must enter 4 digits between 0-9 only.");
			return getGuess();
		}
		int[] guess = new int[4];
		for (int i = 0; i < 4; i++) {
			guess[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
		}
		return guess;
	}

	public static int[] numberGenerator() {
		Random randy = new Random();
		int[] randArray = { 10, 10, 10, 10 };

		for (int i = 0; i < randArray.length; i++) {
			int temp = randy.nextInt(9);
			while (temp == randArray[0] || temp == randArray[1] || temp == randArray[2] || temp == randArray[3]) {
				temp = randy.nextInt(9);
			}
			randArray[i] = temp;
		}
		return randArray;

	}

}
