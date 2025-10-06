package org.UniversityManagement;

public class GraduateStudent  extends Student
{
    public GraduateStudent(int id, String name, double gpa) {
        super(id, name, "Graduate", gpa);
    }

    @Override
    public double getGpa() {
        return super.getGpa() * 1.1;
    }
}