import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            // Print the generated number for debugging purposes
            System.out.println("Generated number to guess (for debugging): " + numberToGuess);

            System.out.println("Guess a number between 1 and 100. You have 10 attempts.");

            while (attempts < 10 && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score++;
                    hasGuessedCorrectly = true;
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high. Try again.");
                } else {
                    System.out.println("Too low. Try again.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess);
            }

            System.out.println("Your score: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();

            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing! Final score: " + score);
        scanner.close();
    }
}
