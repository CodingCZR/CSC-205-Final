import java.util.Scanner;

public class HauntedHouse {

		// Static nested Node class
		static class Node {
				String name;
				Node north;
				Node south;
				Node east;
				Node west;

				public Node(String name) {
						this.name = name;
						this.north = null;
						this.south = null;
						this.east = null;
						this.west = null;
				}
		}

		// Method to create the graph
		public static void start(Scanner scnr) {
				System.out.println("\nEscape the Haunted House.");

				// Create nodes for each room
				Node A = new Node("A (Start)");
				Node B = new Node("B");
				Node C = new Node("C");
				Node D = new Node("D");
				Node E = new Node("E");
				Node F = new Node("F");
				Node G = new Node("G");
				Node H = new Node("H");
				Node I = new Node("I");
				Node J = new Node("J");
				Node K = new Node("K");
				Node L = new Node("L (Exit)");

				// Define connections (edges) allowing the player to move between rooms
				A.east = B;
				A.south = E;

				B.west = A;
				B.east = C;
				B.south = F;

				C.west = B;
				C.east = D;

				D.west = C;
				D.south = H;

				E.north = A;
				E.south = I;

				F.north = B;
				F.east = G;

				G.west = F;
				G.south = K;

				H.north = D;

				J.west = I;
				I.north = E;
				I.east = J;

				K.north = G;
				K.east = L;

				L.west = K;

				// Setting starting point as room A
				Node currentRoom = A;

				// Start navigation
				navigate(currentRoom, scnr);
		}

		// Method to navigate the player through the rooms
		private static void navigate(Node current, Scanner scnr) {
				while (current != null) {
						System.out.println("Current room: " + current.name);

						// Display available navigation options
						if (current.north != null) {
								System.out.println("Option: Go North to " + current.north.name);
						}
						if (current.south != null) {
								System.out.println("Option: Go South to " + current.south.name);
						}
						if (current.east != null) {
								System.out.println("Option: Go East to " + current.east.name);
						}
						if (current.west != null) {
								System.out.println("Option: Go West to " + current.west.name);
						}

						// Ask user for direction
						System.out.print("Enter direction (north/south/east/west): ");
						String direction = scnr.nextLine().trim().toLowerCase();

						// Update current node based on user input
						switch (direction) {
								case "north":
										current = current.north;
										break;
								case "south":
										current = current.south;
										break;
								case "east":
										current = current.east;
										break;
								case "west":
										current = current.west;
										break;
								default:
										System.out.println("Invalid direction. Try again.");
						}

						// Check if the user has reached the exit
						if (current != null && current.name.equals("L (Exit)")) {
								System.out.println("Congratulations! You've escaped the haunted house.");
								break;
						}
				}
		}
}

