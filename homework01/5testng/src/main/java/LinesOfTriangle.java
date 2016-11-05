import java.util.Scanner;

/**
 * class that gets input data and return array of lines
 */
public class LinesOfTriangle  {
    /**
     * method that gets input data and return array of lines
     *
     * @return array of lines
     * @throws Exception auto generated exception when working with file
     */
    public double[] inputLines()throws Exception {
        double[] lines = new double[3];
        Scanner in = new Scanner(System.in);
        lines[0] = in.nextDouble();
        lines[1] = in.nextDouble();
        lines[2] = in.nextDouble();
        return lines;
    }
}
