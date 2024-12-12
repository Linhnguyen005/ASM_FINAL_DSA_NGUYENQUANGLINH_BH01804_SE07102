package ASm;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagement management = new StudentManagement();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Menu-driven approach
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display Students");
            System.out.println("5. Sort by Score (Bubble Sort)");
            System.out.println("6. Sort by Score (Merge Sort)");
            System.out.println("7. Add Random Students");
            System.out.println("8. Compare Sorting Times");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Student Score: ");
                    double score = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    management.addStudent(id, name, score);
                    break;
                case 2:
                    System.out.print("Enter Student ID to edit: ");
                    String editId = scanner.nextLine();
                    System.out.print("Enter new Student Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new Student Score: ");
                    double newScore = scanner.nextDouble();
                    scanner.nextLine();
                    management.deleteStudent(editId);
                    management.addStudent(editId, newName, newScore);
                    break;
                case 3:
                    System.out.print("Enter Student ID to delete: ");
                    String deleteId = scanner.nextLine();
                    management.deleteStudent(deleteId);
                    break;
                case 4:
                    management.displayStudents();
                    break;
                case 5:
                    management.sortBubble();
                    System.out.println("Students sorted by Bubble Sort.");
                    break;
                case 6:
                    management.sortMerge();
                    System.out.println("Students sorted by Merge Sort.");
                    break;
                case 7:
                    System.out.print("Enter the number of random students to add: ");
                    int count = scanner.nextInt();
                    addRandomStudents(management, count, random);
                    break;
                case 8:
                    compareSortingTimesWithClone(management);
                    break;
                case 9:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to add random students
    private static void addRandomStudents(StudentManagement management, int count, Random random) {
        for (int i = 0; i < count; i++) {
            String id = "ID" + (i + 1);
            String name = "Student" + (i + 1);
            double score = 50 + random.nextDouble() * 50; // Random score between 50 and 100
            management.addStudent(id, name, score);
        }
        System.out.println(count + " random students added.");
    }

    // Method to compare sorting times using cloned data
    private static void compareSortingTimesWithClone(StudentManagement management) {
        long startTime, endTime;

        // Clone data for Bubble Sort
        StudentManagement bubbleClone = management.clone();
        startTime = System.nanoTime();
        bubbleClone.sortBubble();
        endTime = System.nanoTime();
        System.out.println("Bubble Sort time: " + (endTime - startTime) + " ns");

        // Clone data for Merge Sort
        StudentManagement mergeClone = management.clone();
        startTime = System.nanoTime();
        mergeClone.sortMerge();
        endTime = System.nanoTime();
        System.out.println("Merge Sort time: " + (endTime - startTime) + " ns");

    }
}
