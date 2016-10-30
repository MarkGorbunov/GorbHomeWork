package us.Gorbunov.WayToMove;

/**
 * Class that calculate Time of the way when walk afoot.
 */
public class Walk implements Time {

    double time = 0;

    /**
     * method that calculate distance of way
     *
     * @param distance of the way
     * @param speed    with that we move
     * @return distance of way
     */
    public double getTime(double distance, double speed) {
        return time = distance / speed;
    }

}
