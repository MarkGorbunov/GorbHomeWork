import java.io.IOException;
import java.util.ArrayList;

/**
 * inherited on the Moveable,calculate price of the way and time spend for it
 */
public class Car implements Moveable {
    private static final double fuelConsumptionCar = 6.0;
    private static final double CARSPEED = 60.0;
    private static final int numberOfPasCar = 2;
    private static final double fuelCost = 0.63;
    private double distance = 0;

    public  void calculateDistance( ArrayList<double[]> point) {
        double X;
        double Y;
        for (int i = 1; i < point.size(); i++) {
            X = (point.get(i)[0] - point.get(i - 1)[0]);
            Y = (point.get(i)[1] - point.get(i - 1)[1]);
            distance += Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2));
        }
    }

    /**
     * method that calculate and return price of the way
     *
     * @return price of the way
     */
    @Override
    public double getPrice() {

        double value = distance * fuelConsumptionCar / numberOfPasCar * fuelCost / 100;
        return value;
    }

    /**
     * method that calculate time and return it
     *
     * @return time spend for the way
     */
    @Override
    public double getTime() {
        double time = (distance / CARSPEED) * 60;
        return time;
    }
}
