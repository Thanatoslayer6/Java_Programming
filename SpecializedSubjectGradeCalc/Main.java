import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Instantiate scanner class
		Scanner scan = new Scanner(System.in);
		
		// Declare and initialize necessary variables with the right types
        int numberOfWorks, highestPossibleScore, totalScore = 0;
		double PS_WrittenWorks, PS_QuarterlyAssessment, PS_Peta;
		
		// ASCII BANNER
		System.out.println(""
				+ "+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n"
				+ "|/                                 \\|\n"
				+ "|     ~ Specialized Subject ~       |\n"
				+ "|        -  Grade Calculator  -     |\n"
				+ "|\\                                 /|\n"
				+ "+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n");

		// WRITTEN WORKS (Act sheets, quizzes, prelim)
		System.out.print("<> Enter the number of Written Works: ");
        numberOfWorks = scan.nextInt();
        System.out.print("<> Enter the highest possible score for all Written Works: ");
        highestPossibleScore = scan.nextInt();

		// Loop over the number of activities, first consume the first line to avoid loop problems
		for (int i = 1; i <= numberOfWorks; i++) {
			System.out.print("<--> Enter score for Written Work #" + i + ": ");
			totalScore += scan.nextInt(); // Score;
		}

        // Calculate the Percentage score of Written Works...
        PS_WrittenWorks = (double)(totalScore)/highestPossibleScore * 100;

		System.out.println("\n  Score of Written Works > " + totalScore + " out of " + highestPossibleScore);
		System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - - \n");
       
        // Reset variable
        totalScore = 0;
        // PERFORMANCE TASK
		System.out.print("<> Enter the number of Performance Tasks: ");
        numberOfWorks = scan.nextInt();
        System.out.print("<> Enter the highest possible score for all Performance Tasks: ");
        highestPossibleScore = scan.nextInt();
        
		// Loop over the number of activities, first consume the first line to avoid loop problems
		for (int i = 1; i <= numberOfWorks; i++) {
			System.out.print("<--> Enter score for Performance Task #" + i + ": ");
			totalScore += scan.nextInt(); // Score;
		}
        // Calculate the Percentage score of Peta
        PS_Peta = (double)(totalScore)/highestPossibleScore * 100;

		System.out.println("\n  Score of Performance Tasks > " + totalScore + " out of " + highestPossibleScore);
		System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - - \n");
		// QUARTERLY ASSESSMENT
		System.out.print("<> Enter the score of your Quarterly Assessment (out of 40): ");
		totalScore = scan.nextInt();
        // Calculate the Percentage score of Quarterly Assessment
        PS_QuarterlyAssessment = (double)(totalScore)/40 * 100;

		System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - - ");
		System.out.println(" - - - - - - - CALCULATED GRADES - - - - - - - - ");
		System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - -\n");
		System.out.println("  Percentage Score of Written Works = " + PS_WrittenWorks);
		System.out.println("  Percentage Score of Quarterly Assessment = " + PS_QuarterlyAssessment);
		System.out.println("  Percentage Score of Performance Task = " + PS_Peta);
		System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - -\n");
		System.out.println("  Weighted Score of Written Works (25%) = " + PS_WrittenWorks * 0.25);
		System.out.println("  Weighted Score of Quarterly Assessment (30%) = " + PS_QuarterlyAssessment * 0.30);
		System.out.println("  Weighted Score of Performance Task (45%) = " + PS_Peta * 0.45);
		System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - -\n");
		System.out.println("   Initial Grade = " + ((PS_WrittenWorks * 0.25) + (PS_QuarterlyAssessment * 0.30) + (PS_Peta * 0.45)) + "%");
		System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - -\n");
	}

}
