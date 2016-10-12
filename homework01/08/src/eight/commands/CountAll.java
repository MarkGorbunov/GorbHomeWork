package eight.commands;


import eight.Goods;

import java.util.ArrayList;

/**
 * class that calculate count of all goods
 * @author Gorbunov on 12.10.2016.
 */
public class CountAll extends Commands {

    private static final String COUNT_ALL = "count all";

    /**
     * method that calculate acount of all goods
     * @param list contains information about goods that user entered
     */
    public void countAllGoods(ArrayList<Goods> list) {
        int count = 0;
        for (Goods p : list) {
            count += p.getCount();
        }
        System.out.println("Count of all products is " + count);
    }

    /**
     * method that check command and display commands result
     * @param line  contain information about command that user entered
     * @param goods contains information about goods that user entered
     */
    public void checksAndPerform(String line, ArrayList<Goods> goods) {
        if (line.equals(COUNT_ALL)) {
            countAllGoods(goods);
        }
    }
}