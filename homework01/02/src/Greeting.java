/**
 * @author Gorbunov on 02.10.2016.
 * class that write Hello with passed parameter
 */
public class Greeting {
    /**
     * method that write Hello with passed parameter (parameter receive from command line)
     */
    public static void main(String[] args) {
        try {
            int i = 0;
            System.out.println("Hello " + args[i]);
        }
        catch(Exception ex){
            System.out.println("incorect input");
        }
    }
}
