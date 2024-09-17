import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int round = 1;

        System.out.println("Welcome to the Guessing Game!");

        while (playAgain) {
            System.out.println("\nRound " + round);
            System.out.println("I'm thinking of a number between 1 and 100.");
            int randomNumber = random.nextInt(100) + 1;
            int attemptsLeft = 10;  // Limit the number of attempts to 10
            boolean guessedCorrectly = false;

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess (You have " + attemptsLeft + " attempts left): ");
                int guess = scanner.nextInt();
                attemptsLeft--;

                if (guess < randomNumber) {
                    System.out.println("Too low!");
                } else if (guess > randomNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the correct number.");
                    totalScore += attemptsLeft + 1;  // Score based on remaining attempts
                    guessedCorrectly = true;
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + randomNumber);
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine();  // Consume newline
            String response = scanner.nextLine();
            playAgain = response.equalsIgnoreCase("yes");
            round++;
        }

        System.out.println("Your total score is: " + totalScore);
        System.out.println("Thanks for playing the Guessing Game. Have a great day!");
        scanner.close();
    }
}
