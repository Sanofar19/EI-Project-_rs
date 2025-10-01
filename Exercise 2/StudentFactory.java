package factory;

import model.Student;

public class StudentFactory {
    public static Student createStudent(String id) {
        return new Student(id);
    }
}
