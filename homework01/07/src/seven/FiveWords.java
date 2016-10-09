package seven;

/**
 * class that check intered line for contain 5 or more words and return message if it true
 * @author by Gorbunov on 09.10.2016.
 */
public class FiveWords extends Rule {
    /**
     * method check if entered line compliance with this rule(contain 5 or more words)
     * String s - entered line
     */
    public boolean inspection(String s) {
        String[] str = s.split("\\s+|\\,+");
        int a = str.length;
        if (a >= 5) {
            return true;
        }
        return false;
    }

    /**
     * method that return some message if enered line corresponds for this rule (contain 5 or more words)
     */
    public String getPassMessage() {
        return Message.fivewordsmessage;
    }
}

