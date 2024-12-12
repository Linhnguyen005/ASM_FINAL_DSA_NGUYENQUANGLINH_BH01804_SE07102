package ASm;

import java.util.LinkedList;
import java.util.Queue;

public class StudentManagement {
    private MyLinkedList students = new MyLinkedList();

    // Add a new student
    public void addStudent(String id, String name, double score) {
        if (id == null || name == null || id.isEmpty() || name.isEmpty()) {
            System.out.println("Invalid input!");
            return;
        }
        students.add(new Student(id, name, score));
    }

    // Delete a student by ID
    public void deleteStudent(String id) {
        if (students.remove(id)) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found!");
        }
    }

    // Display all students
    public void displayStudents() {
        students.display();
    }

    public void sortBubble() {
        students.bubbleSort();
    }

    public void sortMerge() {
        students.mergeSort();
    }

    // Clone method to duplicate data without affecting the original
    @Override
    public StudentManagement clone() {
        StudentManagement clone = new StudentManagement();
        for (int i = 0; i < students.size(); i++) {
            Node current = students.get(i);
            clone.addStudent(current.data.id, current.data.name, current.data.score);
        }
        return clone;
    }
}