/**
 * @ Aditi Selly
 * https://github.com/Adit0302/Aditi.git
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
//Class to represent a Person
class Person
  {
    private String name;
    private String id;

    public Person(String name, String id) 
    {
        this.name = name;
        this.id = id;
    }
// Getter for name
    public String getName() 
    {
        return name;
    }
 // Getter for ID
    public String getId() 
    {
        return id;
    }
}
// Class to represent a student, extending Person
class Student extends Person 
{
    private int[] marks; 
    private int totalMarks;
// Constructor to initialize Student details
    public Student(String name, String id, int[] marks) 
    {
        super(name, id);
        this.marks = marks;
        this.totalMarks = calculateTotal();
    }
// Method to calculate the total marks from the marks array
    private int calculateTotal() 
    {
        int total = 0;
        for (int mark : marks) 
        {
            total += mark;
        }
        return total;
    }

    public int getTotalMarks()
    {
        return totalMarks;
    }

    public String toString() 
    {
        return getName() + " (" + getId() + ") - Marks: [" + marks[0] + ", " + marks[1] + ", " + marks[2] + "] | Total: " + totalMarks;
    }
}

class StudentData
{
    private String unitName;
    private ArrayList<Student> students;

    public StudentData() 
    {
        students = new ArrayList<>();
    }

    // Read student data from a file
    public void loadFile(String fileName) 
    {
        try 
        {
            Scanner scanner = new Scanner(new File(fileName));
            unitName = scanner.nextLine().trim();
            while (scanner.hasNextLine()) 
            {
                String line = scanner.nextLine().trim();
                if (line.startsWith("#") || line.isEmpty()) 
                {
                    continue; 
                }

                String[] parts = line.split(",");
                String name = parts[0].trim();
                String id = parts[1].trim();
                int[] marks = new int[3];
                for (int i = 0; i < 3; i++) 
                {
                    marks[i] = Integer.parseInt(parts[i + 2].trim());
                }
                students.add(new Student(name, id, marks));
            }
            scanner.close();
            System.out.println("File loaded data successfully!");
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    // Print all students
    public void printAllStudents() 
    {
        System.out.println("Unit Name: " + unitName);
        for (Student student : students) 
        {
            System.out.println(student);
        }
    }

    // Sort students by total marks using bubble sort
    private void sortStudents() 
    {
        for (int i = 0; i < students.size() - 1; i++) 
        {
            for (int j = 0; j < students.size() - i - 1; j++) 
            {
                if (students.get(j).getTotalMarks() < students.get(j + 1).getTotalMarks()) 
                {
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
    }

    // Print students whose total marks are below a given threshold
    
    public void printTopAndBottomStudents() 
    {
    sortStudents();

    System.out.println("Top 5 Students:");
    int topLimit = students.size() < 5 ? students.size() : 5; 
    
    for (int i = 0; i < topLimit; i++) 
    {
        System.out.println(students.get(i));
    }

    System.out.println("\nBottom 5 Students:");
    int startIndex = students.size() > 5 ? students.size() - 5 : 0; 
    for (int i = startIndex; i < students.size(); i++) 
    {
        System.out.println(students.get(i));
    }
}

      // Method to print students with total marks below a threshold  
    public void printTopAndBottomThreshold(int threshold) 
    {
        System.out.println("Students with total marks below " + threshold + ":");
        for (Student student : students) 
        {
            if (student.getTotalMarks() < threshold) 
            {
                System.out.println(student);
            }
        }
    }
}

// Main class to execute the program
public class StudentStatistics1 
{
    public static void main(String[] args) 
    {
        StudentData manager = new StudentData();
        Scanner scanner = new Scanner(System.in);

        while (true) 
        {
            System.out.println("\nMenu:");
            System.out.println("1. Enter file name");
            System.out.println("2. Print all students");
            System.out.println("3. Print top and bottom 5 students");
            System.out.println("4. Print students below a threshold");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter the file name: ");
                    String fileName = scanner.next();
                    manager.loadFile(fileName);
                    break;
                case 2:
                    manager.printAllStudents();
                    break;
                case 3:
                    manager.printTopAndBottomStudents();
                    break;
                case 4:
                    System.out.print("Enter the threshold: ");
                    int threshold = scanner.nextInt();
                    manager.printTopAndBottomThreshold(threshold);
                    break;
                case 5:
                    System.out.println("Exit");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please enter again.");
            }
        }
    }
}
