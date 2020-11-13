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
                                        TaskItem task = new TaskItem("default", "default", "9999-12-31");
                                        System.out.print("Task title: ");
                                        task.setTitle(in.nextLine());
                                        System.out.print("Task description: ");
                                        task.setDesc(in.nextLine());
                                        System.out.print("Task due date (YYYY-MM-DD): ");
                                        task.setDueDate(in.nextLine());
                                        break;
                                    case 2:
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
                "3) Edit an item%n%n" +
                "4) Remove an item%n" +
                "5) Mark an item as complete%n" +
                "6) Unmark an item as complete%n" +
                "7) Save the current list%n" +
                "8) Quit to the main menu%n%n" +
                "> ");
    }
}