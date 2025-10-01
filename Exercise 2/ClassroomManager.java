package manager;

import model.Classroom;
import model.Student;
import model.Assignment;
import observer.ClassroomObserver;

import java.util.*;

public class ClassroomManager {
    private static ClassroomManager instance;
    private Map<String, Classroom> classrooms;
    private List<ClassroomObserver> observers;

    private ClassroomManager() {
        classrooms = new HashMap<>();
        observers = new ArrayList<>();
    }

    public static synchronized ClassroomManager getInstance() {
        if (instance == null) instance = new ClassroomManager();
        return instance;
    }

    public void addObserver(ClassroomObserver observer) { observers.add(observer); }

    private void notifyObservers(Assignment assignment, String message) {
        for (ClassroomObserver obs : observers) obs.notify(assignment, message);
    }

    public void addClassroom(Classroom classroom) {
        if (classrooms.containsKey(classroom.getName())) {
            System.err.println("Classroom already exists.");
            return;
        }
        classrooms.put(classroom.getName(), classroom);
        System.out.println("Classroom " + classroom.getName() + " has been created.");
    }

    public void addStudent(String className, Student student) {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            System.err.println("Classroom not found.");
            return;
        }
        classroom.addStudent(student);
        System.out.println("Student " + student.getId() + " has been enrolled in " + className + ".");
    }

    public void scheduleAssignment(String className, Assignment assignment) {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            System.err.println("Classroom not found.");
            return;
        }
        classroom.addAssignment(assignment);
        System.out.println("Assignment for " + className + " has been scheduled.");
    }

    public void submitAssignment(String className, String studentId, String assignmentDetails) {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            System.err.println("Classroom not found.");
            return;
        }
        Optional<Assignment> assignment = classroom.getAssignments().stream()
                .filter(a -> a.getDetails().equals(assignmentDetails))
                .findFirst();
        if (!assignment.isPresent()) {
            System.err.println("Assignment not found.");
            return;
        }
        assignment.get().submit();
        notifyObservers(assignment.get(), "Assignment submitted by Student " + studentId + " in " + className);
        System.out.println("Assignment submitted by Student " + studentId + " in " + className + ".");
    }
}
