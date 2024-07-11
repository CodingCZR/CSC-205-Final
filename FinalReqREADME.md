
# CSC205 Final Project

Welcome to my final project for CSC205. This project consists of three separate programming mini-projects, each implemented as part of a main program controlled by a menu. Below are the detailed explanation and requirments of each mini-projet, as well as explination for my code.

## Getting Started

To begin, we were instructed to download and extract the provided zipped folder containing the following four Java files:

- `Main.java`
- `Suitor.java`
- `HauntedHouse.java`
- `Sentiment.java`

These files include template code to get started with the menu and empty class files for each of the three mini-projects.

# Main.java

This file contains the main menu program that allows the user to select and run each of the three mini-projects. Updating the `author` variable with my name and for privacy reasons, my school ID will be removed from this project. 

```java
import java.util.Scanner;

public class Main {

   final static String author = "Your Name/MEID"; // change this to your name/MEID

   public static void main (String[] args) {

      Scanner scnr = new Scanner(System.in);
      String  menuOption;
      char    selectOption;

      do {
         System.out.println("\nWelcome to the CSC205 final project of " + author);

         System.out.println("\n");
         System.out.println("1. Select the Suitor.");
         System.out.println("2. Escape the Haunted House.");
         System.out.println("3. Sentiment Analysis.");
         System.out.println("\nQ. Quit.");

         do {
            System.out.print("\nYour option ==>");
            menuOption = scnr.nextLine();
         } while (menuOption.length()<1);

         switch (menuOption.charAt(0)) {

            case '1':
               // select the suitor
               Suitor.start(scnr);
               break;

            case '2':
               // escape the haunted house
               HauntedHouse.start(scnr);
               break;

            case '3':
               // sentiment analysis
               Sentiment.start(scnr);
               break;
         }

      } while (menuOption.toUpperCase().charAt(0) != 'Q');
   }
}
```

# Suitor.java Information and Requirements

This mini-project involves an algorithm to determine which suitor will marry Prince Val in the city of Atlantis. The suitors are eliminated in a specific sequence until only one remains.

### Requirements
- Implement a linked list of nodes to determine the position a suitor should stand if they want to marry the prince.
- Prompt the user for the number of suitors and each suitor's name.
- Print the selected suitor and their name after the elimination process.

### Sample Output
```
Select the Suitor.
Enter the number of Suitors:  7
Enter name of Suitor #1:  Doc
Enter name of Suitor #2:  Grumpy
Enter name of Suitor #3:  Happy
Enter name of Suitor #4:  Sleepy
Enter name of Suitor #5:  Bashful
Enter name of Suitor #6:  Sneezy
Enter name of Suitor #7:  Dopey

Suitor #3, Happy, eliminated.
Suitor #6, Sneezy, eliminated.
Suitor #2, Grumpy, eliminated.
Suitor #7, Dopey, eliminated.
Suitor #5, Bashful, eliminated.
Suitor #1, Doc, eliminated.
The correct suitor was #4, Sleepy.
```

```java
import java.util.Scanner;

public class Suitor {

   public static void start (Scanner scnr) {

      System.out.println("\n");
      System.out.println("Select the suitor.");

      // Your code here

   }
}
```


# Suitor.java Explanation

The `Suitor.java` file implements an algorithm to determine which suitor will marry Prince Val in the city of Atlantis. Below is an explanation of how the code works and what each part does:

### Inner Class `SuitorNode`

```java
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
```

- `SuitorNode` represents each suitor in the linked list. It stores the suitor's number, name, and a reference to the next suitor in the list.

### `start` Method

```java
public static void start(Scanner scnr) {
    System.out.println("\nSelect the suitor.");

    // Get the number of suitors
    System.out.print("Enter the number of Suitors: ");
    int n = Integer.parseInt(scnr.nextLine());

    // Handle negative inputs
    if (n <= 0) {
        System.out.println("Number of suitors should be positive.");
        return;
    }

    // Initialize data structures
    HashMap<Integer, String> suitorNames = new HashMap<>();
    SuitorNode head = null;
    SuitorNode tail = null;

    // Get the names of the suitors and create the linked list
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
    
    // Close the circular linked list
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
```

### Explanation

1. **Initialization**: 
   - The method starts by prompting the user for the number of suitors and their names, storing them in a `HashMap` (`suitorNames`) and a circular linked list (`head`, `tail`).

2. **Circular Linked List**: 
   - The suitors are arranged in a circular linked list where each `SuitorNode` points to the next, and the last points back to the first (`tail.next = head`).

3. **Elimination Process**: 
   - Using a loop, the method iterates through the linked list, eliminating every third suitor until only one remains (`current.next == current`).

4. **Output**: 
   - Throughout the process, the program prints which suitor is eliminated and finally displays the selected suitor who will marry Prince Val.

# HauntedHouse.java Information and Requirements

This mini-project simulates a haunted house where the user must navigate through rooms to find the exit.

### Requirements
- Implement the haunted house using references to instances of a Node class.
- Start the user in node A, with the goal of reaching the exit in node L.
- Output possible moves in the north, south, east, or west direction.

### Sample Output

Escape the Haunted House.
You are in room A of the Haunted House. You can go east or south.
N
You can't go in that direction!
You are in room A of the Haunted House. You can go east or south.
E
You are in room B of the Haunted House. You can go west, south or east.
S
You are in room F of the Haunted House. You can go north or east.
.
.
.
You are in room L of the Haunted House. You made it out alive!
```

```java
import java.util.Scanner;

public class HauntedHouse {

   public static void start (Scanner scnr) {

      System.out.println("\n");
      System.out.println("Escape the Haunted House.");

      // Your code here

   }
}
```

# HauntedHouse.java Explanation

The `HauntedHouse.java` file simulates a navigation game through a haunted house using a graph representation with rooms interconnected as nodes.

### `start` Method

```java
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
```

### Explanation

1. **Room Initialization**: 
   - The `start` method initializes each room in the haunted house as a `Node` object and defines connections (`north`, `south`, `east`, `west`) between them to create a graph-like structure.

2. **Navigation Start**: 
   - It sets the starting point (`currentRoom`) as room A and calls the `navigate` method to begin navigating through the rooms based on user input.

### `Node` Class

```java
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
```

### Explanation

- **Node Definition**: 
  - The `Node` class represents each room in the haunted house.
  - It stores the room's name and references (`north`, `south`, `east`, `west`) to adjacent rooms (nodes).

### `navigate` Method

```java
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
```

### Explanation

- **Navigation Logic**: 
  - The `navigate` method simulates the navigation through rooms.
  - It displays the current room and available directions to move (`north`, `south`, `east`, `west`).
  - It prompts the user for a direction and updates the `current` node accordingly.
  - It checks if the user has reached the exit (`L (Exit)`) and prints a congratulatory message upon successful escape.

---

# Sentiment.java Information and Requirements

This mini-project performs sentiment analysis on a user-provided text file, determining if the text has a positive, negative, or neutral sentiment.

### Requirements
- Read positive and negative words into separate HashSet<String> objects.
- Prompt the user for the name of a text file and analyze its content.
- Display the number of positive words, negative words, total words, and overall sentiment.

### Sample Output
```
Sentiment Analysis.
2006 Positive Words Successfully Loaded.
4783 Negative Words Successfully Loaded.

Enter the name of the text file to perform sentiment analysis: report.txt

Sentiment Report for report.txt:
There were 51 positive words, 23 negative words and 100 total words.
That's 51% positive and 23% negative. Overall the file's sentiment was positive.
Would you like to analyze another file Y/N? Y

Enter the name of the text file to perform sentiment analysis: portfolio.txt

Sentiment Report for portfolio.txt:
There were 38 positive words, 111 negative words and 200 total words.
That's 19% positive and 56% negative. Overall the file's sentiment was negative.
Would you like to analyze another file Y/N? N
```

```java
import java.util.Scanner;

public class Sentiment {

   public static void start (Scanner scnr) {

      System.out.println("\n");
      System.out.println("Sentiment Analysis.");

      // Your code here

   }
}
```

## Sentiment.java Explanation

The `Sentiment.java` file performs sentiment analysis on text files using predefined sets of positive and negative words.

### `start` Method

```java
public static void start(Scanner scnr) {
    System.out.println("\nSentiment Analysis.");

    // Load positive and negative words
    loadWords("positive.txt", positiveWords);
    loadWords("negative.txt", negativeWords);

    System.out.println(positiveWords.size() + " Positive Words Successfully Loaded.");
    System.out.println(negativeWords.size() + " Negative Words Successfully Loaded.");

    // Ask user for text file to analyze
    boolean analyzeMore = true;
    while (analyzeMore) {
        System.out.print("\nEnter the name of the text file to perform sentiment analysis: ");
        String filename = scnr.nextLine();
        analyzeFile(filename);

        System.out.print("Would you like to analyze another file Y/N? ");
        String response = scnr.nextLine().trim().toUpperCase();
        analyzeMore = response.equals("Y");
    }
}
```

### Explanation

1. **Initialization**: 
   - The `start` method begins by loading positive and negative words from `positive.txt` and `negative.txt` files into `HashSet` collections (`positiveWords` and `negativeWords`).

2. **User Interaction**: 
   - It prompts the user to enter the name of a text file (`filename`) for sentiment analysis and repeatedly asks if the user wants to analyze another file.

3. **Method Calls**: 
   - It calls `loadWords` to populate `positiveWords` and `negativeWords` with words from the respective files.
   - It calls `analyzeFile` to perform sentiment analysis on the user-provided text file.

### `loadWords` Method

```java
private static void loadWords(String filename, HashSet<String> wordSet) {
    try (Scanner fileScanner = new Scanner(new File(filename))) {
        while (fileScanner.hasNextLine()) {
            String word = fileScanner.nextLine().trim();
            if (!word.startsWith(";") && !word.isEmpty()) {
                wordSet.add(word);
            }
        }
    } catch (FileNotFoundException e) {
        System.out.println("File not found: " + filename);
    }
}
```

### Explanation

- **File Loading**: 
  - The `loadWords` method loads words from the specified `filename` into the `wordSet` `HashSet`. It skips lines starting with ';' and ignores empty lines.

### `analyzeFile` Method

```java
private static void analyzeFile(String filename) {
    int positiveCount = 0;
    int negativeCount = 0;
    int totalCount = 0;

    try (Scanner fileScanner = new Scanner(new File(filename))) {
        while (fileScanner.hasNext()) {
            String word = fileScanner.next().toLowerCase().replaceAll("[^a-zA-Z]", "");
            if (!word.isEmpty()) {
                totalCount++;
                if (positiveWords.contains(word)) {
                    positiveCount++;
                } else if (negativeWords.contains(word)) {
                    negativeCount++;
                }
            }
        }

        double positivePercent = (double) positiveCount / totalCount;
        double negativePercent = (double) negativeCount / totalCount;

        System.out.println("\nSentiment Report for " + filename + ":");
        System.out.println("There were " + positiveCount + " positive words, " + negativeCount + " negative words and " + totalCount + " total words.");
        System.out.println("That's " + String.format("%.2f", positivePercent * 100) + "% positive and " + String.format("%.2f", negativePercent * 100) + "% negative.");

        if (positivePercent >= negativePercent + 0.05) {
            System.out.println("Overall the file's sentiment was positive.");
        } else if (negativePercent >= positivePercent + 0.05) {
            System.out.println("Overall the file's sentiment was negative.");
        } else {
            System.out.println("Overall the file's sentiment was neutral.");
        }

    } catch (FileNotFoundException e) {
        System.out.println("File not found: " + filename);
    }
}
```

### Explanation

- **Sentiment Analysis**: 
  - The `analyzeFile` method reads through each word in the specified `filename`, counting occurrences of positive and negative words from `positiveWords` and `negativeWords`.
  - It calculates percentages of positive and negative words relative to the total words in the file.
  - It determines the overall sentiment of the file based on the calculated percentages.


## Instructions for Running the Project

1. Ensure you have all four Java files (`Main.java`, `Suitor.java`, `HauntedHouse.java`, `Sentiment.java` as well as the `.txt` files avaliable) in the same directory.
2. Compile the files using the Java compiler:
   ```sh
   javac Main.java Suitor.java HauntedHouse.java Sentiment.java
   ```
3. Run the `Main` program:
   ```sh
   java Main
   ```
4. Follow the menu prompts to run each mini-project.

---

This README provides an overview of the CSC205 final project, including the main program and the detailed requirements for each mini-project. Under my project, I obtained a 100% on the final! 

