import java.time.DateTimeException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;

public class App {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean shouldContinue = true;
        while(shouldContinue) {
            int userChoice1 = 0;
            displayMainMenu();
            try {
                userChoice1 = in.nextInt();
                switch (userChoice1) {
                    case 1:
                        TaskList taskList = new TaskList();
                        boolean continueListOperations = true;
                        System.out.println("New task list has been created.");
                        while (continueListOperations) {
                            int userChoice2 = 0;
                            displayListOperationMenu();
                            try {
                                userChoice2 = in.nextInt();
                                in.nextLine();
                                switch (userChoice2) {
                                    case 1:
                                        System.out.println("Current Tasks");
                                        System.out.println("-------------");
                                        printTasks(taskList);
                                        break;
                                    case 2:
                                        addTaskToList(taskList);
                                        break;
                                    case 3:
                                        break;
                                    case 4:
                                        break;
                                    case 5:
                                        break;
                                    case 6:
                                        break;
                                    case 7:
                                        break;
                                    case 8:
                                        continueListOperations = false;
                                        break;
                                }
                            }
                            catch (IllegalArgumentException e) {
                                System.out.println("WARNING: Numbers 1 through 8 are the only valid options.");
                            }
                            catch (InputMismatchException e) {
                                System.out.println("WARNING: You must only enter integers 1 through 8 to make your choice.");
                            }
                            finally {
                                in.nextLine();
                            }
                        }
                        break;
                    case 2:

                        break;
                    case 3:
                        shouldContinue = false;
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
            catch(IllegalArgumentException e) {
                System.out.println("WARNING: Numbers 1, 2, or 3 are the only valid options.");
            }
            catch(InputMismatchException e) {
                System.out.println("WARNING: You must only enter integers 1, 2, or 3 to make your choice.");
            }
            finally {
                in.nextLine();
            }
        }
    }

    private static void displayMainMenu() {
        System.out.printf("Main Menu%n" +
                "---------%n%n" +
                "1) Create a new list%n" +
                "2) Load an existing list%n" +
                "3) Quit%n%n" +
                "> ");
    }

    private static void displayListOperationMenu() {
        System.out.printf("List Operation Menu%n" +
                "---------%n%n" +
                "1) View the list%n" +
                "2) Add an item%n" +
                "3) Edit an item%n" +
                "4) Remove an item%n" +
                "5) Mark an item as complete%n" +
                "6) Unmark an item as complete%n" +
                "7) Save the current list%n" +
                "8) Quit to the main menu%n%n" +
                "> ");
    }

    private static TaskList addTaskToList(TaskList tasks) {
        System.out.print("Task title: ");
        String userTitle = in.nextLine();
        System.out.print("Task description: ");
        String userDesc = in.nextLine();
        System.out.print("Task due date (YYYY-MM-DD): ");
        String userDate = in.nextLine();
        try {
            TaskItem task = new TaskItem();
            task.setTitle(userTitle);
            task.setDesc(userDesc);
            task.setDueDate(userDate);
            tasks.addTask(task);
        }
        catch (IllegalArgumentException illegalTitle) {
            System.out.println("WARNING: Title must contain one or more characters. Task not created.");
        }
        catch (DateTimeException illegalDate) {
            System.out.println("WARNING: Invalid due date. Task not created");
        }
        finally {
            in.nextLine();
        }
        return tasks;
    }

    private static void printTasks(TaskList tasks) {
        for (int i = 0; i < tasks.taskCount; i++) {
            TaskItem currentTask = tasks.getTask(i);
            if (!currentTask.isComplete) {
                System.out.println(i + ") [" + currentTask.date + "] " + currentTask.title + ": "
                        + currentTask.description);
            }
            else {
                System.out.println("*** " + i + ") [" + currentTask.date + "] " + currentTask.title + ": "
                        + currentTask.description);
            }
        }
    }
}