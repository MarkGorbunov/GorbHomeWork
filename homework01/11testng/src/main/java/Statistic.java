import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * class that displays information about vehicle
 */
public class Statistic {
    /**
     * method that displays information about vehicle
     *
     * @param vehicle current vehicle
     */
    public void showStatistic(Map.Entry<String, Moveable> vehicle, ArrayList<double[]>point) {

        vehicle.getValue().calculateDistance(point);
        System.out.println("Vehicle \"" + vehicle.getKey() + "\":");
        System.out.printf("time(min) = " + "%.2f"
                + "\n", vehicle.getValue().getTime());
        System.out.printf("price (USD) = " + "%.2f"
                + "\n", vehicle.getValue().getPrice());
        System.out.println("");
    }
}

