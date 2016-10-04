import java.util.Scanner;

/**
 * @author Gorbunov on 04.10.2016.
 *         class that check the type of triangle and the ability to exist
 */
public class Triangle {
    /**
     * method that check check the type of triangle and the ability to exist
     */
    public static void main(String[] args) {
        try { //check the type of the entered data
            Scanner in = new Scanner(System.in);
            System.out.println("input line of triangle ");
            double a = in.nextDouble();
            double b = in.nextDouble();
            double c = in.nextDouble();
            if (((a + b) > c && (a + c) > b && (b + c) > a) //check the ability to exist
                    && ((a > 0) && (b > 0) && (c > 0))) {
                typeChecking(a, b, c);
            } else {
                System.out.println("error!! on the entered parameters is impossible to construct a triangle");
            }
        } catch (Exception ex) {
            System.out.println("error!! input arguments must be numbers");
        }


    }

    /**
     * method that check the type of triangle
     * @param a first line of triangle
     * @param b second line of triangle
     * @param c third line of triangle
     */
    public static void typeChecking(double a, double b, double c) {
        if (a == b && b == c) { //check on equilateral
            System.out.println("the triangle is equilateral");
        } else if ((a == b || a == c || c == b) && !(a == b && b == c)) { //check on isosceles
            System.out.println("the triangle is isosceles");
        } else {
            System.out.println("the triangle is normal");
        }
    }
}

