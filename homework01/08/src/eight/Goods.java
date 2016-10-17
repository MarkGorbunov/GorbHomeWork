package eight;

import java.math.BigDecimal;

/**
 * Class that has structure of goods. It describes all attributes of goods
 * @author Gorbunov on 11.10.2016.
 */
public class Goods {


    private String type;

    private String name;

    private int count = 0;

    private double cost;

    /**
     * Constructor Goods create object of goods, gets entered parameters
     * of goods and adds information about entered types of goods.
     * @param type type of goods
     * @param name name of goods
     * @param count count of goods
     * @param cost cost of goods
     */
    public Goods(String type, String name, int count, double cost) {

        this.type = type;
        this.name = name;
        this.count = count;
        this.cost = cost;
    }

    /**
     * method that return type of goods
     * @return type of goods
     */
    public String getType() {
        return type;
    }

    /**
     * method that return cost of goods
     * @return cost of goods
     */
    public double getCost() {
        return cost;
    }

    /**
     * method that return count of goods
     * @return count of goods
     */
    public int getCount() {
        return count;
    }
}

