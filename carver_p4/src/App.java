import java.time.DateTimeException;
import java.util.InputMismatchException;
import java.util.Scanner;

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
                    // create a new list
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
                                    // view tasks
                                    case 1:
                                        System.out.println("Current Tasks");
                                        System.out.println("-------------");
                                        printTasks(taskList);
                                        break;
                                    // add item
                                    case 2:
                                        addTaskToList(taskList);
                                        break;
                                    // edit item
                                    case 3:
                                        System.out.println("Current Tasks");
                                        System.out.println("-------------");
                                        printTasks(taskList);
                                        editTaskInList(taskList);
                                        break;
                                    // remove item
                                    case 4:
                                        break;
                                    // mark as complete
                                    case 5:
                                        break;
                                    // unmark as complete
                                    case 6:
                                        break;
                                    // save
                                    case 7:
                                        break;
                                    // quit
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
                    // load an existing list
                    case 2:

                        break;
                    // quit
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

    private static void editTaskInList(TaskList taskList) {
        System.out.print("What task will you edit? ");
        int index = in.nextInt();
        in.nextLine();
        String newTitle, newDesc, newDate;
        TaskItem editedTask;
        try {
            editedTask = taskList.getTask(index);
            System.out.print("Enter a new title for task " + index + ": ");
            newTitle = in.nextLine();
            System.out.print("Enter a new description for task " + index + ": ");
            newDesc = in.nextLine();
            System.out.print("Enter a new task due date (YYYY-MM-DD for task " + index + ": ");
            newDate = in.nextLine();
            editedTask.setTitle(newTitle);
            editedTask.setDesc(newDesc);
            editedTask.setDueDate(newDate);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: You cannot access that task because you called for an invalid index.");
        }
        catch (InputMismatchException e) {
            System.out.println("WARNING: You must enter the index of the task you wish to edit as an integer (0-based).");
        }
        catch (IllegalArgumentException illegalTitle) {
            System.out.println("WARNING: Title must contain one or more characters. Task not created.");
        }
        catch (DateTimeException illegalDate) {
            System.out.println("WARNING: Invalid due date. Task not created");
        }
        finally{
            in.nextLine();
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

    private static void addTaskToList(TaskList tasks) {
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