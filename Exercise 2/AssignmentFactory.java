package factory;

import model.Assignment;

public class AssignmentFactory {
    public static Assignment createAssignment(String details) {
        return new Assignment(details);
    }
}
