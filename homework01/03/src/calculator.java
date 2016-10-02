import java.util.Scanner;
/**
 * Created by Gorbunov on 02.10.2016.
 * class which conducts mathematical operations
 */
public class calculator {
    /**
     * methods that displays all mathematicial operation
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        double b = in.nextDouble();

        System.out.println("Sum = " + sum(a, b));
        System.out.println("Difference = " + difference(a, b));
        System.out.println("multiplication = " + multiplication(a, b));
        if (b == 0) { //check division by zero
            System.out.println("division by zero is forbidden");
        } else
            System.out.println("division = " + division(a, b));
    }

    public static double sum(double a, double b) {  //operation of summ
        return (a + b);
    }

    public static double difference(double a, double b) {  //operation of difference
        return (a - b);
    }

    public static double multiplication(double a, double b) {  //operation of multiplication
        return (a * b);
    }

    public static double division(double a, double b) {  //operation of division
        return (a / b);
    }

}
