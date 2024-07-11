import java.util.Scanner;

public class Main {

		final static String author = "Cesar Miranda"; // change this to your name/MEID

		public static void main(String[] args) {
				Scanner scnr = new Scanner(System.in);
				String menuOption;

				do {
						// Introduction to the program
						System.out.println("\nWelcome to the CSC205 final project of " + author);

						System.out.println("\n");
						System.out.println("1. Select the Suitor.");
						System.out.println("2. Escape the Haunted House.");
						System.out.println("3. Sentiment Analysis.");
						System.out.println("\nQ. Quit.");

					// Ask user for menu option
						do {
								System.out.print("\nYour option ==> ");
								menuOption = scnr.nextLine().trim(); // Trim to remove any whitespace
						} while (menuOption.isEmpty());

						// Process user's menu option
						switch (menuOption.charAt(0)) {
								case '1':
										// Select the suitor
										Suitor.start(scnr);
										break;
								case '2':
										// Escape the haunted house
										HauntedHouse.start(scnr);
										break;
								case '3':
										// Sentiment analysis
										 Sentiment.start(scnr);
										break;
								case 'Q':
								case 'q':
										// Quit the program
										System.out.println("Thank you for using the program. Goodbye and have a good day!");
										break;
								default:
										System.out.println("Invalid option. Please choose a valid option.");
						}

				} while (menuOption.toUpperCase().charAt(0) != 'Q');

				scnr.close(); // Close the scanner to release resources
		}
}
