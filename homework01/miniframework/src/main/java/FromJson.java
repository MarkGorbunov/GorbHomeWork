
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * class that read arguments from command line,set time out ,return information about test
 */
public class FromJson {
    private long AllTime;
    WebDriver driver;
    private String inTxt = "";
    private long timeSpent;
    private int failTest;
    private int passTest;
    private long timeOut;
    /**
     * method that fill timeSpent,failTest,pasTest information about falled or not test
     */
    public void readFromJson() throws Exception {
        Command command = new Command();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("C:/Users/Mark/IdeaProjects/miniFrameWork1/ArgFromJson.json"));
        JSONObject jsonObj = (JSONObject) obj;
        JSONArray ja = (JSONArray) jsonObj.get("open");
        JSONObject jo = (JSONObject) ja.get(0);
        String url = (String) jo.get("url");
        if (jsonObj.containsKey("open")) {
            try {
                timeOut = (Long) jo.get("timeOut");
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
                inTxt = inTxt + "! " + "[" + "[" + "open" + " " + '"' + url + '"' + " " +
                        '"' + timeOut + '"' + timeSpent + "]" + System.getProperty("line.separator");
                failTest++;
            }
        }
        if (jsonObj.containsKey("checkLinkPresentByHref")) {
            String argument = (String) jo.get("checkLinkPresentByHref");
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
        if (jsonObj.containsKey("CheckLinkPresentByName")) {
            String argument = (String) jo.get("CheckLinkPresentByName");
            long start = System.currentTimeMillis();
            if (command.checkLinkByName(argument, driver) == true) {
                try {
                    long timeSpent = System.currentTimeMillis() - start;
                    inTxt = inTxt + "+ " + "[" + '"' + "CheckLinkPresentByName" + '"' + " " +
                            '"' + argument + '"' + "]" + timeSpent + System.getProperty("line.separator");
                    AllTime = AllTime + timeSpent;
                    passTest++;
                } catch (Exception e) {
                    long timeSpent = System.currentTimeMillis() - start;
                    inTxt = inTxt + "! " + "[" + '"' + "CheckLinkPresentByName" + '"' + " "
                            + '"' + argument + '"' + "]" + timeSpent + System.getProperty("line.separator");
                    AllTime = AllTime + timeSpent;
                    failTest++;
                }
            }
        }

        if (jsonObj.containsKey("CheckPageTitle")) {
            String argument = (String) jo.get("CheckPageTitle");
            long start = System.currentTimeMillis();
            if (command.checkTitle(argument, driver) == true) {
                long timeSpent = System.currentTimeMillis() - start;
                inTxt = inTxt + "+ " + "[" + '"' + "CheckPageTitle" + '"' + " " +
                        '"' + argument + '"' + "]" + timeSpent + System.getProperty("line.separator");
                AllTime = AllTime + timeSpent;
                passTest++;
            } else {
                long timeSpent = System.currentTimeMillis() - start;
                inTxt = inTxt + "! " + "[" + '"' + "CheckPageTitle" + '"' + " " +
                        '"' + argument + '"' + "]" + timeSpent + System.getProperty("line.separator");
                AllTime = AllTime + timeSpent;
                failTest++;
            }


        }
        if (jsonObj.containsKey("CheckPageContains")) {
            String argument = (String) jo.get("CheckPageContains");
            long start = System.currentTimeMillis();
            if (command.checkPageContains(argument, driver) == true) {
                long timeSpent = System.currentTimeMillis() - start;
                inTxt = inTxt + "+ " + "[" + '"' + "CheckPageContains" + '"' + " " +
                        '"' + argument + '"' + "]" + timeSpent + "\n";
                AllTime = AllTime + timeSpent;
                passTest++;
            } else {
                long timeSpent = System.currentTimeMillis() - start;
                inTxt = inTxt + "! " + "[" + '"' + "CheckPageContains" + '"' + " " +
                        '"' + argument + '"' + "]" + timeSpent + "\n";
                AllTime = AllTime + timeSpent;
                failTest++;
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


