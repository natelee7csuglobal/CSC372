package student;

import java.util.ArrayList;
import java.util.Comparator;

public class StudentSort {

    // Comparator to sort students by name
    static class NameComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.getName().compareTo(s2.getName());
        }
    }

    // Comparator to sort students by roll number
    static class RollnoComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return Integer.compare(s1.getRollno(), s2.getRollno());
        }
    }

    // Selection sort method
    public static void selectionSort(ArrayList<Student> students, Comparator<Student> comparator) {
        int n = students.size();
        
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(students.get(j), students.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            Student temp = students.get(minIndex);
            students.set(minIndex, students.get(i));
            students.set(i, temp);
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        // Add 10 student objects
        students.add(new Student(1, "Berny", "123 Main St"));
        students.add(new Student(2, "Bob", "456 Maple St"));
        students.add(new Student(3, "Charlie", "789 Oak St"));
        students.add(new Student(4, "Don", "321 Pine St"));
        students.add(new Student(5, "Dale", "654 Elm St"));
        students.add(new Student(6, "Frank", "987 Cedar St"));
        students.add(new Student(7, "Grace", "213 Birch St"));
        students.add(new Student(8, "Hannah", "546 Spruce St"));
        students.add(new Student(9, "Ian", "879 Aspen St"));
        students.add(new Student(10, "Isacc", "132 Cherry St"));

        // Sort by name
        selectionSort(students, new NameComparator());
        System.out.println("Sorted by name:");
        for (Student s : students) {
            System.out.println(s.getRollno() + " " + s.getName() + " " + s.getAddress());
        }

        // Sort by roll number
        selectionSort(students, new RollnoComparator());
        System.out.println("Sorted by roll number:");
        for (Student s : students) {
            System.out.println(s.getRollno() + " " + s.getName() + " " + s.getAddress());
        }
    }
}
