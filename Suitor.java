import java.util.HashMap;
import java.util.Scanner;

public class Suitor {

		// Inner class to represent each suitor node
		static class SuitorNode {
				int number;
				String name;
				SuitorNode next;

				public SuitorNode(int number, String name) {
						this.number = number;
						this.name = name;
						this.next = null;
				}
		}


		public static void start(Scanner scnr) {
				System.out.println("\nSelect the suitor.");

				// Get the number of suitors
				System.out.print("Enter the number of Suitors: ");
				int n = Integer.parseInt(scnr.nextLine());

			// Help Avoid negative inputs
				if (n <= 0) {
						System.out.println("Number of suitors should be positive.");
						return;
				}

				// Get the names of the suitors
				HashMap<Integer, String> suitorNames = new HashMap<>();
				SuitorNode head = null;
				SuitorNode tail = null;

			// Get the names of the suitors
				for (int i = 1; i <= n; i++) {
						System.out.print("Enter name of Suitor #" + i + ": ");
						String name = scnr.nextLine();
						suitorNames.put(i, name);
						SuitorNode newSuitor = new SuitorNode(i, name);
						if (head == null) {
								head = newSuitor;
								tail = newSuitor;
						} else {
								tail.next = newSuitor;
								tail = newSuitor;
						}
				}
			
				if (tail != null) {
						tail.next = head;
				}

				// Start elimination process
				SuitorNode current = head;
				SuitorNode prev = tail;

				while (current.next != current) {
						// Count three nodes to find the one to eliminate
						for (int count = 1; count < 3; count++) {
								prev = current;
								current = current.next;
						}

						// Eliminate the current node
						System.out.println("Suitor #" + current.number + ", " + current.name + ", is now eliminated.");
						prev.next = current.next;
						current = current.next;
				}

				// Display the selected suitor
				System.out.println("\nThe correct suitor was #" + current.number + ", " + current.name + ".");
		}
}
