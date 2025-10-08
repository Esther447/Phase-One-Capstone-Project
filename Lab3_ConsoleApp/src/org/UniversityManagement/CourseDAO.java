package org.UniversityManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

import org.UniversityManagement.Courses;       // your Courses class
import org.UniversityManagement.DatabaseConnection; // your DB connection helper


public class CourseDAO {

    public void addCourse(Courses course) {
        String sql = "INSERT INTO courses (name, credits) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, course.getName());
            stmt.setInt(2, course.getCredits());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean removeCourse(int courseId) {
        String sql = "DELETE FROM courses WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, courseId);
            int rows = stmt.executeUpdate();
            return rows > 0; // true if course deleted
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateCourse(int id, String name, int credits) {
        String sql = "UPDATE courses SET name = ?, credits = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, credits);
            stmt.setInt(3, id);
            int rows = stmt.executeUpdate();
            return rows > 0; // true if course updated
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Courses> getAllCourses() {
        List<Courses> courses = new ArrayList<>();
        String sql = "SELECT * FROM courses";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Courses c = new Courses(rs.getInt("id"), rs.getString("name"), rs.getInt("credits"));
                courses.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses; // ✅ Must return the list
    }
}