/**
 * Main class that contain entry point
 */
public class Main {
    /**
     *method that create object that initialize triangle,check type of triangle and ability pf exist
     */
    public static void main(String[] args) {
        try {
            System.out.println("input line of triangle ");
            LinesOfTriangle linesOfTriangle = new LinesOfTriangle();
            double[] line = linesOfTriangle.inputLines();
            TypeChecking typeChecking = new TypeChecking();
            System.out.println(typeChecking.checkType(line[0], line[1], line[2]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
