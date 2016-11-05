import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by Mark on 31.10.2016.
 */
public class CheckTest {
    @Test(expected = Exception.class)
    public void checkCoord() throws Exception {
        Check check = new Check();
        ArrayList<double[]> p = new ArrayList<>();
        double[] f = {1};
        double[] x = {3};
        p.add(x);
        p.add(f);
        check.checkNumberCoord(p);
    }

    @Test(expected = Exception.class)
    public void checkNumberCoord() throws Exception {
        Check check = new Check();
        ArrayList<double[]> p = new ArrayList<>();
        double[] f = {1,2};
        double[] x = {1,2};
        p.add(x);
        p.add(f);
        check.checkCoord(p);
    }

}



