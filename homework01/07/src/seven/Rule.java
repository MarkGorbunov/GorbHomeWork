package seven;

/**
 * abstract class that represents rule
 * Created by Gorbunov on 09.10.2016.
 */
public abstract class Rule {
    /**
     * method check if entered line compliance with each rule
     * @param  s - entered line
     */
    public abstract boolean inspection(String s);

    /**
     * method that return some message if entered line corresponds for the some rule
     */
    public abstract String getPassMessage();
}
