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
        if (!((firstLine + secondLine) > thirdLine &&
                (firstLine + thirdLine) > secondLine &&
                (secondLine + thirdLine) > firstLine)
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
