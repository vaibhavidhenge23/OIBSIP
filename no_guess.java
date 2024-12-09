import java.util.Random;
import java.util.Scanner;
    
public class no_guess {
    
   
        
        public static void main(String[] args) {
            
            // Initializing the input
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
    
            int Wining_round = 0; // tracks how many round won
            int totalRounds = 0; // Total number of rounds played
    
            System.out.println("Welcome !!!! ");
    
            boolean playAgain; // for another round
    
         
            do {
                
                int targetNo = random.nextInt(100) + 1;
                int attempts = 0;
                int maxAttempts = 7;
                boolean roundsWon = false;
    
                System.out.println(" Select the  no. between 1 to 100 ");
                
                
                while (attempts < maxAttempts) {
                    System.out.print("Enter your selected no. : ");
                    int guess = scanner.nextInt();
                    attempts++;
    
                   
                    if (guess == targetNo) {
                        System.out.println("Congratulations! You've guessed the correct number!");
                        roundsWon = true;
                        break;
                    } else if (guess < targetNo) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }
    
                    System.out.println("Attempts remaining: " + (maxAttempts - attempts));
                }
    
                
                if (roundsWon) {
                    Wining_round++;
                    System.out.println("You won this round in " + attempts + " attempts!");
                } else {
                    System.out.println("Sorry, you've used all attempts. The number was " + targetNo);
                }
    
                totalRounds++;
    
                
                System.out.print("Do you want to play another round? (yes/no): ");
                playAgain = scanner.next().equalsIgnoreCase("yes");
    
            } while (playAgain);
    
            
            System.out.println("\nGame Over!");
            System.out.println("Rounds won: " +Wining_round + " out of " + totalRounds);
            System.out.println("Thank you for playing!");
    
          
            scanner.close();
        }
    }

