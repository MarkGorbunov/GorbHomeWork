import java.util.Scanner;

/**
 * C@author Gorbunov on 04.10.2016.
 *  Class that calculate roots of cuadratic equation
 */
public class QuadEquation {
    /**
     * method that calculate roots of cuadratic equation
     */
    public static void main(String[] args) {
        try {
            System.out.println("X^2*a+X*b+c");
            Scanner in = new Scanner(System.in);
            System.out.println("input a");
            double a = in.nextDouble();
            System.out.println("input b");
            double b = in.nextDouble();
            System.out.println("input c");
            double c = in.nextDouble();

            Linearity(a);
            if (Discriminant(a, b, c) > 0) { //rooth with Discriminant that > 0

                double x1 = ((-b + Math.sqrt(Discriminant(a, b, c))) / (2 * a));
                double x2 = ((-b - Math.sqrt(Discriminant(a, b, c))) / (2 * a));
                System.out.println("roots of equation:" + "x1 = " + x1 + "   x2 = " + x2);
            } else if (Double.isInfinite(1 / Discriminant(a, b, c))) { //rooth with Discriminant that = 0
                double x1 = ((-b + Math.sqrt(Discriminant(a, b, c))) / (2 * a));
                System.out.println("roots of equation:" + "x1 = x2 =" + x1);
            } else { ///rooth with Discriminant that < 0
                System.out.println("equation have only imaginary roots");
            }
        } catch (Exception ex) {
            System.out.println("error!! input arguments must be numbers");
        }
    }

    /**
     * method that return value of descriminant
     * @param a variable with X^2
     * @param b variable with X
     * @param c cariable without X
     * @return
     */
    public static double Discriminant(double a, double b, double c) {
        double D;
        D = (b * b - 4 * a * c);
        return D;
    }

    /**
     *method that check equation on lineatity
     * @param a variable with X^2
     */
    public static void Linearity(double a) {
        if (Double.isInfinite(1 / a)) {
            System.out.println("equation is not quadratic");
            System.exit(0);
        }
    }
}
