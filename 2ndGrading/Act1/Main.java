import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int x;
        do {
            System.out.println("Enter a number");
            x = scan.nextInt();
        } while (x >= 3);
    }
}
