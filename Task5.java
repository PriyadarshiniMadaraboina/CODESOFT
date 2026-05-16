import java.io.*;
import java.util.*;

// Student Class
class Student implements Serializable {

    private int rollNumber;
    private String name;
    private String grade;

    // Constructor
    public Student(int rollNumber, String name, String grade) {

        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
    }

    // Getters
    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Display
    @Override
    public String toString() {

        return "Roll Number: " + rollNumber +
                ", Name: " + name +
                ", Grade: " + grade;
    }
}

// Student Management System
class StudentManagementSystem {

    private ArrayList<Student> students =
            new ArrayList<>();

    // Add Student
    public void addStudent(Student s) {

        students.add(s);

        System.out.println("Student Added Successfully.");
    }

    // Remove Student
    public void removeStudent(int rollNumber) {

        Iterator<Student> iterator =
                students.iterator();

        while (iterator.hasNext()) {

            Student s = iterator.next();

            if (s.getRollNumber() == rollNumber) {

                iterator.remove();

                System.out.println("Student Removed.");
                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    // Search Student
    public void searchStudent(int rollNumber) {

        for (Student s : students) {

            if (s.getRollNumber() == rollNumber) {

                System.out.println("\nStudent Found:");
                System.out.println(s);

                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    // Display All Students
    public void displayStudents() {

        if (students.isEmpty()) {

            System.out.println("No Students Available.");
            return;
        }

        System.out.println("\n===== STUDENT LIST =====");

        for (Student s : students) {

            System.out.println(s);
        }
    }

    // Edit Student
    public void editStudent(
            int rollNumber,
            String newName,
            String newGrade) {

        for (Student s : students) {

            if (s.getRollNumber() == rollNumber) {

                s.setName(newName);
                s.setGrade(newGrade);

                System.out.println("Student Updated.");

                return;
            }
        }

        System.out.println("Student Not Found.");
    }
}

// Main Class
public class Task5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentManagementSystem sms =
                new StudentManagementSystem();

        int choice;

        do {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Edit Student");
            System.out.println("6. Exit");

            System.out.print("Enter Your Choice: ");

            choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Roll Number: ");
                    int roll = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Grade: ");
                    String grade = scanner.nextLine();

                    if (name.isEmpty() || grade.isEmpty()) {

                        System.out.println("Fields Cannot Be Empty.");
                    }
                    else {

                        Student s =
                                new Student(roll, name, grade);

                        sms.addStudent(s);
                    }

                    break;

                case 2:

                    System.out.print(
                            "Enter Roll Number to Remove: ");

                    int removeRoll = scanner.nextInt();

                    sms.removeStudent(removeRoll);

                    break;

                case 3:

                    System.out.print(
                            "Enter Roll Number to Search: ");

                    int searchRoll = scanner.nextInt();

                    sms.searchStudent(searchRoll);

                    break;

                case 4:

                    sms.displayStudents();

                    break;

                case 5:

                    System.out.print(
                            "Enter Roll Number to Edit: ");

                    int editRoll = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter New Grade: ");
                    String newGrade = scanner.nextLine();

                    sms.editStudent(
                            editRoll,
                            newName,
                            newGrade);

                    break;

                case 6:

                    System.out.println("Exiting...");
                    break;

                default:

                    System.out.println("Invalid Choice.");
            }

        } while (choice != 6);

        scanner.close();
    }
}