package module8;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StudentDataEntry {
    public static void main(String[] args) {
        LinkedList<Student> studentList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        String choice;

        // Create a loop to gather student data
        do {
            System.out.print("Enter student's name: ");
            String name = scanner.nextLine();

            System.out.print("Enter student's address: ");
            String address = scanner.nextLine();

            double GPA = -1;
            // Create a loop to validate GPA input
            while (true) {
                System.out.print("Enter student's GPA (0.0 - 4.0): ");
                if (scanner.hasNextDouble()) {
                    GPA = scanner.nextDouble();
                    if (GPA >= 0.0 && GPA <= 4.0) {
                        break; // Valid input check
                    } else {
                        System.out.println("Please enter a valid GPA between 0.0 and 4.0.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a numeric value for GPA.");
                }
                scanner.nextLine(); // This will clear the invalid input
            }
            scanner.nextLine(); // This will clear the buffer

            Student student = new Student(name, address, GPA);
            studentList.add(student);
            
            System.out.print("Add another student? (yes/no): ");
            choice = scanner.nextLine();
        } while (choice.equalsIgnoreCase("yes"));

        // Sort the linked list by student names here
        studentList.sort((s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()));

        // Write the student data to a text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"))) {
            for (Student student : studentList) {
                writer.write(student.toString());
                writer.newLine();
            }
            System.out.println("Student data has been written to students.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }

        scanner.close();
    }
}