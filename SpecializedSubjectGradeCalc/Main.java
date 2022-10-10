import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Instantiate scanner class
		Scanner scan = new Scanner(System.in);
		
		// Declare and initialize necessary variables with the right types
		int numberOfActivities, numberOfQuizzes, numberOfMiniTask;
		int totalActivityScore = 0, maxActivityScore = 0, totalQuizScore = 0, maxQuizScore = 0,
			totalMiniTaskScore = 0, maxMiniTaskScore = 0, totalMajorTaskScore = 0, maxMajorTaskScore = 0,
			PrelimScore, PeriodicScore; 

		double WrittenWorks, QuarterlyAssessment, PETA;
		
		/* Create a temporary string array with size 2, and a string variable
		   for manipulating and storing the user's input as a string */
		String Temporary[] = new String[2], tempString;
		
		// ASCII BANNER
		System.out.println(""
				+ "+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n"
				+ "|/                                 \\|\n"
				+ "|     ~ Specialized Subject ~       |\n"
				+ "|        -  Grade Calculator  -     |\n"
				+ "|\\                                 /|\n"
				+ "+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n"
				+ "| NOTE: When entering score and max |\n"
				+ "| score, separate the input using   |\n"
				+ "| the forward slash '/' symbol.     |\n"
				+ "|                                   |\n"
				+ "| EXAMPLE: '10/15' or '38/40'       |\n"
				+ "+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n");

		/* WRITTEN WORKS - Act Sheets, Quizzes, and Prelim... */
		
		// ACTIVITIES
		System.out.print("Enter the number of activities:");
		numberOfActivities = scan.nextInt();

		// Loop over the number of activities, first consume the first line to avoid loop problems
		scan.nextLine();
		for (int i = 1; i <= numberOfActivities; i++) {
			System.out.print("Enter score and max score for Activity #" + i + ": ");
			tempString = scan.nextLine();
			Temporary = tempString.split("/");
			totalActivityScore += Integer.parseInt(Temporary[0]); // Score;
			maxActivityScore += Integer.parseInt(Temporary[1]); // Max-score
		}
		System.out.println("\n  Score of Activities > " + totalActivityScore + " out of " + maxActivityScore);
		System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - - \n");

		// QUIZZES
		System.out.print("Enter the number of quizzes:");
		numberOfQuizzes = scan.nextInt();

		// Loop over the number of activities, first consume the first line to avoid loop problems
		scan.nextLine();
		for (int i = 1; i <= numberOfQuizzes; i++) {
			System.out.print("Enter score and max score for Quiz #" + i + ": ");
			tempString = scan.nextLine();
			Temporary = tempString.split("/");
			totalQuizScore += Integer.parseInt(Temporary[0]); // Score;
			maxQuizScore += Integer.parseInt(Temporary[1]); // Max-score
		}
		System.out.println("\n  Score of Quizzes > " + totalQuizScore + " out of " + maxQuizScore);
		System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - - \n");
		
		// PRELIM
		System.out.print("Enter the score of your Preliminary Exam (out of 40): ");
		PrelimScore = scan.nextInt();
		
		/* QUARTERLY ASSESSMENT - Periodic */ 
		System.out.print("Enter the score of your Periodic Exam (out of 40): ");
		PeriodicScore = scan.nextInt();

		System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - - \n");
		
		// MINI TASKS
		System.out.print("Enter the number of Mini Tasks: ");
		numberOfMiniTask = scan.nextInt();

		// Loop over the number of activities, first consume the first line to avoid loop problems
		scan.nextLine();
		for (int i = 1; i <= numberOfMiniTask; i++) {
			System.out.print("Enter score and max score for Mini Task #" + i + ": ");
			tempString = scan.nextLine();
			Temporary = tempString.split("/");
			totalMiniTaskScore += Integer.parseInt(Temporary[0]); // Score;
			maxMiniTaskScore += Integer.parseInt(Temporary[1]); // Max-score
		}
		System.out.println("\n  Score of Mini Tasks > " + totalMiniTaskScore + " out of " + maxMiniTaskScore);
		System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - - \n");
		
		// MAJOR TASK
		System.out.print("Enter Major Task score: ");
		totalMajorTaskScore = scan.nextInt();
		System.out.print("Enter Major Task highest possible score: ");
		maxMajorTaskScore = scan.nextInt();
		
		// Written works calculation
		WrittenWorks = (double)(totalActivityScore + totalQuizScore + PrelimScore)/(double)(maxActivityScore + maxQuizScore + 40) * 100;
		QuarterlyAssessment = (double)(PeriodicScore)/40 * 100;
		PETA = (double)(totalMiniTaskScore + totalMajorTaskScore)/(double)(maxMiniTaskScore + maxMajorTaskScore) * 100;

		System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - - ");
		System.out.println(" - - - - - - - CALCULATED GRADES - - - - - - - - ");
		System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - -\n");
		System.out.println("  Percentage Score of Written Works = " + WrittenWorks);
		System.out.println("  Percentage Score of Quarterly Assessment = " + QuarterlyAssessment);
		System.out.println("  Percentage Score of Performance Task = " + PETA);
		System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - -\n");
		System.out.println("  Weighted Score of Written Works (25%) = " + WrittenWorks * 0.25);
		System.out.println("  Weighted Score of Quarterly Assessment (30%) = " + QuarterlyAssessment * 0.30);
		System.out.println("  Weighted Score of Performance Task (45%) = " + PETA * 0.45);
		System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - -\n");
		System.out.println("   INITIAL GRADE = " + ((WrittenWorks * 0.25) + (QuarterlyAssessment * 0.30) + (PETA * 0.45)) + "%");
	}

}
