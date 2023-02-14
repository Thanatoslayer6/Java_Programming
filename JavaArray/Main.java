public class Main {
    public static void main (String[] args) {
        // Allocates 100 bytes? into memory
        //String[] example = new String[100];
        String[] example = {
            "Hello World",
            "Wow!"
        };
        // example[0] = "Hello World";
        // example[1] = "Wow!";
        for (int i = 0; i < example.length; i++) {
            System.out.println(example[i]);
        }

    }
}
