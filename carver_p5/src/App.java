import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean continueOperation = true;
        while(continueOperation) {
            try {
                System.out.println("Select your application");
                System.out.println("-----------------------");
                System.out.printf("%n1) Task List%n2) Contact List%n3) Quit%n%n> ");
                int choice = in.nextInt();
                switch (choice) {
                    case 1:
                        TaskApp.main();
                        break;
                    case 2:
                        ContactApp.main();
                        break;
                    case 3:
                        continueOperation = false;
                        break;
                    default:
                        throw new IndexOutOfBoundsException();
                }
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("WARNING: You must enter a number from 1 to 3.");
            }
            catch (InputMismatchException e) {
                System.out.println("WARNING: You must enter your choice as an integer.");
            }
        }
    }
}
