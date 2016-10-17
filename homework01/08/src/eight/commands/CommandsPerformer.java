package eight.commands;

import eight.*;

import java.util.*;
/**
 * class that allow user enter a command
 * @author Gorbunov on 11.10.2016.
 */
public class CommandsPerformer {
    /**
     * Creates an object of CommandsPerformer, gets list of goods, list of commands
     * and performs commands, got from user.
     * @param goods  contain information about goods that user entered
     * @param commands  contain information about command that user entered
     */
    public CommandsPerformer(ArrayList<Goods> goods, ArrayList <Commands> commands) {
        Scanner in = new Scanner(System.in);
        String line;
        do {
            System.out.println("Set command (input 'exit' to exit)(input 'commands' to see list of commands:");
            line = in.nextLine();
            for (Commands c : commands) {
                c.checksAndPerform(line, goods);
                if(line.equals("commands")) {
                    System.out.println("(average price) (count type)(average price of type)(count all)");
                }
            }
        } while (!(line.equals("exit")));

        System.out.println("End of works of programm");
        in.close();
    }
}

