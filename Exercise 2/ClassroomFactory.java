package factory;

import model.Classroom;

public class ClassroomFactory {
    public static Classroom createClassroom(String name) {
        return new Classroom(name);
    }
}
