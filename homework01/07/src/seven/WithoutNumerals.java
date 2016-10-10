package seven;

/**
 * class that check intered line for didn't contain numerals and return message if it true
 * @author by Gorbunov on 09.10.2016.
 */
public class WithoutNumerals extends Rule {
    /**
     * method check if entered line compliance with this rule(didn't contain numerals)
     * @param  s - entered line
     * @return true if entered line have some letters
     */
    public boolean inspection(String s) {
        return s.matches("^\\D+$");
    }

    /**
     * method that return some message if entered line corresponds for this rule (didn't contain numerals)
     */
    public String getPassMessage() {
        return Message.withoutnumeralsmessage;
    }
}
