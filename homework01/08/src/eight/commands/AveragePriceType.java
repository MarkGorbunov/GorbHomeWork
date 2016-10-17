package eight.commands;

import eight.Goods;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * class that calculate average price of one type of goods
 * @author Gorbunov on 12.10.2016.
 */
public class AveragePriceType extends Commands {

    private static final String AVERAGE_PRICE_TYPE = "average price of type";

    /**
     * method that calculate average price of one type of goods
     * @param list contain information about goods that user entered
     * @param type contain information about goods type that user entered
     */
    public void averagePriceType(ArrayList<Goods> list, String type) {
        double cost = 0;
        for (Goods s : list) {
            if (s.getType().equals(type)) {
                cost = s.getCount() * s.getCost();
            }
        }
        System.out.println("Average cost " + type + " is " + cost);
    }

    /**
     * method that allow users to entered type of goods
     * @return type of goods
     */
    public String enterType() {
        Scanner in = new Scanner(System.in);
        String type = in.next();
        return type;
    }

    /**
     * method that ask user for enter type and display average price goods of this type
     * @param line contain information about command that user entered
     * @param goods contains information about goods that user entered
     */
    public void checksAndPerform(String line, ArrayList<Goods> goods) {
        if (line.equals(AVERAGE_PRICE_TYPE)) {
            System.out.println("enter type");
            averagePriceType(goods, enterType());
        }
    }

}


