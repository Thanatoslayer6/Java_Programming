
import java.util.Scanner;

public class Main1 {
    // Instantiate scanner object
    static Scanner scan = new Scanner(System.in);
    
    // Method/Function for getting user input (floor numbers from 1-7);
    public static int getFloorNumber() {
        int floorNumber = scan.nextInt();
        // Check if user input is appropriate (from floor 1-7 only)
        if (floorNumber > 7 || floorNumber < 1) {
            System.out.println("Error! Please input a floor number ranging from 1 - 7 only!");
            System.exit(0); // Exit the program
        }
        return floorNumber;
    }

    public static void main(String args[]) {
        // Global string variable for getting the user direction if 'UP', 'DOWN', or 'UP and DOWN'
        String userDirection;

        // STEP 1: Get the current floor of the user, and the direction if 'UP', 'DOWN', or 'UP and DOWN' the floor number of elevator 1, and elevator 2
        System.out.print("Which floor are you located now? (1-7): ");
        int currentFloor = getFloorNumber();

        scan.nextLine(); // Clear input after getting string
        // Get user input if he/she wants to go UP/DOWN or UP and DOWN 
        if (currentFloor == 7) {
            // If the current floor is the 7th floor, the user is forced to go down since there is no 8th floor
            userDirection = "DOWN";
            System.out.println("Attempting to go down using the elevator...");   
        } else if (currentFloor == 1) {
            // If the current floor is the 1st floor, the user is forced to go up since there is no 0th floor
            userDirection = "UP";
            System.out.println("Attempting to go up using the elevator...");
        } else {
            System.out.print("Do you want to go up or down the elevator? ('UP', 'DOWN' or 'UP and DOWN'): ");
            userDirection = scan.nextLine();
        }
        
        // Get floor number of elevator 1
        System.out.print("Input designated floor # of ELEVATOR (1) - LEFT: ");
        int elevatorOne = getFloorNumber();
        // Get floor number of elevator 2
        System.out.print("Input designated floor # of ELEVATOR (2) - RIGHT: ");
        int elevatorTwo = getFloorNumber();
        
        int numOfFloorsForElevatorOne = Math.abs(currentFloor - elevatorOne);
        int numOfFloorsForElevatorTwo = Math.abs(currentFloor - elevatorTwo);

        int timeElapsedForElevatorOne = (numOfFloorsForElevatorOne * 2); 
        int timeElapsedForElevatorTwo = (numOfFloorsForElevatorTwo * 2);

        // STEP 3: Show output properly 
        // if (numOfFloorsForElevatorOne == numOfFloorsForElevatorTwo) {
        //     moveElevators(elevatorOne, elevatorTwo, currentFloor, timeElapsedForElevatorOne, timeElapsedForElevatorTwo, true);
        // } else if (numOfFloorsForElevatorOne > numOfFloorsForElevatorTwo || numOfFloorsForElevatorOne < numOfFloorsForElevatorTwo) {
        //     moveElevators(elevatorOne, elevatorTwo, currentFloor, timeElapsedForElevatorOne, timeElapsedForElevatorTwo, false);
        // } 
        // If both elevators are on the same floor then
        if (elevatorOne == elevatorTwo && userDirection) {

        }
    }
    // Method/Function for showing the elevator and where it's heading, handles the delay as well...
}

