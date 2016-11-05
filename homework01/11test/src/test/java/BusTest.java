import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Mark on 31.10.2016.
 */
public class BusTest {
    @Test
    public void getPrice() throws Exception {
        Bus bus = new Bus();
        assertEquals(0,bus.getPrice(),0.01);
        ArrayList<double[]> p = new ArrayList<>();
        double[] f = {1, 2};
        double[] x = {3, 4};
        p.add(f);
        p.add(x);
        bus.calculateDistance(p);
        assertEquals(0.0059,bus.getPrice(), 0.001);
    }

    @Test
    public void getTime() throws Exception {
        Bus bus = new Bus();
        assertEquals(0, bus.getPrice(), 0.01);
        ArrayList<double[]> p = new ArrayList<>();
        double[] f = {1, 2};
        double[] x = {3, 4};
        p.add(f);
        p.add(x);
        bus.calculateDistance(p);
        assertEquals(4.24, bus.getTime(), 0.01);
    }

}