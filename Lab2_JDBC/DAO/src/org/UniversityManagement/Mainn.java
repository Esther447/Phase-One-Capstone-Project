package org.UniversityManagement;

import java.util.ArrayList;

public class Mainn {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        CourseDAO courseDAO = new CourseDAO();
        EnrollmentDAO enrollmentDAO = new EnrollmentDAO();

        Student s1 = new Student(1,"Alice", "Undergraduate", 4);
        Student s2 = new Student(2, "Bob", "Graduate", 4);
        studentDAO.addStudent(s1);
        studentDAO.addStudent(s2);
        System.out.println("Students: " + studentDAO.getAllStudents());

        Courses c1 = new Courses(1, "Math", 3, new ArrayList<>());
        Courses c2 = new Courses(2,"Physics", 4, new ArrayList<>());
        courseDAO.addCourse(c1);
        courseDAO.addCourse(c2);
        System.out.println("Courses: " + courseDAO.getAllCourses());

        enrollmentDAO.enrollStudentInCourse(s1.getId(), c1.getId());
        enrollmentDAO.enrollStudentInCourse(s2.getId(), c2.getId());
        System.out.println("Enrollment done.");
  }
}
