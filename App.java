// library inclusions
import java.util.Scanner;
import java.util.Arrays;

// begin program
public class App {
    // initialize scanner for user input
    public static Scanner input = new Scanner(System.in);

    // main function
    public static void main(String[] args) {
        // initialize user input variables and encrypter + decrypter
        String userNum = "";
        int userChoice = 0;
        Encrypter encryptNum = new Encrypter();
        Decrypter decryptNum = new Decrypter();

        // receive number from user and let them choose if they are encrypting or decrypting
        userNum = receiveNum();
        userChoice = receiveChoice();
        if (userChoice == 1) {
            userNum = encryptNum.encrypt(userNum);
            System.out.println("Your encrypted number is: " + userNum);
        }
        else if (userChoice == 2) {
            userNum = decryptNum.decrypt(userNum);
            System.out.println("Your decrypted number is: " + userNum);
        }
    }

    //helper functions for input
    public static String receiveNum() {
        System.out.print("Enter your number: ");
        return input.nextLine();
    }

    public static int receiveChoice() {
        System.out.print("Enter 1 if you are encrypting or 2 if you are decrypting: ");
        return input.nextInt();
    }

}
