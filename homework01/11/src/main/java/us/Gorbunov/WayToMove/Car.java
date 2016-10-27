package us.Gorbunov.WayToMove;

/**
 * Class that calculate Time and Cost of the way for car
 */
public class Car implements Time, Cost {

    double time = 0;
    double cost = 0;

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

    /**
     * method that calculate cost of the trip on car
     *
     * @param distance        of the way
     * @param fuelConsumption on the 100 km
     * @param numberOfPas     number of passenger in vehicle
     * @param usd             cost of one liter of fuel
     * @return cost of the trip
     */
    public double getCost(double distance, double fuelConsumption, int numberOfPas, double usd) {
        return cost = distance / 100.0 * fuelConsumption / numberOfPas * usd;
    }
}
