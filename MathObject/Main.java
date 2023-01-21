import java.util.Scanner;

public class Main {
    public static void main (String args[]) { 
        // MATH Object
        // Returns absolute value
        int x = -90;
        System.out.println("Absolute value of " + x + " is " + Math.abs(x));

        // max() - returns maximum value
        System.out.println("Largest value between 19 and 20 is: " + Math.max(19, 20));

        // min() - returns minimum value
        System.out.println("Smallest value between 19 and 20 is: " + Math.min(19, 20));

        // Returns hypotenuse using Pythagorean theorem defined as a^2 + b^2 = c^2
        // hypot()
        int a = 3; // a = 3
        int b = 4; // b = 5
        System.out.println("Hypotenuse of a right triangle with side lengths 3 and 4 is: " + Math.hypot(a, b));
        
        // Returns a value from 0 - 1 can be a decimal if float/double
        // random()
        int oneToHundred = ((int) Math.random() * 99) + 1;
        System.out.println("Random value from 1 to 100 percent: " + oneToHundred);

        
    }
}
