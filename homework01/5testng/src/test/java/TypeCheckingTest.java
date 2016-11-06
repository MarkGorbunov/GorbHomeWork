import junit.framework.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TypeCheckingTest {

    //
    @DataProvider(name = "isosceles")
    public Object[][] getIsosceles() {
        return new Object[][]{
                {2, 2, 3},
                {3, 2, 2},
                {2, 3, 2},
                {Double.MAX_VALUE/2, Double.MAX_VALUE/2, Double.MAX_VALUE/3},
        };
    }

    @DataProvider(name = "equilateral")
    public Object[][] getEquilateral() {
        return new Object[][]{
                {1, 1, 1},
                {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE},
                {Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE},
                {Double.MIN_NORMAL, Double.MIN_NORMAL, Double.MIN_NORMAL},
        };
    }

    @DataProvider(name = "normal")
    public Object[][] getNormal() {
        return new Object[][]{
                {2, 2.2, 2.3},
                {2.3, 2, 2.2},
                {2.2, 2.3, 2},
                {Double.MAX_VALUE/2, Double.MAX_VALUE/3, Double.MAX_VALUE/4},
        };
    }

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
                {Double.MAX_VALUE + 1, 2, 3},
        };
    }


    @Test(dataProvider = "incorrectValue", expectedExceptions = Exception.class)
    public void negativeTestForIncorrectDataInTypeChecking(double a, double b, double c) throws Exception {
        new TypeChecking().checkType(a, b, c);
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