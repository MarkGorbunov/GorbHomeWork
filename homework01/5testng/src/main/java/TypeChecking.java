/**
 * class that check  the type of triangle
 */
public class TypeChecking {
    String equilateral = "the triangle is equilateral";
    String isosceles = "the triangle is isosceles";
    String normal = "the triangle is normal";
    /**
     * method that check the type of triangle and return String with type of triangle
     *
     * @param firstLine first line of triangle
     * @param secondLine second line of triangle
     * @param thirdLine third line of triangle
     * @return String in which write type of triangle
     * @throws Exception auto generated exception when working with file
     */
    public String checkType(double firstLine, double secondLine, double thirdLine) throws Exception {
      new AbilityOfExist().checkExist(firstLine,secondLine,thirdLine);
        if (firstLine == secondLine && secondLine == thirdLine) {
            return equilateral;
        } else if ((firstLine == secondLine ||
                firstLine == thirdLine || thirdLine == secondLine)
                && !(firstLine == secondLine && secondLine == thirdLine)) {
            return isosceles;
        }
        return normal;
    }
}

