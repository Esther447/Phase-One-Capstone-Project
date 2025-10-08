package org.UniversityManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CourseDAO {
    public void addCourse(Courses course) {
        String sql = "INSERT INTO courses (name, credits) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, course.getName());
            stmt.setInt(2, course.getCredits());
            stmt.executeUpdate();
            System.out.println("Course added: " + course.getName());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ return boolean instead of void
    public boolean deleteCourse(int courseId) {
        String sql = "DELETE FROM courses WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, courseId);
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;  // true if a row was deleted

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
