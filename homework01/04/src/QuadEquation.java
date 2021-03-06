import java.util.Scanner;

/**
 * @author Gorbunov on 04.10.2016.
 *         Class that calculate roots of cuadratic equation
 */
public class QuadEquation {
    /**
     * method that calculate roots of cuadratic equation
     */
    public static void main(String[] args) {
        double[] parameters = new double[3];
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("X^2*a+X*b+c");
            for (int i = 0; i < parameters.length; i++) {
                System.out.println("Set " + (i + 1) + " parameter");
                parameters[i] = scanner.nextDouble();
            }
             if (Linearity(parameters) == false) {
                 Roots(parameters);
             }
        } catch (Exception ex) {
            System.out.println("Incorrect input values. Expected double format");
        }
    }
    /**
     * method that calculate and shows the roots of equation
     *
     * @param params arguments that are substituted into the equation
     */
    public static void Roots(double[] params) {
        double[] result = new double[2];
        double discriminant = (params[1] * params[1] - 4 * params[0] * params[2]);//calculate discriminant
        if (Double.isInfinite(1 / discriminant)) { //root with Discriminant that = 0
            result[0] = ((-params[1] + Math.sqrt(discriminant)) / (2 * params[0]));
            System.out.println("X1 = X2 = " + result[0]);
        } else if (discriminant > 0) { //root with Discriminant that > 0
            result[0] = ((-params[1] + Math.sqrt(discriminant)) / (2 * params[0]));
            result[1] = ((-params[1] - Math.sqrt(discriminant)) / (2 * params[0]));
            System.out.println("X1 = " + result[0] + " X2 = " + result[1]);
        } else { //root with Discriminant that < 0
            System.out.println("equation have only imaginary roots");
        }

    }
    /**
     * method that check equation on lineatity
     *
     * @params argument with X^2
     */
    public static boolean Linearity(double[] params) {
        boolean linear = false;
        if (Double.isInfinite(1 / params[0])) {
            System.out.println("equation is not quadratic");
            linear = true;
        }
        return linear;
    }
}

