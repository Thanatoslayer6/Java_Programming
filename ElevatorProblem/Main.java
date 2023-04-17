import java.util.Scanner;

public class Main {


    public static int getFloor(Scanner scan) {
        int floorNumber = scan.nextInt();
        // Check if user input is appropriate (from floor 1-7 only)
        if (floorNumber > 7 || floorNumber < 1) {
            System.out.println("Error! Please input floor ranging from 1 - 7 only!");
            System.exit(); // Exit the program
        }
        return floorNumber;
    }

    public static void main(String args[]) {
        // Instantiate scanner object
        Scanner scan = new Scanner(System.in);
        // Get current floor of user
        System.out.print("Which floor are you now? (1-7): ");
        int currentFloor = getFloor(scan);
        // Get floor number of elevator 1
        System.out.print("Input designated floor # of Elevator 1 (LEFT): ");
        int elevatorOne = getFloor(scan);
        // Get floor number of elevator 2
        System.out.print("Input designated floor # of Elevator 2 (RIGHT): ");
        int elevatorTwo = getFloor(scan);
        System.out.println(elevatorTwo);
        // Check if user input is appropriate (from floor 1-7 only)
        // if (elevatorOne > 7 || elevatorOne < 1) {
        //     System.out.println("Error! Please input floor ranging from 1 - 7 only!");
        //     return;
        // }

        // Get floor number of elevator 2
        // System.out.print("Input designated floor # of Elevator 2 (RIGHT): ");
        // int elevatorTwo = scan.nextInt();
        // System.out.println(elevatorTwo);

        // // Check if user input is appropriate (from floor 1-7 only)
        // if (elevatorTwo > 7 || elevatorTwo < 1) {
        //     System.out.println("Error! Please input floor ranging from 1 - 7 only!");
        //     return;
        // }
    
        System.out.print("Enter decision (UP/DOWN or UP and DOWN): ");
        // Get user input if he/she wants to go UP/DOWN or UP and DOWN 
        String userDecision = scan.next();
        System.out.println(" Current floor: " + currentFloor);
        System.out.println(" Elevator 1: " + elevatorOne);
        System.out.println(" Elevator 2: " + elevatorTwo);
        System.out.println(userDecision);
    } 
    
}
