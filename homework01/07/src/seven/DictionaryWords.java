package seven;

/**
 * class that check intered line for contain words from dictionary and return message if it true
 *
 * @author by Gorbunov on 09.10.2016.
 */
public class DictionaryWords extends Rule {
    /**
     * method check if entered line compliance with this rule(contain word(s) from dictionary)
     * @param s - entered line
     * @return true if entered line have words from dictionary
     */
    private static String[] dictionary = {"door", "table", "window"};

    public boolean inspection(String s) {
        String[] str = s.split("\\s+|\\,+");
        for (String w : str) {
            for (int i = 0; i < dictionary.length; i++) {
                if (w.equals(dictionary[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * method that return some message if entered line corresponds for this rule (contain word(s) from dictionary)
     */
    public String getPassMessage() {
        return Message.dictionarywordsmessage;
    }
}
