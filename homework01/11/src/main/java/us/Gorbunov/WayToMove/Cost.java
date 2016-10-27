package us.Gorbunov.WayToMove;

/**
 * interface of bus and car
 */
interface Cost {
    /**
     * method that inherited
     *
     * @param distance        of the way
     * @param fuelConsumption on the 100 km
     * @param numberOfPas     number of passenger in vehicle
     * @param usd             cost of one liter of fuel
     * @return cost of the trip
     */
    double getCost(double distance, double fuelConsumption, int numberOfPas, double usd);
}
