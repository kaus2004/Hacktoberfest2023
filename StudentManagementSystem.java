import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int id;
    private double grade;

    public Student(String name, int id, double grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
               "name='" + name + '\'' +
               ", id=" + id +
               ", grade=" + grade +
               '}';
    }
}

public class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();
    private int studentIdCounter = 1;

    public void addStudent(String name, double grade) {
        Student student = new Student(name, studentIdCounter++, grade);
        students.add(student);
    }

    public Student findStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        boolean running = true;

        while (running) {
            System.out.println("Student Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Find Student by ID");
            System.out.println("3. Display All Students");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Student Grade: ");
                    double grade = scanner.nextDouble();
                    sms.addStudent(name, grade);
                    System.out.println("Student added.");
                    break;

                case 2:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = scanner.nextInt();
                    Student foundStudent = sms.findStudent(searchId);
                    if (foundStudent != null) {
                        System.out.println("Student Found: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.println("All Students:");
                    sms.displayAllStudents();
                    break;

                case 4:
                    System.out.println("Exiting Student Management System.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
