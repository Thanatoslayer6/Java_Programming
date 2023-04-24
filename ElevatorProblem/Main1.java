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

    public static void main(String args[]) throws InterruptedException {
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
        if (userDirection.equalsIgnoreCase("UP and DOWN")) {
            // Both elevators should move
            moveBothElevators(elevatorOne, elevatorTwo, currentFloor, timeElapsedForElevatorOne, timeElapsedForElevatorTwo);
        } else if (userDirection.equalsIgnoreCase("UP") || userDirection.equalsIgnoreCase("DOWN")) {
            // Only one elevator should move, in this case the nearest elevator, if both elevators have the same distance then the right is prioritized
            if (numOfFloorsForElevatorOne < numOfFloorsForElevatorTwo) { // ELEVATOR 1 should move
                moveNearestElevator(1, elevatorOne, currentFloor, timeElapsedForElevatorOne);
            } else if (numOfFloorsForElevatorOne == numOfFloorsForElevatorTwo || numOfFloorsForElevatorOne > numOfFloorsForElevatorTwo) { // ELEVATOR 2 should move
                moveNearestElevator(2, elevatorTwo, currentFloor, timeElapsedForElevatorTwo);
            }
        }
    }

    // Method/Function for showing the elevator and where it's heading, handles the delay as well...
    public static void moveBothElevators(int elevatorOne, int elevatorTwo, int targetFloor, int timeElapsedForElevatorOne, int timeElapsedForElevatorTwo) throws InterruptedException {
        boolean elevatorOneHasArrived = false;
        boolean elevatorTwoHasArrived = false;
        int i = elevatorOne, j = elevatorTwo;
        System.out.println("\n[START] ELEVATOR (1) preparing to arrive at floor " + targetFloor);
        System.out.println("[START] ELEVATOR (2) preparing to arrive at floor " + targetFloor + "\n");
        while (i != targetFloor || j != targetFloor) {
            if (i != targetFloor) {
                System.out.println("[MOVING] ELEVATOR (1) is currently now at " + i);
                i += ((elevatorOne < targetFloor) ? 1 : -1); 
            }

            if (j != targetFloor){
                System.out.println("[MOVING] ELEVATOR (2) is currently now at " + j);
                j += ((elevatorTwo < targetFloor) ? 1 : -1);
            }

            Thread.sleep(2000); // Wait for 2 seconds after ascending/descending

            if (i == targetFloor && elevatorOneHasArrived == false) {
                System.out.println("[STATIONARY] ELEVATOR (1) has arrived at floor " + targetFloor + " (took " + timeElapsedForElevatorOne + " seconds)");
                elevatorOneHasArrived = true;
            }

            if (j == targetFloor && elevatorTwoHasArrived == false) {
                System.out.println("[STATIONARY] ELEVATOR (2) has arrived at floor " + targetFloor + " (took " + timeElapsedForElevatorTwo + " seconds)");
                elevatorTwoHasArrived = true;
            }
        }
        System.out.println("\n~~~ Both elevators are now on the current floor ~~~");
        System.out.println("[OPENING/CLOSING DOOR] ELEVATOR (1) is now preparing to leave...");
        System.out.println("[OPENING/CLOSING DOOR] ELEVATOR (2) is now preparing to leave...");
        Thread.sleep(1000); // Sleep for 1 second for opening/closing the door
        System.out.println("\n[END] ELEVATOR (1) has left...");
        System.out.println("[END] ELEVATOR (2) has left...");
    }

    public static void moveNearestElevator(int elevatorNumber, int startingFloor, int targetFloor, int timeElapsed) throws InterruptedException {
        System.out.println("\n[START] ELEVATOR (" + elevatorNumber + ") preparing to arrive at floor " + targetFloor + "\n");
        for (int i = startingFloor; i != targetFloor; i += (startingFloor < targetFloor) ? 1 : -1) {
            System.out.println("[MOVING] ELEVATOR (" + elevatorNumber + ") is currently now at " + i);
            Thread.sleep(2000);
        }
        System.out.println("[STATIONARY] ELEVATOR (" + elevatorNumber + ") has arrived at floor " + targetFloor + " (took " + timeElapsed + " seconds)");
        System.out.println("\n[OPENING/CLOSING DOOR] ELEVATOR (" + elevatorNumber + ") is now preparing to leave...");
        Thread.sleep(1000); // Sleep for 1 second for opening/closing the door
        System.out.println("\n[END] ELEVATOR (" + elevatorNumber + ") has left...");
    }
}

