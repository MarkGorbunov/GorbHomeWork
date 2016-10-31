import java.util.HashMap;
import java.util.Map;

/**
 * class that contain point of enter in the program,and check start
 * and end coordinate,if it not equal calculate and displays information about vehicle
 */
public class Main {
    /**
     * method that check start and end coordinate,if it not equal calculate and displays
     * information about vehicle
     *
     * @param args args that cfb be transfered
     */
    public static void main(String[] args) {
        ReadCoordinatesFromFile read = new ReadCoordinatesFromFile();
        //checks start and end coordinates
        Check check = new Check();
        try {
           check.checkCoord(read.read());
            check.checkNumberCoord(read.read());
            HashMap<String, Moveable> transport = new HashMap<>();
            transport.put("Car", new Car());
            transport.put("Bus", new Bus());
            transport.put("Bicycle", new Bicycle());
            transport.put("OnFoot", new Walk());
            Statistic statistic = new Statistic();
            for (Map.Entry<String, Moveable> vehicle : transport.entrySet()) {
                statistic.showStatistic(vehicle, read.read());
            }
        } catch (Exception e) {
            System.err.println("Exception occured:" + e.toString());
            e.printStackTrace();
        }
    }
}


