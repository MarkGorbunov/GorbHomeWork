package seven;

/**
 * class that check intered line for contain only numerals and return message if it true
 * @author by Gorbunov on 09.10.2016.
 */
public class OnlyNumerals extends Rule {
    /**
     * method check if entered line compliance with this rule(contain only numerals)
     * String s - entered line
     */
    public boolean inspection(String s) {

       String[] str = s.split("\\s+|\\,+");
        for (String i : str) {
            if (!i.matches("^\\d?$")) {
                return false;
            } else if (str[0].equals("")){
                return false;
            }
        }
        return true;

    }

    /**
     * method that return some message if enered line corresponds for this rule (contain only numerals)
     */
    public String getPassMessage() {
        return Message.onlyNumeralsMessage;
    }
}