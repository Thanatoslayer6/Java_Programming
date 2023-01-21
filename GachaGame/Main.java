import java.util.Scanner;

public class Main {
    public static void main (String args[]) { 
        // Simple gacha game from 1-6 randomization        
        int randomNumber = (int) (Math.random() * 5) + 1;

        System.out.println("You rolled: " + randomNumber + "\n");
        switch (randomNumber) {
            case 1:
                System.out.println("---------");
                System.out.println("|       |");
                System.out.println("|   *   |");
                System.out.println("|       |");
                System.out.println("---------");
                break;
            case 2:
                System.out.println("---------");
                System.out.println("|       |");
                System.out.println("| *   * |");
                System.out.println("|       |");
                System.out.println("---------");
                break;
            case 3:
                System.out.println("---------");
                System.out.println("|       |");
                System.out.println("| * * * |");
                System.out.println("|       |");
                System.out.println("---------");
                break;
            case 4:
                System.out.println("---------");
                System.out.println("|   *   |");
                System.out.println("| *   * |");
                System.out.println("|   *   |");
                System.out.println("---------");
                break;
            case 5:
                System.out.println("---------");
                System.out.println("| *   * |");
                System.out.println("|   *   |");
                System.out.println("| *   * |");
                System.out.println("---------");
                break;
            default: // If 6
                System.out.println("---------");
                System.out.println("| *   * |");
                System.out.println("| *   * |");
                System.out.println("| *   * |");
                System.out.println("---------");
                break;

        }
    }
}
