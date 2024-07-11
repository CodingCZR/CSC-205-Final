```markdown
# CSC205 Final Project

Welcome to the final project for CSC205. This project consists of three separate programming mini-projects, each implemented as part of a main program controlled by a menu. Below are the steps to get you started and a detailed explanation of each mini-project.

## Getting Started

To begin, download and extract the provided zipped folder containing the following four Java files:

- `Main.java`
- `Suitor.java`
- `HauntedHouse.java`
- `Sentiment.java`

These files include template code to help you get started with the menu and empty class files for each of the three mini-projects.

## Main.java

This file contains the main menu program that allows the user to select and run each of the three mini-projects. Update the `author` variable with your name and MEID.

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

## Suitor.java

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

## Inner Class `SuitorNode`

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

## `start` Method

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

---

This explanation provides a detailed overview of how the `Suitor.java` file implements the selection process for Prince Val's suitor using a circular linked list and an elimination algorithm.
```

## HauntedHouse.java

This mini-project simulates a haunted house where the user must navigate through rooms to find the exit.

### Requirements
- Implement the haunted house using references to instances of a Node class.
- Start the user in node A, with the goal of reaching the exit in node L.
- Output possible moves in the north, south, east, or west direction.

### Sample Output
```
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

## Sentiment.java

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

## Instructions for Running the Project

1. Ensure you have all four Java files (`Main.java`, `Suitor.java`, `HauntedHouse.java`, `Sentiment.java`) in the same directory.
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

This README provides an overview of the CSC205 final project, including the main program and detailed requirements for each mini-project. Follow the instructions to implement the necessary functionality and test your program thoroughly. Good luck!
```
