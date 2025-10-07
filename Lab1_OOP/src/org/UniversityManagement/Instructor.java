package org.UniversityManagement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Instructor  {
    private int id;
    private String name;
    private Set<Course> courses;

    public Instructor(int id, String name) {
        this.id = id;
        this.name = name;
        this.courses = new HashSet<>();
    }

    public void assignCourse(Course course) {
        this.courses.add(course);
    }

    public Set<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return String.format("Instructor{id=%d, name='%s', courses=%s}", id, name, courses);
    }
}