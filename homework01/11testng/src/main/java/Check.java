import java.util.ArrayList;

/**
 * class that check start and end coordinate if it equals return false
 */
public class Check {
    /**
     * method that check start and end coordinate if it equals throws exception
     */
    public void checkCoord(ArrayList<double[]> point) throws Exception {
        if ((point.get(0)[0] == point.get(point.size() - 1)[0] &&
                (point.get(0)[1] == point.get(point.size() - 1)[1]))) {
            throw new Exception("start and end coordinates are equals");
        }
    }

    public void checkNumberCoord(ArrayList<double[]> point) throws Exception {
        for (double[] a: point) {
            if (a.length != 2){
                throw new Exception("incorrect number of coordinate");
            }
        }
    }
}
