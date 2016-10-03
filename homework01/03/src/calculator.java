/**
 * @author Gorbunov on 02.10.2016.
 * class which conducts mathematical operations
 */
public class calculator {
    /**
     * methods that displays all mathematicial operation
     */
    public static void main(String[] args) {
        if(args.length == 2) {
            try {
            double a = Double.valueOf(args[0]);
            double b = Double.valueOf(args[1]);
            System.out.println("Sum = " + sum(a, b));
            System.out.println("Difference = " + difference(a, b));
            System.out.println("multiplication = " + multiplication(a, b));
            if (Double.valueOf(division(a,b)).isInfinite()) { //check division by zero
                System.out.println("division by zero is forbidden");
            } else {
                System.out.println("division = " + division(a, b));
            }
            } catch (Exception ex) {
                System.out.println("input arguments must be numbers");
            }
        } else {
            System.out.println("incorrect number of arguments");
        }
    }

    /**
     * calculate sum of parameters
     * @param a first value
     * @param b second value
     * @return sum between a and b
     */
    public static double sum(double a, double b) {
        return (a + b);
    }

    /**
     * calculate difference of parameters
     * @param a first  value
     * @param b second value
     * @return difference between a and b
     */
    public static double difference(double a, double b) {
        return (a - b);
    }

    /**
     * calculate multiplication of parameters
     * @param a first value
     * @param b second value
     * @return multiplication between a and b
     */
    public static double multiplication(double a, double b) {
        return (a * b);
    }

    /**
     * calculate division of parameters
     * @param a first value
     * @param b second value
     * @return division between a and b
     */
    public static double division(double a, double b) {
        return (a / b);
    }

}