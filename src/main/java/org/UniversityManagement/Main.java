package org.UniversityManagement;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Students
        Student s1 = new UndergraduateStudent(1, "Alice", 3.5);
        Student s2 = new GraduateStudent(2, "Bob", 3.8);

        // Course
        course javaCourse = new course(101, "Intro to Java", 4, new ArrayList<>());
        javaCourse.enrollStudent(s1);
        javaCourse.enrollStudent(s2);

        // Instructor
        Instructor prof = new Instructor(201, "Dr. Smith");
        prof.assignCourse(javaCourse);

        // --- Collections in action ---
        // List → ordered students
        List<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);

        // Set → unique courses
        Set<course> courseSet = new HashSet<>();
        courseSet.add(javaCourse);

        // Map → studentId → Student
        Map<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(s1.getId(), s1);
        studentMap.put(s2.getId(), s2);

        // Print results
        System.out.println("Student List: " + studentList);
        System.out.println("Course Set: " + courseSet);
        System.out.println("Student Map: " + studentMap);
        System.out.println("Professor: " + prof);
    }
}
