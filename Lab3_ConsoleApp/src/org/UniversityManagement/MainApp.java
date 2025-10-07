package org.UniversityManagement;

import java.util.Scanner;

public class MainApp {
    private static final StudentDAO studentDAO = new StudentDAO();
    private static final CourseDAO courseDAO = new CourseDAO();
    private static final EnrollmentDAO enrollmentDAO = new EnrollmentDAO();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== University Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Add Course");
            System.out.println("4. Remove Course");
            System.out.println("5. Enroll Student in Course");
            System.out.println("6. View Enrollments");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> addStudent(scanner);
                    case 2 -> removeStudent(scanner);
                    case 3 -> addCourse(scanner);
                    case 4 -> removeCourse(scanner);
                    case 5 -> enrollStudent(scanner);
                    case 6 -> viewEnrollments();
                    case 7 -> running = false;
                    default -> System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("⚠️ Error: " + e.getMessage());
            }
        }
    }

    private static void addStudent(Scanner sc) {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter level: ");
        String level = sc.nextLine();

        Student student = new Student(0, name, level, 0.0);
        studentDAO.addStudent(student);
        System.out.println("✅ Student added: " + student);
    }

    private static void removeStudent(Scanner sc) {
        System.out.print("Enter student ID to remove: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean success = studentDAO.deleteStudent(id);
        System.out.println(success ? "✅ Student removed." : "❌ Student not found.");
    }

    private static void addCourse(Scanner sc) {
        System.out.print("Enter course name: ");
        String name = sc.nextLine();
        System.out.print("Enter course credit: ");
        int credit = Integer.parseInt(sc.nextLine());

        Courses course = new Courses(0, name, credit, new java.util.ArrayList<>());
        courseDAO.addCourse(course);
        System.out.println("✅ Course added: " + course);
    }

    private static void removeCourse(Scanner sc) {
        System.out.print("Enter course ID to remove: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean success = courseDAO.deleteCourse(id);
        System.out.println(success ? "✅ Course removed." : "❌ Course not found.");
    }

    private static void enrollStudent(Scanner sc) {
        System.out.print("Enter student ID: ");
        int studentId = Integer.parseInt(sc.nextLine());
        System.out.print("Enter course ID: ");
        int courseId = Integer.parseInt(sc.nextLine());

        enrollmentDAO.enrollStudent(studentId, courseId);
        System.out.println("✅ Enrollment complete.");
    }

    private static void viewEnrollments() {
        var list = enrollmentDAO.getAllEnrollments();
        if (list.isEmpty()) {
            System.out.println("No enrollments yet.");
        } else {
            list.forEach(System.out::println);
        }
    }
}

