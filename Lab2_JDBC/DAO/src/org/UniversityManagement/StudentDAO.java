package org.UniversityManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {

    public void addStudent(Student student) {
        String sql = "INSERT INTO students (name, level, gpa) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getLevel());
            stmt.setDouble(3, student.getGpa());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteStudent(int studentId) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            int rows = stmt.executeUpdate();
            return rows > 0; // true if deleted
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateStudent(int id, String name, String level) {
        String sql = "UPDATE students SET name = ?, level = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, level);
            stmt.setInt(3, id);
            int rows = stmt.executeUpdate();
            return rows > 0; // true if updated
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
