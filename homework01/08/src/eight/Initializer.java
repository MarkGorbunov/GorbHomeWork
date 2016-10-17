package eight;

import java.util.*;

/**
 * class that initialize information about goods
 * @author Gorbunov on 11.10.2016.
 */
public class Initializer {
    private ArrayList<Goods> list = new ArrayList<>();
    String type, name;
    int count;
    double cost;

    /**
     * method that initialize information about goods after entered of goods ask would you like enter othe goods.
     */
    public void setGoods() {
        Scanner in = new Scanner(System.in);
        String commandforadd;
        do {
            System.out.println("Enter product's type");
            type = in.next();
            System.out.println("Enter product's name");
            name = in.next();
            System.out.println("Enter product's count");
            count = in.nextInt();
            System.out.println("Enter product's cost");
            cost = in.nextDouble();
            System.out.println("Input 'yes' if you want to repeat input, any key to continue)");
            commandforadd = in.next();
            list.add(new Goods(type, name, count, cost));
        } while (commandforadd.equals("yes"));
    }

    /**
     * method that return list of entered goods
     * @return list of goods
     */
    public ArrayList<Goods> getList() {
        return list;
    }
}
