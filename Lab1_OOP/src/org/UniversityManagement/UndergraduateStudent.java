package org.UniversityManagement;

public class UndergraduateStudent extends Student {
    public UndergraduateStudent(int id, String name, double gpa) {
        super(id, name, "undergraduate", gpa);
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}