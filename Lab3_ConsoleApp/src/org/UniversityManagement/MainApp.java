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
            System.out.println("3. Update Student");
            System.out.println("4. View All Students");
            System.out.println("5. Add Course");
            System.out.println("6. Remove Course");
            System.out.println("7. Update Course");
            System.out.println("8. View All Courses");
            System.out.println("9. Enroll Student in Course");
            System.out.println("10. View Enrollments");
            System.out.println("11. Exit");
            System.out.print("Choose option: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> addStudent(scanner);
                    case 2 -> removeStudent(scanner);
                    case 3 -> updateStudent(scanner);
                    case 4 -> viewAllStudents();
                    case 5 -> addCourse(scanner);
                    case 6 -> removeCourse(scanner);
                    case 7 -> updateCourse(scanner);
                    case 8 -> viewAllCourses();
                    case 9 -> enrollStudent(scanner);
                    case 10 -> viewEnrollments();
                    case 11 -> running = false;
                    default -> System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println(" Error: " + e.getMessage());
            }
        }
    }

    // === Student operations ===
    private static void addStudent(Scanner sc) {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter level: ");
        String level = sc.nextLine();

        Student student = new Student(0, name, level, 0.0);
        studentDAO.addStudent(student);
        System.out.println("Student added: " + student);
    }

    private static void removeStudent(Scanner sc) {
        System.out.print("Enter student ID to remove: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean success = studentDAO.deleteStudent(id);
        System.out.println(success ? "Student removed." : " Student not found.");
    }

    private static void updateStudent(Scanner sc) {
        System.out.print("Enter student ID to update: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter new name: ");
        String name = sc.nextLine();
        System.out.print("Enter new level: ");
        String level = sc.nextLine();

        boolean success = studentDAO.updateStudent(id, name, level);
        System.out.println(success ? "Student updated." : " Student not found.");
    }

    private static void viewAllStudents() {
        var students = studentDAO.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            students.forEach(System.out::println);
        }
    }

    // === Course operations ===
    private static void addCourse(Scanner sc) {
        System.out.print("Enter course name: ");
        String name = sc.nextLine();
        System.out.print("Enter course credit: ");
        int credit = Integer.parseInt(sc.nextLine());

        Courses course = new Courses(0, name, credit);
        courseDAO.addCourse(course);
        System.out.println(" Course added: " + course);
    }

    private static void removeCourse(Scanner sc) {
        System.out.print("Enter course ID to remove: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean success = courseDAO.removeCourse(id);
        System.out.println(success ? " Course removed." : " Course not found.");
    }

    private static void updateCourse(Scanner sc) {
        System.out.print("Enter course ID to update: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter new name: ");
        String name = sc.nextLine();
        System.out.print("Enter new credit: ");
        int credits = Integer.parseInt(sc.nextLine());

        boolean success = courseDAO.updateCourse(id, name, credits);
        System.out.println(success ? " Course updated." : " Course not found.");
    }

    private static void viewAllCourses() {
        var courses = courseDAO.getAllCourses();
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
        } else {
            courses.forEach(System.out::println);
        }
    }

    // === Enrollment operations ===
    private static void enrollStudent(Scanner sc) {
        System.out.print("Enter student ID: ");
        int studentId = Integer.parseInt(sc.nextLine());
        System.out.print("Enter course ID: ");
        int courseId = Integer.parseInt(sc.nextLine());

        enrollmentDAO.enrollStudent(studentId, courseId);
        System.out.println(" Enrollment complete.");
    }

    private static void viewEnrollments() {
        var enrollments = enrollmentDAO.getAllEnrollments();
        if (enrollments.isEmpty()) {
            System.out.println("No enrollments yet.");
        } else {
            enrollments.forEach(System.out::println);
        }
    }
}