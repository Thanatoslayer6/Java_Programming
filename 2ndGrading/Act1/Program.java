import java.util.Scanner;

public class Program {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int integer = 0, sum = 0;
        do {
            sum += integer;
            System.out.print("Enter an integer: ");
            integer = scan.nextInt();
        } while (integer >= 0);
        System.out.println("The sum of all positive integers is: "  + sum);
    }
}
