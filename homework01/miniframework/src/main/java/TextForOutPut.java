/**
 * Created by Gorbunov on 17.12.2016.
 */
public class TextForOutPut {
    static String inTxt = "";
    static int failTest;
    static int passTest;
    static long AllTime;

    void textForOpen(String url, int timeOut, long timeSpent) {
        inTxt = inTxt + "+ " + "[" + "open" + " " + '"' + url + '"' + " "
                + '"' + timeOut + '"' + "]" + timeSpent + System.getProperty("line.separator");
        passTest++;
        AllTime = AllTime + timeSpent;
    }

    void textForIncorrectOpen(String url, long timeSpent) {
        inTxt = inTxt + "! " + "[" + "open" + " " + '"' + url + '"' + " "
                + '"' + +'"' + "]" + timeSpent + System.getProperty("line.separator");
        failTest++;
        AllTime = AllTime + timeSpent;
    }

    void textForByHref(String argument, long timeSpent) {
        inTxt = inTxt + "+ " + "[" + '"' + "checkLinkPresentByHref" + '"' + " " +
                '"' + argument + '"' + "]" + timeSpent + System.getProperty("line.separator");
        passTest++;
        AllTime = AllTime + timeSpent;
    }

    void textForIncorrectByHref(String argument, long timeSpent) {
        inTxt = inTxt + "! " + "[" + '"' + "checkLinkPresentByHref" + '"' + " " +
                '"' + argument + '"' + "]" + timeSpent + System.getProperty("line.separator");
        failTest++;
        AllTime = AllTime + timeSpent;
    }

    void textForByName(String argument, long timeSpent) {
        inTxt = inTxt + "+ " + "[" + '"' + "CheckLinkPresentByName" + '"' + " " +
                '"' + argument + '"' + "]" + timeSpent + System.getProperty("line.separator");
        passTest++;
        AllTime = AllTime + timeSpent;
    }

    void textForIncorrectByName(String argument, long timeSpent) {
        inTxt = inTxt + "! " + "[" + '"' + "CheckLinkPresentByName" + '"' + " " +
                '"' + argument + '"' + "]" + timeSpent + System.getProperty("line.separator");
        failTest++;
        AllTime = AllTime + timeSpent;
    }

    void textForTitle(String argument, long timeSpent) {
        inTxt = inTxt + "+ " + "[" + '"' + "CheckPageTitle" + '"' + " " + '"'
                + argument + '"' + "]" + timeSpent + System.getProperty("line.separator");
        passTest++;
    }

    void textForIncorrectTitle(String argument, long timeSpent) {
        inTxt = inTxt + "! " + "[" + '"' + "CheckPageTitle" + '"' + " " + '"'
                + argument + '"' + "]" + timeSpent + System.getProperty("line.separator");
        failTest++;
        AllTime = AllTime + timeSpent;
    }

    void textForTextContain(String argument, long timeSpent) {
        inTxt = inTxt + "+ " + "[" + '"' + "CheckPageContains" + '"' + " " +
                '"' + argument + '"' + "]" + timeSpent + System.getProperty("line.separator");
        passTest++;
        AllTime = AllTime + timeSpent;
    }

    void textForIncorrectTextContain(String argument, long timeSpent) {
        inTxt = inTxt + "! " + "[" + '"' + "CheckPageContains" + '"' + " " +
                '"' + argument + '"' + "]" + timeSpent + System.getProperty("line.separator");
        failTest++;
        AllTime = AllTime + timeSpent;
    }


    /**
     * method that return information for log file
     *
     * @return information for log file
     */
    public String getInTxt() {
        return inTxt;
    }

    /**
     * method that return number of failed test
     *
     * @return number of fail test
     */
    public int getFailTest() {
        return failTest;
    }

    /**
     * method that return number of passed test
     *
     * @return number of fail test
     */
    public int getPassTestTest() {
        return passTest;
    }

    /**
     * method that return all time spend for test
     *
     * @return all time spend for test
     */
    public double getAllTime() {
        return AllTime;
    }

}
