import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Mark on 31.10.2016.
 */
public class WalkTest {
    @Test
    public void getPrice() throws Exception {
        Walk walk = new Walk();
        assertEquals(0, walk.getPrice(), 0.01);
    }

    @Test
    public void getTime() throws Exception {
        Walk walk = new Walk();
        ArrayList<double[]> p = new ArrayList<>();
        double[] f = {-1, -2};
        double[] x = {3, 4};
        p.add(f);
        p.add(x);
        walk.calculateDistance(p);
        assertEquals(72.11, walk.getTime(), 0.01);
    }

    @Test
    public void getTime2() throws Exception {
        Walk walk = new Walk();
        ArrayList<double[]> p = new ArrayList<>();
        walk.calculateDistance(p);
        assertNotNull(walk.getTime());
    }

}