package seven;

/**
 * class that check intered line for contain 5 or more words and return message if it true
 *
 * @author by Gorbunov on 09.10.2016.
 */
public class FiveWords extends Rule {
    /**
     * method check if entered line compliance with this rule(contain 5 or more words)
     * @param s - entered line
     * @return true if entered line have more than 5 words
     */
    public boolean inspection(String s) {
        String[] str = s.split("\\s+|\\,+");
        if (str.length > 5) {
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

