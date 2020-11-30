import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    // main function
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean continueOperation = true;
        while(continueOperation) {
            try {
                // allow user to choose which application they want to use
                System.out.println("Select your application");
                System.out.println("-----------------------");
                System.out.printf("%n1) Task List%n2) Contact List%n3) Quit%n%n> ");
                int choice = in.nextInt();
                switch (choice) {
                    case 1:
                        // user works with task app
                        TaskApp.main();
                        break;
                    case 2:
                        // user works with contact app
                        ContactApp.main();
                        break;
                    case 3:
                        // user quits
                        continueOperation = false;
                        break;
                    default:
                        throw new IndexOutOfBoundsException();
                }
            }
            // user submits a choice that is less than 1 or greater than 3
            catch (IndexOutOfBoundsException e) {
                System.out.println("WARNING: You must enter a number from 1 to 3.");
            }
            // user does not submit an integer choice
            catch (InputMismatchException e) {
                System.out.println("WARNING: You must enter your choice as an integer.");
            }
        }
    }
}
