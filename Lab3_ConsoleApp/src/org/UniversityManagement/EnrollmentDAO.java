package org.UniversityManagement;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentDAO {
    private final List<String> enrollments = new ArrayList<>();

    public void enrollStudent(int studentId, int courseId) {
        String record = "Student " + studentId + " -> Course " + courseId;
        enrollments.add(record);
        System.out.println("Enrolled student " + studentId + " in course " + courseId);
    }

    public void updateEnrollment(int enrollmentIndex, int newCourseId) {
        if (enrollmentIndex >= 0 && enrollmentIndex < enrollments.size()) {
            String[] parts = enrollments.get(enrollmentIndex).split(" -> ");
            String studentPart = parts[0];
            enrollments.set(enrollmentIndex, studentPart + " -> Course " + newCourseId);
            System.out.println("Enrollment updated.");
        } else {
            System.out.println("Enrollment not found.");
        }
    }

    public List<String> getAllEnrollments() {
        return new ArrayList<>(enrollments);
    }
}
