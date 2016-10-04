import java.util.Scanner;

/**
 * C@author Gorbunov on 04.10.2016.
 */
public class QuadEquation {

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
            if (Discriminant(a, b, c) > 0) {

                double x1 = ((-b + Math.sqrt(Discriminant(a, b, c))) / (2 * a));
                double x2 = ((-b - Math.sqrt(Discriminant(a, b, c))) / (2 * a));
                System.out.println("roots of equation:" + "x1 = " + x1 + "   x2 = " + x2);
            } else if (Double.isInfinite(1 / Discriminant(a, b, c))) {
                double x1 = ((-b + Math.sqrt(Discriminant(a, b, c))) / (2 * a));
                System.out.println("roots of equation:" + "x1 = x2 =" + x1);
            } else {
                System.out.println("equation have only imaginary roots");
            }
        } catch (Exception ex) {
            System.out.println("error!! input arguments must be numbers");
        }
    }

    public static double Discriminant(double a, double b, double c) {
        double D;
        D = (b * b - 4 * a * c);
        return D;
       /* if (D > 0) {
           double x1= ((-b + Math.sqrt(D)) /( 2 * a));
           double x2= ((-b - Math.sqrt(D)) / (2 * a));
            return(x1,x2)
        } else if (Double.isFinite(1/D) ){

        } else {

        }*/
    }

    public static void Linearity(double inf) {
        if (Double.isInfinite(1 / inf)) {
            System.out.println("equation is not quadratic");
            System.exit(0);
        }
    }
}
