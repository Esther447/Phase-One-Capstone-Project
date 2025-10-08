package org.UniversityManagement;

public class Courses {
    private int id;
    private String name;
    private int credits;

    public Courses(int id, String name, int credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
    }

    // Getters and setters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getCredits() { return credits; }
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCredits(int credits) { this.credits = credits; }

    @Override
    public String toString() {
        return "Course{id=" + id + ", name='" + name + "', credits=" + credits + "}";
    }
}
