import java.util.Scanner;

public class MarksCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the number of subjects
        System.out.print("Enter the number of subjects you are enrolled in: ");
        int subjects = scanner.nextInt();
        
        int sumOfMarks = 0;

        // Collect marks for each subject and calculate the total marks
        for (int subjectIndex = 1; subjectIndex <= subjects; subjectIndex++) {
            System.out.print("Input the marks for subject " + subjectIndex + ": ");
            int marksObtained = scanner.nextInt();
            sumOfMarks += marksObtained;  // Accumulate the marks
        }

        // Calculate the average percentage from the total marks
        int percentageAverage = sumOfMarks / subjects;

        // Assign a grade based on the calculated average percentage
        String studentGrade;
        if (percentageAverage >= 90 && percentageAverage <= 100) {
            studentGrade = "A";
        } else if (percentageAverage >= 80 && percentageAverage < 90) {
            studentGrade = "B";
        } else if (percentageAverage >= 70 && percentageAverage < 80) {
            studentGrade = "C";
        } else if (percentageAverage >= 60 && percentageAverage < 70) {
            studentGrade = "D";
        } else {
            studentGrade = "F";
        }

        // Output the results to the user
        System.out.println("\nYour Results:");
        System.out.println("Total Marks: " + sumOfMarks + "/" + (subjects * 100));
        System.out.println("Average Percentage: " + percentageAverage + "%");
        System.out.println("Grade: " + studentGrade);

        // Close the scanner to release resources
        scanner.close();
    }
}
