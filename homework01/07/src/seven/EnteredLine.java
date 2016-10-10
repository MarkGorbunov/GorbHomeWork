package seven;

import java.util.Scanner;

/**
 * class that allow to write a line
 * @author by Gorbunov on 09.10.2016.
 */
public class EnteredLine {
    /**
     * method that ask enter a line and allow to write a line
     * @return entered line
     */
    public String enteredLline() {
        System.out.println("enter a line: ");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}

