package org.UniversityManagement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class course {
    private int id;
    private String name;
    private int credit;
    private List<Student> enrolledStudents;

    public course(int id, String name, int credit, List<Student> enrolledStudents) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.enrolledStudents = new ArrayList<>();

    }
    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    @Override
    public String toString() {
        return String.format("Course{id=%d, name='%s, credit=%d, Students=%d}", id, name, credit, enrolledStudents.size());
    }
}
