package us.Gorbunov.WayToMove;

/**
 * interface of all ways to move
 */
interface Time {
    /**
     * method that inherited
     *
     * @param distance of the way
     * @param speed    with that we move
     * @return return time that spending on the way
     */
    double getTime(double distance, double speed);

}
