import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.util.ArrayList;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;


public class WalkTest {
    ArrayList<double[]> p;
    Walk walk;

    @BeforeMethod
    public void setUp() {
        walk = new Walk();
        p = new ArrayList<>();

    }

    @DataProvider(name = "walk")
    public Object[][] getPoints() {
        return new Object[][]{
                {new double[]{1, 2}, new double[]{3, 4}},
                {new double[]{-1, 2}, new double[]{-3, 4}},
                {new double[]{-1, -2}, new double[]{-3, -4}},
                {new double[]{1, -2}, new double[]{3, -4}},
        };
    }

    @DataProvider(name = "walkinf")
    public Object[][] getINF() {
        return new Object[][]{
                {POSITIVE_INFINITY, new double[]{-1, POSITIVE_INFINITY}, new double[]{-3, -4}},
                {POSITIVE_INFINITY, new double[]{1, -2}, new double[]{3, NEGATIVE_INFINITY}},
                {POSITIVE_INFINITY, new double[]{NEGATIVE_INFINITY, 2}, new double[]{-3, 4}},
                {POSITIVE_INFINITY, new double[]{1, 2}, new double[]{POSITIVE_INFINITY, 4}}
        };
    }

    @DataProvider(name = "null")
    public Object[][] Null() {
        return new Object[][]{
                {null, new double[]{3, 4}},
                {new double[]{-1, 2}, null},
        };
    }

    @org.testng.annotations.Test(dataProvider = "walk")
    public void testGetTime(double[] coord1, double[] coord2) throws Exception {
        p.add(coord1);
        p.add(coord2);
        walk.calculateDistance(p);
        Assert.assertEquals(walk.getTime(), 28.28, 0.1);

    }

    @org.testng.annotations.Test(dataProvider = "walkinf")
    public void testGetTimeInf(double expected,double[] coord1, double[] coord2) throws Exception {
        p.add(coord1);
        p.add(coord2);
        walk.calculateDistance(p);
        Assert.assertEquals(walk.getTime(), expected, 0.1);

    }

    @Test(dataProvider = "null", expectedExceptions = Exception.class)
    public void checNull(double[] z, double[] x) throws Exception{
        p.add(x);
        p.add(z);
        walk.calculateDistance(p);
    }
}