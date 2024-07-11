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
