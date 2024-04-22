import java.util.ArrayList;
import java.util.Scanner;

public class ToDoApp {
    private final ArrayList<String> tasks = new ArrayList<>();
    private final Scanner shri = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("To-Do App");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Remove Task");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    public void addTask() {
        System.out.print("Enter task description: ");
        String task = shri.nextLine();
        tasks.add(task);
        System.out.println("Task added.");
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
            return;
        }
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public void removeTask() {
        viewTasks();
        System.out.print("Enter task number to remove: ");
        int index = shri.nextInt() - 1;
        shri.nextLine(); 
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task removed.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void run() {
        int choice;
        do {
            displayMenu();
            choice = shri.nextInt();
            shri.nextLine(); 
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    removeTask();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);
    }

    public static void main(String[] args) {
        new ToDoApp().run();
    }
}