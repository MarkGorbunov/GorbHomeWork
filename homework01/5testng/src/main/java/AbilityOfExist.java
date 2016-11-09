import java.math.BigDecimal;
import java.math.MathContext;

import static java.lang.Double.NEGATIVE_INFINITY;

/**
 * class that check ability of triangle to exist
 */
public class AbilityOfExist {

    /**
     * method that check ability of triangle to exist
     *
     * @param firstLine  first line of triangle
     * @param secondLine second line of triangle
     * @param thirdLine  third line of triangle
     * @throws Exception auto generated exception when working with file
     */
    public void checkExist(double firstLine, double secondLine, double thirdLine) throws Exception {
        BigDecimal first = new BigDecimal(firstLine, MathContext.DECIMAL64);
        BigDecimal second = new BigDecimal(secondLine, MathContext.DECIMAL64);
        BigDecimal third = new BigDecimal(thirdLine, MathContext.DECIMAL64);
        if (!((first.add(second).compareTo(third)) == 1 &&
                (first.add(third).compareTo(second)) == 1 &&
                (second.add(third).compareTo(first)) == 1)
                || !((firstLine > 0) && (secondLine > 0) && (thirdLine > 0))) {
            throw new Exception("triangle cannot exist");
        }
        if ((Double.isInfinite(firstLine) || Double.isNaN(firstLine))
                || (Double.isInfinite(secondLine) || Double.isNaN(secondLine))
                || (Double.isInfinite(thirdLine) || Double.isNaN(thirdLine))) {
            throw new Exception("incorrect lines");
        }
    }

}
