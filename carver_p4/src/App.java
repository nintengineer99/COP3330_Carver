// library inclusions
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.DateTimeException;
import java.util.InputMismatchException;
import java.util.Scanner;

// app class
public class App {
    // create scanner for user input
    public static Scanner in = new Scanner(System.in);

    // main
    public static void main(String[] args) {
        // create boolean that controls when program should terminate based on user input
        boolean shouldContinue = true;

        // enter loop
        while(shouldContinue) {
            // display main menu
            int userChoice1 = 0;
            displayMainMenu();
            try {
                // allow user to input their main menu choice
                userChoice1 = in.nextInt();
                in.nextLine();
                // main menu switch statement
                switch (userChoice1) {
                    // create a new list
                    case 1:
                        // create the list and a boolean condition that allows user to exit to the main menu
                        TaskList taskList = new TaskList();
                        boolean continueListOperations = true;
                        System.out.println("New task list has been created.");
                        while (continueListOperations) {
                            // display list ops menu
                            int userChoice2 = 0;
                            displayListOperationMenu();
                            try {
                                // user chooses the desired operation
                                userChoice2 = in.nextInt();
                                in.nextLine();
                                // set while condition to false if they choose 8, true otherwise
                                continueListOperations = listOperationsMenu(userChoice2, taskList);
                            }
                            // user sends number less than 1 or greater than 8
                            catch (IllegalArgumentException e) {
                                System.out.println("WARNING: Numbers 1 through 8 are the only valid options.");
                            }
                            // user does not send an integer
                            catch (InputMismatchException e) {
                                System.out.println("WARNING: You must only enter integers 1 through 8 to make your choice.");
                            }
                            // clear input buffer
                            finally {
                                in.nextLine();
                            }
                        }
                        break;
                    // load an existing list
                    case 2:
                        // create task list so one can be loaded in and worked on
                        TaskList loadedTaskList = new TaskList();
                        // user enters what file they want to edit
                        System.out.print("Enter the file name to load: ");
                        String fileName = in.nextLine();
                        // load list if it exists
                        loadedTaskList.loadList(fileName);
                        // successfully loaded list, allow user to utilize list ops menu in a similar manner as if they
                        // had chosen to create a new list
                        System.out.println("Task list has been loaded.");
                        boolean continueLoadedListOperations = true;
                        while (continueLoadedListOperations) {
                            // display list ops menu
                            int userChoice3 = 0;
                            displayListOperationMenu();
                            try {
                                // user chooses the desired operation
                                userChoice3 = in.nextInt();
                                in.nextLine();
                                // set while condition to false if they choose 8, true otherwise
                                continueLoadedListOperations = listOperationsMenu(userChoice3, loadedTaskList);
                            }
                            // user sends number less than 1 or greater than 8
                            catch (IllegalArgumentException e) {
                                System.out.println("WARNING: Numbers 1 through 8 are the only valid options.");
                            }
                            // user does not send an integer
                            catch (InputMismatchException e) {
                                System.out.println("WARNING: You must only enter integers 1 through 8 to make your choice.");
                            }
                            // clear input buffer
                            finally {
                                in.nextLine();
                            }
                        }
                        break;
                    // quit
                    case 3:
                        shouldContinue = false;
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
            // user sends input less than 1 or greater than 3
            catch(IllegalArgumentException e) {
                System.out.println("WARNING: Numbers 1, 2, or 3 are the only valid options.");
            }
            // user does not send an integer for their choice
            catch(InputMismatchException e) {
                System.out.println("WARNING: You must only enter integers 1, 2, or 3 to make your choice.");
            }
            // user tries to access a file that does not exist
            catch (IOException e) {
                System.out.println("WARNING: File could not be found. No file loaded.");
            }
            // clear input buffer
            finally {
                in.nextLine();
            }
        }
    }

    // method for list ops menu that allows saving list to a file
    private static void saveListToFile(TaskList tasks) {
        try {
            if (tasks.taskCount == 0) {
                throw new NoSuchFieldException();
            }
            System.out.print("Enter the file name to save as: ");
            String fileName = in.nextLine();
            tasks.saveList(fileName);
            System.out.println("Task list has been saved.");
        }
        catch (FileNotFoundException e) {
            System.out.println("WARNING: No such file was found. No list saved.");
        }
        // if no tasks exist yet stop user from saving
        catch (NoSuchFieldException e) {
            System.out.println("WARNING: You have no tasks to save.");
        }
    }

    // allows user to unmark a task as complete in list ops menu
    private static void markTaskAsIncomplete(TaskList tasks) {
        try {
            if (tasks.taskCount == 0) {
                throw new NoSuchFieldException();
            }
            // print currently completed tasks
            System.out.println("Completed Tasks");
            System.out.println("---------------");
            printCompleteTasks(tasks);
            System.out.print("Which task will you unmark as completed? ");
            int index = in.nextInt();
            in.nextLine();
            tasks.unmarkTask(index);
        }
        // user did not send an integer index
        catch (InputMismatchException e) {
            System.out.println("WARNING: You must enter the index of the task you wish to unmark as complete as an integer (0-based).");
        }
        // user's requested index lies outside of the current range of indices
        catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: You cannot unmark that task complete because you called for an invalid index.");
        }
        // if no tasks exist yet stop user from trying to unmark
        catch (NoSuchFieldException e) {
            System.out.println("WARNING: You have no tasks to unmark complete.");
        }
    }

    // prints completed tasks for when user wants to choose which one to unmark
    private static void printCompleteTasks(TaskList tasks) {
        for (int i = 0; i < tasks.taskCount; i++) {
            // access and print completed tasks only
            TaskItem currentTask = tasks.getTask(i);
            if (currentTask.isComplete) {
                System.out.println(tasks.getTaskIndex(currentTask) + ") [" + currentTask.date + "] " + currentTask.title + ": "
                        + currentTask.description);
            }
        }
    }

    // method that allows user to mark as task as completed in the list ops menu
    private static void markTaskAsComplete(TaskList tasks) {
        try {
            if (tasks.taskCount == 0) {
                throw new NoSuchFieldException();
            }
            // print incomplete tasks so the user may make their choice
            System.out.println("Uncompleted Tasks");
            System.out.println("-----------------");
            printIncompleteTasks(tasks);
            System.out.print("Which task will you mark as completed? ");
            int index = in.nextInt();
            in.nextLine();
            tasks.markOffTask(index);
        }
        // user did not provide an integer index
        catch(InputMismatchException e) {
            System.out.println("WARNING: You must enter the index of the task you wish to mark as complete as an integer (0-based).");
        }
        // user tries to access index outside of current range
        catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: You cannot mark that task complete because you called for an invalid index.");
        }
        // if no tasks exist stop user from trying to mark complete
        catch (NoSuchFieldException e) {
            System.out.println("WARNING: You have no tasks to mark complete.");
        }
    }

    // print all incomplete tasks so user can make their choice
    private static void printIncompleteTasks(TaskList tasks) {
        for (int i = 0; i < tasks.taskCount; i++) {
            // access and print only incomplete tasks
            TaskItem currentTask = tasks.getTask(i);
            if (!currentTask.isComplete) {
                System.out.println(tasks.getTaskIndex(currentTask) + ") [" + currentTask.date + "] " + currentTask.title + ": "
                        + currentTask.description);
            }
        }
    }

    // allow user to remove a task from the list they no longer need
    private static void removeTaskInList(TaskList taskList) {
        try {
            if (taskList.taskCount == 0) {
                throw new NoSuchFieldException();
            }
            // print all tasks currently in list so user can make their decision
            System.out.println("Current Tasks");
            System.out.println("-------------");
            printTasks(taskList);
            System.out.print("What task will you remove? ");
            int index = in.nextInt();
            taskList.removeTask(index);
        }
        // user did not enter an integer index
        catch(InputMismatchException e) {
            System.out.println("WARNING: You must enter the index of the task you wish to remove as an integer (0-based).");
        }
        // user entered an index outside of the current range
        catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: You cannot remove that task because you called for an invalid index.");
        }
        // if no tasks exist prevent user from trying to remove a task
        catch (NoSuchFieldException e) {
            System.out.println("WARNING: You have no tasks to remove");
        }
    }

    // method that allows user to edit a task's title, description, and due date in list ops menu
    private static void editTaskInList(TaskList taskList) {
        try {
            if (taskList.taskCount == 0) {
                throw new NoSuchFieldException();
            }
            // print all current tasks so user can choose which one to edit
            System.out.println("Current Tasks");
            System.out.println("-------------");
            printTasks(taskList);
            System.out.print("What task will you edit? ");
            int index = in.nextInt();
            in.nextLine();
            if (index < 0 || (index + 1) > taskList.taskCount) {
                throw new IndexOutOfBoundsException();
            }
            // input new title, description, and due date for chosen task
            String newTitle, newDesc, newDate;
            System.out.print("Enter a new title for task " + index + ": ");
            newTitle = in.nextLine();
            System.out.print("Enter a new description for task " + index + ": ");
            newDesc = in.nextLine();
            System.out.print("Enter a new task due date (YYYY-MM-DD for task " + index + ": ");
            newDate = in.nextLine();
            taskList.editTask(index, newTitle, newDesc, newDate);
        }
        // user tried to access index outside of current range
        catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: You cannot access that task because you called for an invalid index.");
        }
        // user did not enter integer index
        catch (InputMismatchException e) {
            System.out.println("WARNING: You must enter the index of the task you wish to edit as an integer (0-based).");
        }
        // title is not 1 or more character
        catch (IllegalArgumentException illegalTitle) {
            System.out.println("WARNING: Title must contain one or more characters. Task not edited.");
        }
        // due date is either not in appropriate form or is in the past
        catch (DateTimeException illegalDate) {
            System.out.println("WARNING: Invalid due date. Task not edited.");
        }
        // if there are no tasks stop user from trying to edit
        catch (NoSuchFieldException e) {
            System.out.println("WARNING: There are no tasks to edit.");
        }
        // clear input buffer
        finally{
            in.nextLine();
        }
    }

    // display main menu options for user
    private static void displayMainMenu() {
        System.out.printf("Main Menu%n" +
                "---------%n%n" +
                "1) Create a new list%n" +
                "2) Load an existing list%n" +
                "3) Quit%n%n" +
                "> ");
    }

    // display list ops choices for user
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

    // allows user to add a new task to the current list
    private static void addTaskToList(TaskList tasks) {
        // receive task's title, description, and due date
        System.out.print("Task title: ");
        String userTitle = in.nextLine();
        System.out.print("Task description: ");
        String userDesc = in.nextLine();
        System.out.print("Task due date (YYYY-MM-DD): ");
        String userDate = in.nextLine();
        // set task properties appropriately then add it to the list
        try {
            TaskItem task = new TaskItem();
            task.setTitle(userTitle);
            task.setDesc(userDesc);
            task.setDueDate(userDate);
            tasks.addTask(task);
        }
        // title is too short
        catch (IllegalArgumentException illegalTitle) {
            System.out.println("WARNING: Title must contain one or more characters. Task not created.");
        }
        // date's format is incorrect or date is in the past
        catch (DateTimeException illegalDate) {
            System.out.println("WARNING: Invalid due date. Task not created");
        }
        // clear input buffer
        finally {
            in.nextLine();
        }
    }

    // print all completed and incomplete tasks
    private static void printTasks(TaskList tasks) {
        for (int i = 0; i < tasks.taskCount; i++) {
            TaskItem currentTask = tasks.getTask(i);
            if (!currentTask.isComplete) {
                System.out.println(tasks.getTaskIndex(currentTask) + ") [" + currentTask.date + "] " + currentTask.title + ": "
                        + currentTask.description);
            }
            else {
                System.out.println("*** " + tasks.getTaskIndex(currentTask) + ") [" + currentTask.date + "] "
                        + currentTask.title + ": " + currentTask.description);
            }
        }
    }

    // print all options in the list operations menu
    private static boolean listOperationsMenu(int choice, TaskList taskList) {
        switch (choice) {
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
                editTaskInList(taskList);
                break;
            // remove item
            case 4:
                removeTaskInList(taskList);
                break;
            // mark as complete
            case 5:
                markTaskAsComplete(taskList);
                break;
            // unmark as complete
            case 6:
                markTaskAsIncomplete(taskList);
                break;
            // save
            case 7:
                saveListToFile(taskList);
                break;
            // quit
            case 8:
                return false;
            default:
                throw new IllegalArgumentException();
        }
        return true;
    }
}