import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalAttempts = 0;
        int totalRounds = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        String playAgain = "yes";
        while (playAgain.equalsIgnoreCase("yes")) {
            totalRounds++;
            System.out.println("\nRound " + totalRounds + ":");
            int targetNumber = random.nextInt(100) + 1; // Generating a random number between 1 and 100
            int attempts = 0;
            
            while (true) {
                System.out.print("Enter your guess (between 1 and 100): ");
                int guess = scanner.nextInt();
                attempts++;
                
                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number " + targetNumber + " correctly in " + attempts + " attempts!");
                    totalAttempts += attempts;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
                
                if (attempts == 5) {
                    System.out.println("Sorry, you've reached the maximum number of attempts.");
                    break;
                }
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next();
        }
        
        double averageAttempts = (double) totalAttempts / totalRounds;
        System.out.printf("\nThank you for playing! Your average number of attempts per round was: %.2f\n", averageAttempts);
        
        scanner.close();
    }
}