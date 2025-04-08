import java.util.*;
import java.io.*;

public class GradeManager {
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Student Grade Manager ===");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Save to File");
            System.out.println("4. Load from File");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent(sc);
                case 2 -> displayStudents();
                case 3 -> saveToFile();
                case 4 -> loadFromFile();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }

    static void addStudent(Scanner sc) {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter marks: ");
        int marks = sc.nextInt();
        students.add(new Student(name, marks));
    }

    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to show.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    static void saveToFile() {
        try (PrintWriter pw = new PrintWriter("students.txt")) {
            for (Student s : students) {
                pw.println(s.name + "," + s.marks);
            }
            System.out.println("Saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    static void loadFromFile() {
        students.clear();
        try (Scanner fileScanner = new Scanner(new File("students.txt"))) {
            while (fileScanner.hasNextLine()) {
                String[] data = fileScanner.nextLine().split(",");
                students.add(new Student(data[0], Integer.parseInt(data[1])));
            }
            System.out.println("Loaded from file.");
        } catch (Exception e) {
            System.out.println("Error loading file.");
        }
    }
}
