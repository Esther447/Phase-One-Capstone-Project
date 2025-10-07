package org.UniversityManagement;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Student s1 = new UndergraduateStudent(1, "Alice", 3.5);
        Student s2 = new GraduateStudent(2, "Bob", 3.8);

        Course javacourse = new Course(101, "Intro to Java", 4, new ArrayList<>());
        javacourse.enrollStudent(s1);
        javacourse.enrollStudent(s2);

        Instructor prof = new Instructor(201, "Dr. Smith");
        prof.assignCourse(javacourse);

        List<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);

        Set<Course> courseSet = new HashSet<>();
        courseSet.add(javacourse);

        Map<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(s1.getId(), s1);
        studentMap.put(s2.getId(), s2);

        System.out.println("Student List: " + studentList);
        System.out.println("Course Set: " + courseSet);
        System.out.println("Student Map: " + studentMap);
        System.out.println("Professor: " + prof);
    }
}
