package eight.commands;

import eight.Goods;

import java.util.*;

/**
 * class that calculate average price of all goods
 * @author Gorbunov on 12.10.2016.
 */
public class AveragePrice extends Commands {

    private static final String AVERAGE_PRICE = "average price";

    /**
     * method that calculate average price of all goods
     * @param list contains information about goods that user entered
     */
    public void averagePrice(ArrayList<Goods> list) {
        double cost = 0;
        for (Goods s : list) {
        double sumofonetype = s.getCount() * s.getCost();
            cost += sumofonetype;
        }
        System.out.println("Average cost is " + cost);
    }

    /**
     *method that display average cost of all goods
     * @param line contain information about command that user entered
     * @param goods contains information about goods that user entered
     */
    public void checksAndPerform(String line, ArrayList<Goods> goods) {
        if (line.equals(AVERAGE_PRICE)) {
            averagePrice(goods);
        }
    }

}
