import java.util.Scanner;

/**
 * @author Gorbunov on 04.10.2016.
 * class that
 */
public class Triangle {
    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);
            System.out.println("input first line ");
            double a = in.nextDouble();
            System.out.println("input next line ");
            double b = in.nextDouble();
            System.out.println("input next line ");
            double c = in.nextDouble();
            if (((a + b) > c && (a + c) > b && (b + c) > a)
                    && ((a > 0) && (b > 0) && (c > 0))) {
                typeChecking(a, b, c);
            } else {
                System.out.println("error!! on the entered parameters is impossible to construct a triangle");
            }
        } catch (Exception ex) {
            System.out.println("error!! input arguments must be numbers");
        }


    }

    public static void typeChecking(double a, double b, double c) {
        if (a == b && b == c) {
            System.out.println("the triangle is equilateral");
        } else if ((a == b || a == c || c == b) && !(a == b && b == c)) {
            System.out.println("the triangle is isosceles");
        } else {
            System.out.println("the triangle is normal");
        }
    }
}

