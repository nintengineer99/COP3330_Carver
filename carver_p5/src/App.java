import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean continueOperation = true;
        while(continueOperation) {
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
                    break;
            }
        }
    }
}
