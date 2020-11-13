import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean shouldContinue = true;
        while(shouldContinue) {
            int userChoice = 0;
            displayMainMenu();
            try {
                userChoice = in.nextInt();
                switch (userChoice) {
                    case 1:
                        displayListOperationMenu();
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
                System.out.println("WARNING: 1, 2, or 3 are the only valid options.");
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
                "6) Unmark an item as complete%n%n" +
                "7) Save the current list%n" +
                "8) Quit to the main menu%n%n" +
                "> ");
    }
}