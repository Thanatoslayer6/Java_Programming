import java.util.Scanner;

public class Elevator {

  static int[] elevatorFloor = new int[2];
  static int elevatorDelayMultiplier;

  public static String getNearestElevator(int floor) {
    int[] elevatorDistance = { Math.abs(floor - elevatorFloor[0]), Math.abs(floor - elevatorFloor[1]) };

    if (elevatorDistance[0] < elevatorDistance[1]) {
      elevatorDelayMultiplier = elevatorDistance[0];
      return "ELEVATOR (1)";
    } else if (elevatorDistance[0] > elevatorDistance[1]) {
      elevatorDelayMultiplier = elevatorDistance[1];
      return "ELEVATOR (2)";
    } else {
      return "ELEVATOR (2)";
    }
  }

  public static void moveElevator(String elevator, int floor) throws InterruptedException {
    if (elevator.equals("ELEVATOR (1)")) {
      System.out.println("ELEVATOR (1) is moving to floor " + floor);
      Thread.sleep(2000 * elevatorDelayMultiplier);
      elevatorFloor[0] = floor;
    } else {
      System.out.println("ELEVATOR (2) is moving to floor " + floor);
      Thread.sleep(2000 * elevatorDelayMultiplier);
      elevatorFloor[1] = floor;
    }
  }

  public static void main(String[] args) throws InterruptedException {

    Scanner scan = new Scanner(System.in);

    int currentFloor;

    do {
      System.out.print("Current floor (1-7): ");
      currentFloor = scan.nextInt();
    } while (currentFloor < 1 || currentFloor > 7);

    scan.nextLine();

    System.out.println("U - Up: ");
    System.out.println("D - Down: ");
    System.out.println("B - Up & Down: ");
    String userFloor = scan.nextLine();

    // Elevator 1
    do {
      System.out.print("ELEVATOR 1 current floor (1-7): ");
      elevatorFloor[0] = scan.nextInt();
    } while (elevatorFloor[0] < 1 || elevatorFloor[0] > 7);

    // Elevator 2
    do {
      System.out.print("ELEVATOR 2 current floor (1-7): ");
      elevatorFloor[1] = scan.nextInt();
    } while (elevatorFloor[1] < 1 || elevatorFloor[1] > 7);

    String elevator = getNearestElevator(currentFloor);

    System.out.println("Sending " + elevator + " elevator to floor " + currentFloor);
    moveElevator(elevator, currentFloor);
    System.out.println("Opening " + elevator + " elevator door");
    Thread.sleep(1000);
    System.out.println("Closing " + elevator + " elevator door");
  }
}
