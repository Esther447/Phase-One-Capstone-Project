package org.UniversityManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnrollmentDAO {

    public boolean enrollStudentInCourse(int studentId, int courseId) {
        String sql = "INSERT INTO enrollments(student_id, course_id) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error enrolling student: " + e.getMessage());
        }
        return false;
    }
}
