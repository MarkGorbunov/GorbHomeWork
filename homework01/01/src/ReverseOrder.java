/**
 * @author Gorbunov on 02.10.2016.
 * Class that displays the parameters in reverse order
 */
public class ReverseOrder {
    /**
     * method that displays the parameters in reverse order(parameters receive from command line)
     * @param args patameters that input from command line
     */
    public static void main(String[] args) {
        for(int i = args.length-1; i >= 0; i--) {
            System.out.println("argument " + i + " = " + args[i]);
        }
    }
}