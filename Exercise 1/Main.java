import factory.TaskFactory;
import manager.ScheduleManager;
import model.Task;
import observer.ConflictNotifier;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ScheduleManager manager = ScheduleManager.getInstance();
        manager.addObserver(new ConflictNotifier());

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Add Task\n2. Remove Task\n3. View Tasks\n4. Exit");
            System.out.print("Enter choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Description: "); String desc = sc.nextLine();
                    System.out.print("Start Time (HH:mm): "); String start = sc.nextLine();
                    System.out.print("End Time (HH:mm): "); String end = sc.nextLine();
                    System.out.print("Priority (High/Medium/Low): "); String priority = sc.nextLine();
                    try {
                        Task task = TaskFactory.createTask(desc, start, end, priority);
                        manager.addTask(task);
                    } catch (Exception e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                    break;
                case "2":
                    System.out.print("Description: "); 
                    manager.removeTask(sc.nextLine());
                    break;
                case "3":
                    manager.viewTasks();
                    break;
                case "4":
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.err.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
