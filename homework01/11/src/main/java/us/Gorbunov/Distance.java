package us.Gorbunov;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * Class that read information from txt file and calculate distance between checkpoints in this file
 */
public class Distance {
    static final String pathToFile = "/Users/Mark/IdeaProjects/11/coord.txt";
    public static double distance;

    /**
     * method that read information from txt file and calculate and return distance between checkpoints in this file
     *
     * @return distance between checkpoints
     * @throws IOException auto generated exception when working with file
     */
    public static double distance() throws IOException {
        try {
            String file = new String(Files.readAllBytes(Paths.get(pathToFile)));
            String[] coordinates = file.split(" +");
            double[] coordinate = new double[coordinates.length];
            distance = 0;
            for (int i = 0; i < coordinates.length; i++) {
                String s = coordinates[i];
                coordinate[i] = Double.parseDouble(s);
                if (i > 2) {
                    distance = distance + Math.sqrt(Math.pow((coordinate[i - 1] - coordinate[i - 3]), 2) +
                            Math.pow((coordinate[i - 1] - coordinate[i - 2]), 2));
                }
                //check for first coordinate and last not equal
                if (coordinate[0] == coordinate[coordinates.length - 2] &&
                        coordinate[1] == coordinate[coordinates.length - 1]) {
                    System.out.println("The start and end point equal");
                    System.exit(0);
                }
            }
        } catch (Exception e) {
            System.out.println("Error!");
        }
        System.out.println(distance + "km");
        return distance;
    }
}