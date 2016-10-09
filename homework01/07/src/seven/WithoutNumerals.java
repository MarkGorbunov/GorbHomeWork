package seven;

/**
 * class that check intered line for didn't contain numerals and return message if it true
 * @author by Gorbunov on 09.10.2016.
 */
public class WithoutNumerals extends Rule {
    /**
     * method check if entered line compliance with this rule(didn't contain numerals)
     * String s - entered line
     */
    public boolean inspection(String s) {
        return s.matches("^\\D+$");
    }

    /**
     * method that return some message if enered line corresponds for this rule (didn't contain numerals)
     */
    public String getPassMessage() {
        return Message.withoutnumeralsmessage;
    }
}
