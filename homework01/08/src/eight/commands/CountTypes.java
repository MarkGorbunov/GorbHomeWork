package eight.commands;

import eight.Goods;

import java.util.ArrayList;

/**
 * class that calculate count types of all goods
 * @author Gorbunov on 12.10.2016.
 */
public class CountTypes extends Commands {

    private static final String COUNT_TYPE = "count type";

    /**
     * method that calculate count types of all goods
     * @param goods contains information about goods that user entered
     */
    public void countTypeGoods(ArrayList<Goods> goods) {
        int typeCount = 0;
        Goods[] typeGoods = new Goods[goods.size()];
        for (int i = 0; i < typeGoods.length; i++) {
            typeGoods[i] = goods.get(i);
        }


        for (int i = 0; i < typeGoods.length; i++) {
            for (int j = i + 1; j < typeGoods.length; j++) {
                if (typeGoods[i].getType().equals(typeGoods[j].getType())) {
                    typeCount++;
                }
            }
        }
        System.out.println("Count of types is " + (typeGoods.length - typeCount));
    }

    /**
     * method that check command and display commands result
     * @param line  contain information about command that user entered
     * @param goods contains information about goods that user entered
     */
    public void checksAndPerform(String line, ArrayList<Goods> goods) {
        if (line.equals(COUNT_TYPE)) {
            countTypeGoods(goods);
        }
    }
}
