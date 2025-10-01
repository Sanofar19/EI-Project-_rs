package observer;

import model.Assignment;

public interface ClassroomObserver {
    void notify(Assignment assignment, String message);
}

package observer;

import model.Assignment;

public class SubmissionNotifier implements ClassroomObserver {
    @Override
    public void notify(Assignment assignment, String message) {
        System.out.println("NOTIFICATION: " + message + " - " + assignment.getDetails());
    }
}
