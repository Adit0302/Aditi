package Prog5001;


/**
 * Write a description of class StudentMarksStatistics here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Scanner;

public class StudentMarksStatistics {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Step 1: Input assignment name
        System.out.print("Enter the assignment name: ");
        String assignmentName = scanner.nextLine();
        
        // Step 2: Input and validate marks for 30 students
        ArrayList<Double> marks = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            double mark = getValidMark(scanner, i);
            marks.add(mark);
        }
        
        // Step 3: Print assignment name and marks
        System.out.println("\nAssignment: " + assignmentName);
        System.out.println("Student Marks:");
        for (int i = 0; i < marks.size(); i++) {
            System.out.println("Student " + (i + 1) + ": " + marks.get(i));
        }
        
        // Step 4: Use bubble sort to sort the marks
        Bsort.bSort(marks);
        
        // Step 5: Print minimum and maximum marks
        double minMark = marks.get(0); // Minimum mark after sorting
        double maxMark = marks.get(marks.size() - 1); // Maximum mark after sorting
        System.out.println("\nHighest mark: " + maxMark);
        System.out.println("Lowest mark: " + minMark);
        
        // Step 6: Compute and print mean and standard deviation
        double mean = Compute.mean(marks);
        double stdDeviation = Compute.standardDeviation(marks, mean);
        System.out.println("Average mark: " + mean);
        System.out.println("Standard deviation: " + stdDeviation);
        
        scanner.close();
    }
    
    // Method to get a valid mark from the user
    private static double getValidMark(Scanner scanner, int studentNumber) {
        while (true) {
            System.out.print("Enter mark for student " + studentNumber + " (0 - 30): ");
            if (scanner.hasNextDouble()) {
                double mark = scanner.nextDouble();
                if (mark >= 0 && mark <= 30) {
                    return mark;
                } else {
                    System.out.println("Invalid input. Mark must be between 0 and 30.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }
    }


    
    
}