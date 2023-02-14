import java.util.*;

public class Sort {
    public static void main (String args[]) {
        int numbers[] = { 1, 2, 3, 10, 3, 4, 12};
        char letters[] = {'t', 'e', 'a', 'p', 'o', 'q', 's', 'v', 'b', 'g', 'r'};
        Arrays.sort(letters);
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(letters));
    }
}
