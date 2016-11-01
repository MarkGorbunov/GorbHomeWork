import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;


public class BusTest {
    ArrayList<double[]> p;
    Bus bus;
    @DataProvider(name = "bus")
    public Object[][] getPoints() {
        return new Object[][]{
                {new double[]  {1, 2}, new double[] {3, 4}},
                {new double[]  {-1, 2}, new double[] {-3, 4}},
                {new double[]  {-1, -2}, new double[] {-3, -4}},
                {new double[]  {1, -2}, new double[] {3, -4}},
        };
    }
    @DataProvider(name = "businf")
    public Object[][] getINF() {
        return new Object[][]{
                {POSITIVE_INFINITY,new double[]{-1, POSITIVE_INFINITY}, new double[]{-3, -4}},
                {POSITIVE_INFINITY,new double[]{1, -2}, new double[]{3, NEGATIVE_INFINITY}},
                {POSITIVE_INFINITY,new double[]{NEGATIVE_INFINITY, 2}, new double[]{-3, 4}},
                {POSITIVE_INFINITY,new double[]{1, 2}, new double[]{POSITIVE_INFINITY, 4}}
        };
    }

    @DataProvider(name = "null")
    public Object[][] Null() {
        return new Object[][]{
                {null, new double[]{3, 4}},
                {new double[]{-1, 2}, null},
        };
    }
    @BeforeMethod
    public void setUp() {
        bus = new Bus();
        p = new ArrayList<>();
    }
    @Test(dataProvider = "bus")
    public void testGetPrice(double[] coord1,double[] coord2) throws Exception {
        p.add(coord1);
        p.add(coord2);
        bus.calculateDistance(p);
        Assert.assertEquals(bus.getPrice(), 0.0059, 0.001);
    }

    @Test(dataProvider = "bus")
    public void testGetTime(double[] coord1,double[] coord2) throws Exception {
        p.add(coord1);
        p.add(coord2);
        bus.calculateDistance(p);
        Assert.assertEquals(bus.getTime(), 4.24, 0.1);

    }
    @org.testng.annotations.Test(dataProvider = "businf")
    public void testGetPriceInf(double expected,double[] coord1, double[] coord2) throws Exception {
        p.add(coord1);
        p.add(coord2);
        bus.calculateDistance(p);
        Assert.assertEquals(bus.getPrice(), expected, 0.1);
    }

    @org.testng.annotations.Test(dataProvider = "businf")
    public void testGetTimeInf(double expected,double[] coord1, double[] coord2) throws Exception {
        p.add(coord1);
        p.add(coord2);
        bus.calculateDistance(p);
        Assert.assertEquals(bus.getTime(), expected, 0.1);

    }

    @Test(dataProvider = "null", expectedExceptions = Exception.class)
    public void checNull(double[] z, double[] x) throws Exception{
        p.add(x);
        p.add(z);
        bus.calculateDistance(p);
    }

}