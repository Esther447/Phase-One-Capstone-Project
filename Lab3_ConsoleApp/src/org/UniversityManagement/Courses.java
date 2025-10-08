package org.UniversityManagement;

import java.util.List;

public class Courses {
    private int id;
    private String name;
    private int credits;
    private List<String> students;  // or maybe List<Student> depending on your design

    public Courses(int id, String name, int credits, List<String> students) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.students = students;
    }

    // ✅ Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {   // <-- this one was missing
        return credits;
    }

    public List<String> getStudents() {
        return students;
    }

    // ✅ Setters (optional, if you need to update values later)
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setStudents(List<String> students) {
        this.students = students;
    }
}
