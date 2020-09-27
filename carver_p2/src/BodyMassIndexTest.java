import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// tests BMI class methods for finding BMI score and category
public class BodyMassIndexTest {

    // Underweight calcBmiScore and findBmiCategory tests
    // Height = 60 inches, Weight = 100 pounds
    @Test
    public void testCalcBmiScoreUnderweight() {
        BodyMassIndex underweightBmiTest = new BodyMassIndex(62, 100);
        assertEquals(18.28824141519251, underweightBmiTest.calcBmiScore(62, 100));
    }

    @Test
    public void testFindBmiCategoryUnderweight() {
        BodyMassIndex underweightCategoryTest = new BodyMassIndex(62, 100);
        assertEquals("Underweight", underweightCategoryTest.findBmiCategory(18.28824141519251));
    }

    // Normal weight calcBmiScore and findBmiCategory tests
    // Height = 62 inches, Weight = 105 pounds
    @Test
    public void testCalcBmiScoreNormalWeight() {
        BodyMassIndex normalWeightBmiTest = new BodyMassIndex(62, 105);
        assertEquals(19.202653485952133, normalWeightBmiTest.calcBmiScore(62, 105));
    }

    @Test
    public void testFindBmiCategoryNormalWeight() {
        BodyMassIndex normalWeightCategoryTest = new BodyMassIndex(62, 105);
        assertEquals("Normal Weight", normalWeightCategoryTest.findBmiCategory(19.202653485952133));
    }

    // Overweight calcBmiScore and findBmiCategory tests
    // Height = 60 inches, Weight = 150 pounds
    @Test
    public void testCalcBmiScoreOverweight() {
        BodyMassIndex overweightBmiTest = new BodyMassIndex(60, 150);
        assertEquals(29.291666666666668, overweightBmiTest.calcBmiScore(60, 150));
    }

    @Test
    public void testFindBmiCategoryOverweight() {
        BodyMassIndex overweightCategoryTest = new BodyMassIndex(62, 150);
        assertEquals("Overweight", overweightCategoryTest.findBmiCategory(29.291666666666668));
    }

    // Obese calcBmiScore and findBmiCategory tests
    // Height = 62 inches, Weight = 215 pounds
    @Test
    public void testCalcBmiScoreObese() {
        BodyMassIndex obeseBmiTest = new BodyMassIndex(62, 215);
        assertEquals(39.31971904266389, obeseBmiTest.calcBmiScore(62, 215));
    }

    @Test
    public void testFindBmiCategoryObese() {
        BodyMassIndex obeseCategoryTest = new BodyMassIndex(62, 215);
        assertEquals("Obese", obeseCategoryTest.findBmiCategory(39.31971904266389));
    }
}