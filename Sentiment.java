import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Sentiment {

	// Creating hash sets for positive and negative words
		private static HashSet<String> positiveWords = new HashSet<>();
		private static HashSet<String> negativeWords = new HashSet<>();

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

		// Method to load words from a file into a hash set
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

		// Method to analyze a text file and display sentiment analysis results
		private static void analyzeFile(String filename) {
				int positiveCount = 0;
				int negativeCount = 0;
				int totalCount = 0;

			// Open the text file
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
}

