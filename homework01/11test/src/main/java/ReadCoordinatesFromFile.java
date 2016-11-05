import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * class that read coordinates from file
 */
public class ReadCoordinatesFromFile {

    /**
     * method that read coordinates from file and return it in list
     *
     * @return list of coordinates
     */
    public ArrayList<double[]> read() {
        ArrayList<double[]> point = new ArrayList<>();
        double[] n;
        try {
            Path pathToFile = Paths.get("C:/Users/Mark/IdeaProjects/1.11v2/coord.txt");
            List<String> lines = Files.readAllLines(pathToFile, StandardCharsets.UTF_8);
            for (String line : lines) {
                String[] COORDINATE = line.split(" ");
                double x = Double.parseDouble(COORDINATE[0]);
                double y = Double.parseDouble(COORDINATE[1]);
                 n = new double[]{x, y};
                point.add(n);
            }
        } catch (Exception e) {
            System.out.println("Error with file");
        }
        return point;
    }
}



