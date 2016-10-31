import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

/**
 * interface that containt method that inherited by in inheritors
 */
public interface Moveable {
    /**
     * default method that calculate distance of way
     *
     * @return distance of way
     */
    void calculateDistance( ArrayList<double[]> point);


    /**
     * vethod that calculate price of the way on this vehicle
     *
     * @return price of the way
     */
    double getPrice();

    /**
     * vethod that calculate time spend of the way on this vehicle
     *
     * @return time spend of the way
     */
    double getTime();
}
