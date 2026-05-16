import java.util.Random;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {

            
            int secretNumber = random.nextInt(100) + 1;

            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            
            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");
                int guess = scanner.nextInt();

                attempts++;

                
                if (guess == secretNumber) {

                    System.out.println("Correct! You guessed the number in "
                            + attempts + " attempts.");

                    score += (maxAttempts - attempts + 1) * 10;
                    guessedCorrectly = true;
                    break;

                } else if (guess < secretNumber) {

                    System.out.println("Too low!");

                } else {

                    System.out.println("Too high!");
                }

                System.out.println("Attempts left: "
                        + (maxAttempts - attempts));
            }

            
            if (!guessedCorrectly) {

                System.out.println("\nGame Over!");
                System.out.println("The correct number was: " + secretNumber);
            }

            
            System.out.println("Current Score: " + score);

            
            System.out.print("\nDo you want to play again? (yes/no): ");
            String choice = scanner.next();

            if (!choice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nThanks for playing!");
        System.out.println("Final Score: " + score);

        scanner.close();
    }
}