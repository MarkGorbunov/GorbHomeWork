package eight;

import eight.commands.*;

import java.util.*;

/**
 * class that contain entrance in programm
 * @author Gorbunov on 11.10.2016.
 */
public class Main {
    /**
     * method that ask user about goods,for entered commands display command results
     * until users write exit
     */
    public static void main(String[] args) {
        try {
            Initializer initializer = new Initializer();
            initializer.setGoods();
            ArrayList<Commands> commands = new ArrayList<>();
            commands.add(new CountTypes());
            commands.add(new CountAll());
            commands.add(new AveragePrice());
            commands.add(new AveragePriceType());

            new CommandsPerformer(initializer.getList(), commands);
        } catch (Exception e) {
            System.out.println("Error!!");
        }

    }
}
