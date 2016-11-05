import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.*;


public class AbilityOfExistTest {
    @DataProvider(name = "incorrectValue")
    public Object[][] getIncorrect() {
        return new Object[][]{
                {"q", 2.3, 3.4},
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
                {null, 2, 3},
                {0, 2, 3},
                {0.0, 2, 3},
                {4, -2, 3},
                {"two", 2, 3},
                {"2", 2, 3},
        };
    }

    @DataProvider(name = "correctValue")
    public Object[][] getCorrect() {
        return new Object[][]{
                {1, 1, 1},
                {2, 2, 3},
                {3, 4, 5}
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

