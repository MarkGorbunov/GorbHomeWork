import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;


public class AbilityOfExistTest {
    @DataProvider(name = "incorrectValue")
    public Object[][] getIncorrect() {
        return new Object[][]{
                {"q", 2.3, 3.4},
                {2.3, "q", 3.4},
                {3.4, 2.3, "q"},
                {Double.NEGATIVE_INFINITY, 2.3, 3.4},
                {3.4, Double.NEGATIVE_INFINITY, 3.4},
                {2.3, 2.3, Double.NEGATIVE_INFINITY},
                {Double.POSITIVE_INFINITY, 2.3, 3.4},
                {3.4, Double.POSITIVE_INFINITY, 3.4},
                {2.3, 2.3, Double.POSITIVE_INFINITY},
                {Double.NaN, 2.3, 3.4},
                {3.4, Double.NaN, 3.4},
                {2.3, 2.3, Double.NaN},
                {1, 2, 3},
                {2, 1, 3},
                {3, 2, 1},
                {null, 2, 3},
                {0, 2, 3},
                {0.0, 2, 3},
                {-4, 2, 3},
                {4, -2, 3},
                {4, 2, -3},
                {"two", 2, 3},
                {"2", 2, 3},
                {Double.MAX_VALUE+1, 2, 3},
        };
    }

    @DataProvider(name = "correctValue")
    public Object[][] getCorrect() {
        return new Object[][]{
                {1, 1, 1},
                {2, 2, 3},
                {3, 4, 5},
                {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE-2},
                {Double.MAX_VALUE-2, Double.MAX_VALUE, Double.MAX_VALUE},
                {Double.MAX_VALUE, Double.MAX_VALUE-2, Double.MAX_VALUE},
        };
    }

    @Test(dataProvider = "incorrectValue", expectedExceptions = Exception.class)
    public void negativeTestForIncorrectData(double a, double b, double c) throws Exception {
        AbilityOfExist abilityOfExist = new AbilityOfExist();
        abilityOfExist.checkExist(a, b, c);
    }

    @Test(dataProvider = "correctValue")
    public void positiveTestForCorrectData(double a, double b, double c) throws Exception {
        AbilityOfExist abilityOfExist = new AbilityOfExist();
        abilityOfExist.checkExist(a, b, c);
    }
}

