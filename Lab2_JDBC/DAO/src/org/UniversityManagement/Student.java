package org.UniversityManagement;

public class Student {
    private int id;
    private String name;
    private String level;
    private double gpa;


    public Student(int id, String name, String level, double gpa) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.gpa = gpa;
    }

    public Student(String name, String level, double gpa) {
        this(0, name, level, gpa);
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }

    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }


    public double calculateGPA() {
        return gpa;
    }

    @Override
    public String toString() {
        return String.format("Student{id=%d, name='%s', level='%s', gpa=%.2f}", id, name, level, gpa);
    }
}
