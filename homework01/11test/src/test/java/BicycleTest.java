import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Mark on 30.10.2016.
 */
public class BicycleTest {

    @Test
    public void getPrice() throws Exception {
        Bicycle bicycle = new Bicycle();
        // assertNotNull(bicycle.getPrice());
        assertEquals(0,bicycle.getPrice(),0.01);
        // assertTrue(bicycle.getPrice() == 0.0);
    }

    @Test
    public void getTime() throws Exception {
        Bicycle bicycle = new Bicycle();
        ArrayList<double[]> p = new ArrayList<>();
        double[] f = {1, 2};
        double[] x = {3, 4};
        p.add(f);
        p.add(x);
        bicycle.calculateDistance(p);
        assertEquals(11.31, bicycle.getTime(), 0.01);
    }

    @Test
    public void getTime2() throws Exception {
        Bicycle bicycle = new Bicycle();
        ArrayList<double[]> p = new ArrayList<>();
        bicycle.calculateDistance(p);
         assertNotNull(bicycle.getTime());
    }

}