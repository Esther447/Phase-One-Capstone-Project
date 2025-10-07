package org.UniversityManagement;

import java.util.List;

public class Courses {
    private int id;
    private String name;
    private int credit;
    private List<String> students;  // or List<Student> if you already have Student class

    public Courses(int id, String name, int credit, List<String> students) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.students = students;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getCredit() { return credit; }
    public void setCredit(int credit) { this.credit = credit; }

    public List<String> getStudents() { return students; }
    public void setStudents(List<String> students) { this.students = students; }

    @Override
    public String toString() {
        return String.format("Course{id=%d, name='%s', credit=%d}", id, name, credit);
    }
}
