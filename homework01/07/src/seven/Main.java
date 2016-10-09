package seven;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class of application.In that class entered line and locate entry point.
 *
 * @author Gorbunov on 09.10.2016.
 */
public class Main {
    /**
     * this method asks for enter a line and checks it for compliance with the rules
     */
    public static void main(String[] args) {
        System.out.print("inter a line: ");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();      //intered line
        ArrayList<Rule> rulesList = new ArrayList<>();
        rulesList.add(new WithoutNumerals());
        rulesList.add(new OnlyNumerals());
        rulesList.add(new FiveWords());
        rulesList.add(new DictionaryWords());
        for (Rule rule : rulesList) {
            if (rule.inspection(s)) {
                System.out.println(rule.getPassMessage());
            }
        }
        System.out.print("Rules check finished");
    }

}
