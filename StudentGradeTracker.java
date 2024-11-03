/*
This Java program, StudentGradeTracker, allows users to input student grades, calculates the average grade, and finds the highest and lowest scores among the entered grades.

> How the Program Works
1.Collecting Grades:
The program uses a loop to collect grades from the user until they type "done".
Each input is parsed into an integer and added to an ArrayList<Integer> called grades.
If the input is not a valid integer, the program catches a NumberFormatException and prompts the user to enter a valid number.

2.Outputting Results:
If no grades are entered, the program notifies the user with "No grades were entered."
Otherwise, it displays:
The list of grades entered.
The average grade, calculated by the calculateAverage method.
The highest score, calculated by the findHighestScore method.
The lowest score, calculated by the findLowestScore method.
> Explanation of Helper Methods :
• calculateAverage:
Computes the sum of all grades in the grades list and divides it by the number of grades to find the average.
Returns a double for more precise results.
• findHighestScore:
Iterates through the list to find the highest grade by comparing each grade to the current highest.
findLowestScore:
Iterates through the list to find the lowest grade by comparing each grade to the current lowest.

/* ------------------------------------------------------------------------------------------------------------------------------------------------- */
> Example Usage
Here’s an example interaction with the program:
Enter student grades (or type 'done' to finish):
85
90
78
92
done
Grades entered: [85, 90, 78, 92]
Average grade: 86.25
Highest Score: 92
Lowest Score: 78
*/

/* -------------------------------------------------------------------------------------------------------------------------------------------------- */
                                                                      Full Program Code
/* -------------------------------------------------------------------------------------------------------------------------------------------------- */
import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();
        String input;
        
        System.out.println("Enter student grades (or type 'done' to finish):");
        
        // Loop to collect grades from user input
        while (true) {
            input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            
            try {
                int grade = Integer.parseInt(input);
                grades.add(grade);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number or 'done' to finish.");
            }
        }
        
        if (grades.isEmpty()) {
            System.out.println("No grades were entered.");
        } else {
            System.out.println("Grades entered: " + grades);
            System.out.println("Average grade: " + calculateAverage(grades));
            System.out.println("Highest Score: " + findHighestScore(grades));
            System.out.println("Lowest Score: " + findLowestScore(grades));
        }
        
        scanner.close();
    }

    // Method to calculate the average Score
    public static double calculateAverage(ArrayList<Integer> grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / (double) grades.size();
    }

    // Method to find the highest grade
    public static int findHighestScore(ArrayList<Integer> grades) {
        int highest = grades.get(0);
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    // Method to find the lowest Score
    public static int findLowestScore(ArrayList<Integer> grades) {
        int lowest = grades.get(0);
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
}
/* -------------------------------------------------------------------------------------------------------------------------------------------------- */
To run this Java program, you can follow these steps:

• Save the code in a file named - StudentGradeTracker.java.

• Open a terminal or command prompt and navigate to the directory where the file is saved.

• Compile the program using the javac command:
        > javac StudentGradeTracker.java

• This will compile the Java file and generate a StudentGradeTracker.class file if there are no errors.

• Run the compiled program using the java command:
        > java StudentGradeTracker
• After running the program, it will prompt you to enter student grades.