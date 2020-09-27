// library imports
import java.util.ArrayList;
import java.util.Scanner;

// Application Class
public class App2 {

    // create a scanner to allow user input
    public static Scanner input = new Scanner(System.in);

    // main function - begin simulation
    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    // allow user to input a height
    private static double getUserHeight() {
        double height;
        System.out.print("\nEnter your height in inches: ");
        height = input.nextDouble();
        input.nextLine();
        // ensure user is entering a positive value
        while (height < 0)
        {
            System.out.println("\nYou must enter a POSITIVE height in inches!");
            System.out.print("\nEnter your height in inches: ");
            height = input.nextDouble();
            input.nextLine();
        }
        return height;
    }

    // allow user to input a weight
    private static double getUserWeight() {
        double weight;
        System.out.print("\nEnter your weight in pounds: ");
        weight = input.nextDouble();
        input.nextLine();
        // ensure user is entering a positive value
        while (weight < 0)
        {
            System.out.println("\nYou must enter a POSITIVE weight in pounds!");
            System.out.print("\nEnter your weight in pounds: ");
            weight = input.nextDouble();
            input.nextLine();
        }
        return weight;
    }

    // display user's BMI score and category
    private static void displayBmiInfo(BodyMassIndex bmi) {
        System.out.println("\nYour BMI Score is: " + bmi.bmiScore);
        System.out.println("\nYou are: " + bmi.bmiCategory);
    }

    // average all BMI scores received
    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        int i;
        double sum = 0, average = 0;
        BodyMassIndex temp;
        for (i = 0; i < bmiData.size(); i += 1) {
            temp = bmiData.get(i);
            sum += temp.bmiScore;
        }
        average = sum / i;
        System.out.println("\nThe average of the BMI scores is: " + average);
    }

    // prompt user to decide whether or not they want to keep putting in new data
    public static boolean moreInput() {
        String choice;
        System.out.print("\nWould you like to enter data? Enter Y or y for yes, N or n for no: ");
        choice = input.next();

        // make sure user isn't inputting an invalid choice (i.e. cat or dog instead of Y or N)
        while (!(choice.equalsIgnoreCase("Y")) && !(choice.equalsIgnoreCase("N"))) {
            System.out.println("\nInvalid input. Please only enter Y or y for yes, N or n for no: ");
            choice = input.next();
        }

        // if user wants to continue, prompt while loop to continue
        if (choice.equalsIgnoreCase("Y")) {
            return true;
        }

        // otherwise calculate the average and end program
        else {
            return false;
        }
    }
}
