import java.util.Scanner;

public class Main {
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
        
        // STEP 2: Use algorithm process explained below
        /*
         * EXPLANATION - Get the lowest difference between elevators
         * Basically, we take the current floor number, then subtract it to elevator one's floor number and take its ABSOLUTE VALUE
         * because in some cases a negative value might arise... This process is also done to elevator two, check code below
        */
        int numOfFloorsForElevatorOne = Math.abs(currentFloor - elevatorOne);
        int numOfFloorsForElevatorTwo = Math.abs(currentFloor - elevatorTwo);
        /*
         * EXPLANATION: - Get time elapsed for each elevator to reach the current floor
         * To get the time it needs for an elevator to reach the current floor, simply multiply its number of floors needed by 2
         * because an elevator will spend 2 seconds per floor, additionally with 1 second for opening and closing the door if it 
         * is on the current floor
         */
        // For instance if Elevator 1 is on the 5th floor and the current floor is at the 3rd floor the number of floors it takes is 2 which means it will take 4 seconds to reach the current floor
        // both variables will store time in seconds
        int timeElapsedForElevatorOne = (numOfFloorsForElevatorOne * 2); 
        int timeElapsedForElevatorTwo = (numOfFloorsForElevatorTwo * 2);
            
        // STEP 3: Show output properly 
        if (numOfFloorsForElevatorOne == numOfFloorsForElevatorTwo) {
            moveElevators(elevatorOne, elevatorTwo, currentFloor, timeElapsedForElevatorOne, timeElapsedForElevatorTwo, true);
        } else if (numOfFloorsForElevatorOne > numOfFloorsForElevatorTwo || numOfFloorsForElevatorOne < numOfFloorsForElevatorTwo) {
            moveElevators(elevatorOne, elevatorTwo, currentFloor, timeElapsedForElevatorOne, timeElapsedForElevatorTwo, false);
        } 
    } 
    
    // Method/Function for showing the elevator and where it's heading, handles the delay as well...
    public static void moveElevators(
            int elevatorOne, 
            int elevatorTwo, 
            int targetFloor, 
            int timeElapsedForElevatorOne, 
            int timeElapsedForElevatorTwo, 
            boolean areElevatorsOnSameFloor) throws InterruptedException 
    {
        if (areElevatorsOnSameFloor) {
            System.out.println("\n[START] ELEVATOR (1) preparing to arrive at floor " + targetFloor);
            System.out.println("[START] ELEVATOR (2) preparing to arrive at floor " + targetFloor + "\n");
            for (int i = elevatorOne, j = elevatorTwo; i != targetFloor && j != targetFloor; i += ((elevatorOne < targetFloor) ? 1 : -1), j += ((elevatorTwo < targetFloor) ? 1 : -1)) {
                System.out.println("[MOVING] ELEVATOR (1) is currently now at " + i);
                System.out.println("[MOVING] ELEVATOR (2) is currently now at " + j);
                Thread.sleep(2000);
            }
            System.out.println("[STATIONARY] ELEVATOR (1) has arrived at floor " + targetFloor + " (took " + timeElapsedForElevatorOne + " seconds)");
            System.out.println("[STATIONARY] ELEVATOR (2) has arrived at floor " + targetFloor + " (took " + timeElapsedForElevatorTwo + " seconds)");
            System.out.println("\n[OPENING/CLOSING DOOR] ELEVATOR (1) is now preparing to leave...");
            System.out.println("[OPENING/CLOSING DOOR] ELEVATOR (2) is now preparing to leave...");
            Thread.sleep(1000); // Sleep for 1 second for opening/closing the door
            System.out.println("\n[END] ELEVATOR (1) has left...");
            System.out.println("[END] ELEVATOR (2) has left...\n");
        } else {
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
            System.out.println("\n[OPENING/CLOSING DOOR] ELEVATOR (1) is now preparing to leave...");
            System.out.println("[OPENING/CLOSING DOOR] ELEVATOR (2) is now preparing to leave...");
            Thread.sleep(1000); // Sleep for 1 second for opening/closing the door
            System.out.println("\n[END] ELEVATOR (1) has left...");
            System.out.println("[END] ELEVATOR (2) has left...");
        }
    }
}
