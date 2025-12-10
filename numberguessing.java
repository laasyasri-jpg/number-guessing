import java.util.Scanner;
import java.util.Random;

// CO6: Using class and object concepts
public class numberguessing {

    // CO4: A method to check the guess
    public static String checkGuess(int guess, int randomNumber) {
        if (guess == randomNumber) {
            return "correct";
        } else if (guess < randomNumber) {
            return "low";
        } else {
            return "high";
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // CO2: Variables
        int randomNumber = random.nextInt(100) + 1;
        int attempts = 0;
        int maxAttempts = 10;

        // CO5: Array to store guess history
        int[] guessHistory = new int[maxAttempts];

        System.out.println(" Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts. Good luck!\n");

        // CO3: Loop
        while (attempts < maxAttempts) {

            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();

            guessHistory[attempts] = userGuess; // Store guess
            attempts++;

            // CO4: Calling method
            String result = checkGuess(userGuess, randomNumber);

            if (result.equals("correct")) {
                System.out.println("\nCongratulations! You guessed the number!");
                break;
            } else if (result.equals("low")) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }

            System.out.println("Attempts left: " + (maxAttempts - attempts));
        }

        // CO2: Conditions
        if (attempts == maxAttempts) {
            System.out.println("\n You used all attempts! The number was: " + randomNumber);
        }

        // CO5: Displaying array (history)
        System.out.println("\nYour Guess History:");
        for (int i = 0; i < attempts; i++) {
            System.out.println("Guess " + (i + 1) + ": " + guessHistory[i]);
        }

        scanner.close();
    }
}