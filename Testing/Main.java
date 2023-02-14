import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("How many names do you want to enter?: ");
        int sizeOfArray = scan.nextInt();
        scan.nextLine(); 

        String names[] = new String[sizeOfArray]; // 5 Size

        for (int i = 0; i < names.length; i++) {
            System.out.print("Enter a name: ");
            names[i] = scan.nextLine();
        }
        // Output the names
        for (int i = 0; i < names.length; i++)  {
            System.out.println(names[i]);
        }

        // Generate a random number from 0 - (names.length - 1)
        int randomNumberIndex = (int) (Math.random() * names.length);
        System.out.println("The winner is: " + names[randomNumberIndex]);

        
    }
}
