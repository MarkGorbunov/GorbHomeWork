package us.Gorbunov;

import us.Gorbunov.WayToMove.*;

import java.io.IOException;

/**
 * Class that containt variables of speed,number of passenger,fuelConsumption,fuelCost
 * and displays statistic of all movement way;
 */
public class Main {
    private static final double BUSSPEED = 40.0;
    private static final double CARSPEED = 60.0;
    private static final double WALKSPEED = 6.0;
    private static final double BICYCLESPEED = 15.0;
    private static final double fuelConsumptionCar = 6.0;
    private static final double fuelConsumptionBus = 10.0;
    private static final int numberOfPasCar = 2;
    private static final int numberOfPasBus = 30;
    private static final double fuelCost = 0.63;

    /**
     * method that issue memory for all movement way and  displays statistic of its;
     *
     * @param args transmitted arguments
     * @throws IOException auto generated exception when working with files
     */
    public static void main(String[] args) throws IOException {
        double distance = Distance.distance();
        //information about car
        Car car = new Car();
        System.out.printf("%.3f", car.getTime(distance, CARSPEED));
        System.out.println(" hour -- Time that car spend of our way");
        System.out.printf("%.3f", car.getCost(distance, fuelConsumptionCar, numberOfPasCar, fuelCost));
        System.out.println(" USD -- Cost of passage of a route by car \n");
        //information about bus
        Bus bus = new Bus();
        System.out.printf("%.3f", bus.getTime(distance, BUSSPEED));
        System.out.println(" hour -- Time that bus spend of our way");
        System.out.printf("%.3f", car.getCost(distance, fuelConsumptionBus, numberOfPasBus, fuelCost));
        System.out.println(" USD -- Cost of passage of a route by bus \n");
        //information when walk afoot
        Walk walk = new Walk();
        System.out.printf("%.3f", walk.getTime(distance, WALKSPEED));
        System.out.println(" hour   -- Time that man spend of our way");
        System.out.println("walk is free \n");
        //information about bicycle
        Bicycle bicycle = new Bicycle();
        System.out.printf("%.3f", bicycle.getTime(distance, BICYCLESPEED));
        System.out.println(" hour   -- Time that man on bicycle spend of our way\";");
        System.out.println("bike on bycicle is free \n");
    }
}
