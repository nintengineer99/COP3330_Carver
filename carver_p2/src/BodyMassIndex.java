// BMI Class
public class BodyMassIndex {
    double height, weight, bmiScore;
    String bmiCategory;

    // BMI constructor to hold pertinent info and perform important functions
    public BodyMassIndex(double height, double weight) {
        this.height = height;
        this.weight = weight;
        bmiScore = calcBmiScore(height, weight);
        bmiCategory = findBmiCategory(bmiScore);
    }

    // solves for BMI score with provided height and weight using provided equation
    public double calcBmiScore(double height, double weight) {
        return (703 * weight) / (height * height);
    }

    // determines appropriate BMI category based on calculated
    public String findBmiCategory(double bmiScore) {
        if (bmiScore < 18.5) {
            return "Underweight";
        }
        else if (bmiScore >= 18.5 && bmiScore < 25) {
            return "Normal Weight";
        }
        else if (bmiScore >= 25 && bmiScore < 30) {
            return "Overweight";
        }
        else {
            return "Obese";
        }
    }
}
