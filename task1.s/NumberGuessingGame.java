import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int numberOfTries = 0;
            int maxTries = 5;
            int guess;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have chosen a number between 1 and 100. Can you guess it?");
            System.out.println("You have " + maxTries + " attempts.");

            do {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                numberOfTries++;

                if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                }
            } while (guess != numberToGuess && numberOfTries < maxTries);

            if (guess == numberToGuess) {
                System.out.println("Congratulations! You found the number in " + numberOfTries + " tries.");
            } else {
                System.out.println("Sorry, you've used all your attempts. The number was: " + numberToGuess);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String answer = scanner.next();
            playAgain = answer.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}