import java.util.ArrayList;

/**
 * inherited on the Moveable,calculate price of the way and time spend for it
 */
public class Bus implements Moveable {
    private static final double BUSSPEED = 40.0;
    private static final double fuelCost = 0.63;
    private static final double fuelConsumptionBus = 10.0;
    private static final int numberOfPasBus = 30;
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
        return  distance * fuelConsumptionBus / numberOfPasBus * fuelCost / 100;
    }

    /**
     * method that calculate time and return it
     *
     * @return time spend for the way
     */
    @Override
    public double getTime() {
        return (distance / BUSSPEED) * 60;

    }
}
