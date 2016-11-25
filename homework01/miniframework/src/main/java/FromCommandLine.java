
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

/**
 * class that read arguments from command line,set time out ,return information about test
 */

public class FromCommandLine {
    private long AllTime;
    private String inTxt = "";
    WebDriver driver;
    private long timeSpent;
    private int failTest;
    private int passTest;

    /**
     * method that fill timeSpent,failTest,pasTest information about falled or not test
     * @param s arguments from command line
     */
    public void open(String[] s) throws IOException {
        String url = String.valueOf(s[1]);
        int timeOut = Integer.valueOf(s[2]);
        if (String.valueOf(s[0]).equals("open")) {
            driver = new FirefoxDriver();
            driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
            long start = System.currentTimeMillis();
            driver.get(url);
            timeSpent = System.currentTimeMillis() - start;
            AllTime = AllTime + timeSpent;
            inTxt = inTxt + "+ " + "[" + "open" + " " + '"' + url + '"' + " "
                    + '"' + timeOut + '"' + "]" + timeSpent + System.getProperty("line.separator");
            passTest++;
            Command command = new Command();

            for (int j = 3; j < s.length; j = j + 2) {
                String argument = String.valueOf(s[j + 1]);
                if (s[j].equals("CheckLinkPresentByHref")) {
                    long start1 = System.currentTimeMillis();
                    if (command.checkLinkHref(argument, driver) == true) {
                        long timeSpent1 = System.currentTimeMillis() - start1;
                        inTxt = inTxt + "+ " + "[" + '"' + "CheckLinkPresentByHref" + '"' + " " +
                                '"' + argument + '"' + "]" + timeSpent1 + System.getProperty("line.separator");
                        AllTime = AllTime + timeSpent1;
                        passTest++;
                    } else {
                        long timeSpent1 = System.currentTimeMillis() - start1;
                        inTxt = inTxt + "! " + "[" + '"' + "CheckLinkPresentByHref" + '"' + " " +
                                '"' + argument + '"' + "]" + timeSpent1 + System.getProperty("line.separator");
                        AllTime = AllTime + timeSpent1;
                        failTest++;
                    }


                }
                if (s[j].equals("CheckLinkPresentByName")) {
                    long start1 = System.currentTimeMillis();
                    if (command.checkLinkByName(argument, driver)) {
                        long timeSpent1 = System.currentTimeMillis() - start1;
                        inTxt = inTxt + "+ " + "[" + '"' + "CheckLinkPresentByName" + '"' + " " +
                                '"' + argument + '"' + "]" + timeSpent1 + System.getProperty("line.separator");
                        AllTime = AllTime + timeSpent1;
                        passTest++;
                    } else {
                        long timeSpent1 = System.currentTimeMillis() - start1;
                        inTxt = inTxt + "! " + "[" + '"' + "CheckLinkPresentByName" + '"' + " " +
                                '"' + argument + '"' + "]" + timeSpent1 + System.getProperty("line.separator");
                        AllTime = AllTime + timeSpent1;
                        failTest++;
                    }

                }
                if (s[j].equals("CheckPageTitle")) {
                    long start1 = System.currentTimeMillis();
                    if (command.checkTitle(argument, driver) == true) {
                        long timeSpent1 = System.currentTimeMillis() - start1;
                        inTxt = inTxt + "+ " + "[" + '"' + "CheckPageTitle" + '"' + " " +
                                '"' + argument + '"' + "]" + timeSpent + System.getProperty("line.separator");
                        AllTime = AllTime + timeSpent1;
                        passTest++;
                    } else {
                        long timeSpent1 = System.currentTimeMillis() - start1;
                        inTxt = inTxt + "! " + "[" + '"' + "CheckPageTitle" + '"' + " " +
                                '"' + argument + '"' + "]" + timeSpent + System.getProperty("line.separator");
                        AllTime = AllTime + timeSpent1;
                        failTest++;
                    }
                }
                if (s[j].equals("CheckPageContains")) {
                    long start1 = System.currentTimeMillis();
                    if (command.checkPageContains(argument, driver)) {
                        long timeSpent1 = System.currentTimeMillis() - start1;
                        inTxt = inTxt + "+ " + "[" + '"' + "CheckPageContains" + '"' + " " +
                                '"' + argument + '"' + "]" + timeSpent + System.getProperty("line.separator");
                        AllTime = AllTime + timeSpent1;
                        passTest++;
                    } else {
                        long timeSpent1 = System.currentTimeMillis() - start1;
                        inTxt = inTxt + "! " + "[" + '"' + "CheckPageContains" + '"' + " " +
                                '"' + argument + '"' + "]" + timeSpent + System.getProperty("line.separator");
                        AllTime = AllTime + timeSpent1;
                        failTest++;
                    }
                }
            }
        } else {
            inTxt = inTxt + "! " + "[" + "open" + " " + '"' + url + '"' + " "
                    + '"' + timeOut + '"' + "]" + timeSpent + "\n";
            failTest++;
        }
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
     * method that return all time spend for test
     *
     * @return all time spend for test
     */
    public double getAllTime() {
        return AllTime;
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
}
