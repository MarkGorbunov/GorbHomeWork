import java.util.ArrayList;

/**
 * inherited on the Moveable,calculate price of the way and time spend for it
 */
public class Walk implements Moveable {
    private static final double WALKSPEED = 6.0;
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
     * return 0 because walk is free
     *
     * @return price of the way
     */
    @Override
    public double getPrice() {
        return 0;
    }

    /**
     * calculate time and return it
     *
     * @return time spend for the way
     */
    @Override
    public double getTime() {
        double time = (distance / WALKSPEED) * 60;
        return time;
    }
}
