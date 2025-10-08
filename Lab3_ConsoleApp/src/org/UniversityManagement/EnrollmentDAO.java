package org.UniversityManagement;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentDAO {
    public void enrollStudent(int studentId, int courseId) {
        System.out.println("Enrolled student " + studentId + " in course " + courseId);
    }

    public List<String> getAllEnrollments() {
        // Temporary implementation (just a placeholder list)
        List<String> enrollments = new ArrayList<>();
        enrollments.add("Student 1 -> Course 101");
        enrollments.add("Student 2 -> Course 102");
        return enrollments;
    }
}
