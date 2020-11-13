import java.util.InputMismatchException;

public class App {

    public static void main(String[] args) {
        while(true) {
            displayMainMenu();
            if () {

            }
            else {

            }
            try {

            }
            catch(InputMismatchException e) {
                System.out.println("WARNING: You must only enter integers 1, 2, or 3 to make your choice.");
            }
            break;
        }
    }

    private static void displayMainMenu() {
        System.out.printf("Main Menu%n" +
                "---------%n%n" +
                "1) Create a new list%n" +
                "2) Load an existing list%n" +
                "3) Load an existing list%n%n" +
                "> ");
    }
}
