import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * class that read arguments from command line,set time out ,return information about test
 */
public class FromTxt {
    private String inTxt = "";
    WebDriver driver;
    private long AllTime;
    private long timeSpent;
    private int failTest;
    private int passTest;
    private int timeOut;

    /**
     * method that fill timeSpent,failTest,pasTest information about falled or not test
     */
    public void readFromTxt() throws IOException {
        Path pathToFile = Paths.get("C:/Users/Mark/IdeaProjects/miniFrameWork1/ArgFromTxt.txt");
        List<String> lines = Files.readAllLines(pathToFile, StandardCharsets.UTF_8);
        Command command = new Command();
        for (String line : lines) {
            String[] argumentInTxt = line.split(" ");
            String url = String.valueOf(argumentInTxt[1]);
            if (argumentInTxt[0].equals("open")) {
                try {
                    timeOut = Integer.parseInt(argumentInTxt[2]);
                    driver = new ChromeDriver();
                    driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
                    long start = System.currentTimeMillis();
                    driver.get(url);
                    timeSpent = System.currentTimeMillis() - start;
                    AllTime = AllTime + timeSpent;
                    inTxt = inTxt + "+ " + "[" + "open" + " " + '"' + url + '"' + " "
                            + '"' + timeOut + '"' + "]" + timeSpent + System.getProperty("line.separator");
                    passTest++;

                } catch (Exception e) {
                    inTxt = inTxt + "! " + "[" + "open" + " " + '"' + url + '"' + " "
                            + '"' + +'"' + "]" + timeSpent + System.getProperty("line.separator");
                    failTest++;
                }
            }
            if (argumentInTxt[0].equals("CheckLinkPresentByHref")) {
                String argument = argumentInTxt[1];
                long start = System.currentTimeMillis();
                if (command.checkLinkHref(argument, driver) == true) {
                    long timeSpent = System.currentTimeMillis() - start;
                    inTxt = inTxt + "+ " + "[" + '"' + "checkLinkPresentByHref" + '"' + " " +
                            '"' + argument + '"' + "]" + timeSpent + System.getProperty("line.separator");
                    AllTime = AllTime + timeSpent;
                    passTest++;
                } else {
                    long timeSpent = System.currentTimeMillis() - start;
                    inTxt = inTxt + "! " + "[" + '"' + "checkLinkPresentByHref" + '"' + " " +
                            '"' + argument + '"' + "]" + timeSpent + System.getProperty("line.separator");
                    AllTime = AllTime + timeSpent;
                    failTest++;
                }
            }
            if (argumentInTxt[0].equals("CheckLinkPresentByName")) {
                String argument = argumentInTxt[1];
                long start = System.currentTimeMillis();
                if (command.checkLinkByName(argument, driver) == true) {
                    long timeSpent = System.currentTimeMillis() - start;
                    inTxt = inTxt + "+ " + "[" + '"' + "CheckLinkPresentByName" + '"' + " " +
                            '"' + argument + '"' + "]" + timeSpent + System.getProperty("line.separator");
                    AllTime = AllTime + timeSpent;
                    passTest++;
                } else {
                    long timeSpent = System.currentTimeMillis() - start;
                    inTxt = inTxt + "! " + "[" + '"' + "CheckLinkPresentByName" + '"' + " " +
                            '"' + argument + '"' + "]" + timeSpent + System.getProperty("line.separator");
                    AllTime = AllTime + timeSpent;
                    failTest++;
                }
            }

            if (argumentInTxt[0].equals("CheckPageTitle")) {
                String argument = argumentInTxt[1];
                long start = System.currentTimeMillis();
                if (command.checkTitle(argument, driver) == true) {
                    long timeSpent = System.currentTimeMillis() - start;
                    inTxt = inTxt + "+ " + "[" + '"' + "CheckPageTitle" + '"' + " " + '"'
                            + argument + '"' + "]" + timeSpent + System.getProperty("line.separator");
                    AllTime = AllTime + timeSpent;
                    passTest++;
                } else {
                    long timeSpent = System.currentTimeMillis() - start;
                    inTxt = inTxt + "! " + "[" + '"' + "CheckPageTitle" + '"' + " " + '"'
                            + argument + '"' + "]" + timeSpent + System.getProperty("line.separator");
                    AllTime = AllTime + timeSpent;
                    failTest++;
                }
            }
            if (argumentInTxt[0].equals("CheckPageContains")) {
                String argument = argumentInTxt[1];
                long start = System.currentTimeMillis();
                if (command.checkPageContains(argument, driver) == true) {
                    long timeSpent = System.currentTimeMillis() - start;
                    inTxt = inTxt + "+ " + "[" + '"' + "CheckPageContains" + '"' + " " +
                            '"' + argument + '"' + "]" + timeSpent + System.getProperty("line.separator");
                    AllTime = AllTime + timeSpent;
                    passTest++;
                } else {
                    long timeSpent = System.currentTimeMillis() - start;
                    inTxt = inTxt + "! " + "[" + '"' + "CheckPageContains" + '"' + " " +
                            '"' + argument + '"' + "]" + timeSpent + System.getProperty("line.separator");
                    AllTime = AllTime + timeSpent;
                    failTest++;
                }
            }
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
