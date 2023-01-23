import java.util.Scanner;
public class Main {
    public static void main (String args[]) {
        // COMPUTER
        // 0 - Rock, 1 - Paper, 2 - Scissors 
        // USER
        // 3 - Rock, 4 - Paper, 5 - Scissors 
        
        // Generate a random number from 0 - 2 
        int randomNumber = (int) ((Math.random() * 3));
        // Get input from user
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: \n 3 - Rock \n 4 - Paper \n 5 - Scissors \n= ");
        int userInput = scan.nextInt();
        // Win if user entered rock
        if (userInput == 3) { // ROCK
            if (randomNumber == 0) { // ROCK 
                System.out.println("DRAW!!!, both played ROCK");
            } else if (randomNumber == 1) { // PAPER
                System.out.println("YOU LOSE!!!, enemy played PAPER");
            } else if (randomNumber == 2) { // SCISSORS
                System.out.println("YOU WIN!!!, enemy played SCISSORS");
            }
        } else if (userInput == 4) { // PAPER
            if (randomNumber == 0) { // ROCK 
                System.out.println("YOU WIN!!!, enemy played ROCK");
            } else if (randomNumber == 1) { // PAPER
                System.out.println("DRAW!!!, both played PAPER");
            } else if (randomNumber == 2) { // SCISSORS
                System.out.println("YOU LOSE!!!, enemy played SCISSORS");
            }
        } else if (userInput == 5) { // SCISSORS
            if (randomNumber == 0) { // ROCK 
                System.out.println("YOU LOSE!!!, enemy played ROCK");
            } else if (randomNumber == 1) { // PAPER
                System.out.println("YOU WIN!!!, enemy played PAPER");
            } else if (randomNumber == 2) { // SCISSORS
                System.out.println("DRAW!!!, both played SCISSORS");
            }
        } else {
            System.out.println("Please enter number properly");
        }

    }
}
