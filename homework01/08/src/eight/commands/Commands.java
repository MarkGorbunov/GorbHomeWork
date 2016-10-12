package eight.commands;

import eight.Goods;

import java.util.ArrayList;

/**
 * abstract class that has only one method performCommand
 * @author Gorbunov on 11.10.2016.
 */
public abstract class Commands {
    /**
     * method that overridden by inheritors
     * @param line contain information about command that user entered
     * @param goods contains information about goods that user entered
     */
    public abstract void checksAndPerform(String line, ArrayList<Goods> goods);
}
