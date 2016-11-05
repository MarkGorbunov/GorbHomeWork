import junit.framework.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class TypeCheckingTest {


    @DataProvider(name = "isosceles")
    public Object[][] getIsosceles() {
        return new Object[][]{
                {1, 1, 1.2},
                {500, 500, 400},
                {10000, 10000, 7500}
        };
    }

    @DataProvider(name = "equilateral")
    public Object[][] getEquilateral() {
        return new Object[][]{
                {1, 1, 1},
                {200, 200, 200},
                {30000, 30000, 30000}
        };
    }

    @DataProvider(name = "normal")
    public Object[][] getNormal() {
        return new Object[][]{
                {1, 2, 2.3},
                {210, 212, 314},
                {30000, 40000, 50000}
        };
    }
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
    public void negativeTestForIncorrectDataInTypeChecking(double a, double b, double c) throws Exception {
        new TypeChecking().checkType(a,b,c);
    }

    @Test(dataProvider = "correctValue")
    public void positiveTestForCorrectDataInTypeChecking(double a, double b, double c) throws Exception {
        new TypeChecking().checkType(a,b,c);
    }

    @Test(dataProvider = "isosceles")
    public void positiveTestForIsoscelesTriangle(double a, double b, double c) throws Exception {
        TypeChecking typeChecking = new TypeChecking();
        Assert.assertEquals(typeChecking.checkType(a, b, c), "the triangle is isosceles");
    }

    @Test(dataProvider = "equilateral")
    public void positiveTestForEquilateralTriangle(double a, double b, double c) throws Exception {
        TypeChecking typeChecking = new TypeChecking();
        Assert.assertEquals(typeChecking.checkType(a, b, c), "the triangle is equilateral");
    }

    @Test(dataProvider = "normal")
    public void positiveTestForNormalTriangle(double a, double b, double c) throws Exception {
        TypeChecking typeChecking = new TypeChecking();
        Assert.assertEquals(typeChecking.checkType(a, b, c), "the triangle is normal");
    }

}