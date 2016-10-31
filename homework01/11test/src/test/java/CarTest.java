import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Mark on 31.10.2016.
 */
public class CarTest {
    @Test
    public void getPrice() throws Exception {
        Car car = new Car();
        assertEquals(0,car.getPrice(),0.01);
        ArrayList<double[]> p = new ArrayList<>();
        double[] f = {1, 2};
        double[] x = {3, 4};
        p.add(f);
        p.add(x);
        car.calculateDistance(p);
        assertEquals(0.05,car.getPrice(), 0.01);

    }

    @Test
    public void getTime() throws Exception {
        Car car = new Car();
        assertEquals(0,car.getPrice(),0.01);
        ArrayList<double[]> p = new ArrayList<>();
        double[] f = {1, 2};
        double[] x = {3, 4};
        p.add(f);
        p.add(x);
        car.calculateDistance(p);
        assertEquals(2.82,car.getTime(), 0.01);
    }

}