package org.UniversityManagement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CourseDAO {

    // ADD course to DB
    public int addCourse(Courses course) {
        String sql = "INSERT INTO courses(name, credit) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, course.getName());
            stmt.setInt(2, course.getCredit());
            stmt.executeUpdate();

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    int id = keys.getInt(1);
                    course.setId(id);
                    return id;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // GET all courses
    public List<Courses> getAllCourses() {
        List<Courses> courses = new ArrayList<>();
        String sql = "SELECT * FROM courses";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                courses.add(new Courses(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("credit"),
                        new ArrayList<>()
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    // UPDATE course
    public boolean updateCourse(Courses course) {
        String sql = "UPDATE courses SET name=?, credit=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, course.getName());
            stmt.setInt(2, course.getCredit());
            stmt.setInt(3, course.getId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // DELETE course
    public boolean deleteCourse(int id) {
        String sql = "DELETE FROM courses WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
