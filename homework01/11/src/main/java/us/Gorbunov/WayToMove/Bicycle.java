package us.Gorbunov.WayToMove;

/**
 * Class that calculate Time of the way for bicycle
 */
public class Bicycle implements Time {
    double time = 0;

    /**
     * method tha calculate distance of way
     *
     * @param distance of the way
     * @param speed    with that we move
     * @return distance of way
     */
    public double getTime(double distance, double speed) {
        return time = distance / speed;

    }

}
