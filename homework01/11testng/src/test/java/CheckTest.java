import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class CheckTest {
    @DataProvider(name = "null")
    public Object[][] Null() {
        return new Object[][]{
                {null, new double[]{3, 4}},
                {new double[]{-1, 2}, null},
        };
    }

    @Test(expectedExceptions = Exception.class)
    public void checkCoord() throws Exception {
        Check check = new Check();
        ArrayList<double[]> p = new ArrayList<>();
        double[] f = {1,2};
        double[] x = {1,2};
        p.add(x);
        p.add(f);
        check.checkCoord(p);
    }

    @Test(expectedExceptions = Exception.class)
    public void checkNumberCoord() throws Exception {
        Check check = new Check();
        ArrayList<double[]> p = new ArrayList<>();
        double[] f = {1};
        double[] x = {3};
        p.add(x);
        p.add(f);
        check.checkNumberCoord(p);
    }

    @Test(dataProvider = "null", expectedExceptions = Exception.class)
    public void checNull(double[] z, double[] x) throws Exception{
        Check check = new Check();
        ArrayList<double[]> p = new ArrayList<>();
        p.add(x);
        p.add(z);
        check.checkCoord(p);
    }

}

