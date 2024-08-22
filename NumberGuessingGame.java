import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame { // Class name should be capitalized
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        // Welcome message and prompt for number of rounds
        System.out.println("Welcome to the NUMBER GUESSING GAME!!!!!");
        System.out.print("Enter the number of rounds you would like to play: ");
        int totalRounds = input.nextInt();
        int overallScore = 0;

        // Loop through the specified number of rounds
        for (int currentRound = 1; currentRound <= totalRounds; currentRound++) {
            System.out.println("\nStart the game!!!");
            System.out.println("Round Number: " + currentRound);

            // Generate a random number between 1 and 100
            int guessedNumber = random.nextInt(100) + 1;
            int guessCount = 0;
            int maxGuesses = 5; // Limit the number of attempts to 5

            // Loop to allow the user multiple attempts to guess the number
            while (guessCount < maxGuesses) {
                System.out.println("Attempt: " + (guessCount + 1));
                System.out.print("Make your guess: ");
                int userGuess = input.nextInt();
                guessCount++;

                // Check if the user's guess is correct
                if (userGuess == guessedNumber) {
                    System.out.println("Hurrayyyyy!!!! Your guess was right\n");
                    overallScore += (maxGuesses - guessCount + 1); // Add points based on remaining attempts
                    break;
                } else if (userGuess < guessedNumber) {
                    System.out.println("Too low, try again.");
                } else {
                    System.out.println("Too high, try again.");
                }

                // If the user runs out of attempts, reveal the number
                if (guessCount == maxGuesses) {
                    System.out.println("Out of attempts! The correct number was " + guessedNumber + ".");
                }
            }
        }

        // Display the final score and end the game
        System.out.println("\nGAME FINISHED!! Your final score is: " + overallScore);
        input.close(); // Close the scanner to prevent resource leaks
    }
}
