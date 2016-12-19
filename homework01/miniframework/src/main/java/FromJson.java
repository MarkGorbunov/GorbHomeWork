
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
    WebDriver driver;
    private long timeSpent;
    private long timeOut1;
    private long timeOut;

    /**
     * method that fill timeSpent,failTest,pasTest information about falled or not test
     */
    public void readFromJson() throws Exception {
        Command command = new Command();
        JSONParser parser = new JSONParser();
        TextForOutPut textForOutPut = new TextForOutPut();
        Object obj = parser.parse(new FileReader("E:/project/miniframework/ArgFromJson.json"));
        JSONObject jsonObj = (JSONObject) obj;
        JSONArray ja = (JSONArray) jsonObj.get("open");
        JSONObject jo = (JSONObject) ja.get(0);
        String url = (String) jo.get("url");
        if (jsonObj.containsKey("open")) {

            timeOut1 = (Long) jo.get("timeOut");
            int timeOut = Math.toIntExact(timeOut1);
            driver = new FirefoxDriver();
            driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
            long start = System.currentTimeMillis();
            driver.get(url);
            textForOutPut.textForOpen(url, timeOut, timeSpent);
            timeSpent = System.currentTimeMillis() - start;
        } else {
            textForOutPut.textForIncorrectOpen(url, timeSpent);
        }

        if (jsonObj.containsKey("CheckLinkPresentByHref")) {
             ja = (JSONArray) jsonObj.get("CheckLinkPresentByHref");
             jo = (JSONObject) ja.get(0);
            String argument = (String) jo.get("CheckLinkPresentByHref");
            long start = System.currentTimeMillis();
            if (command.checkLinkHref(argument, driver) == true) {
                long timeSpent = System.currentTimeMillis() - start;
                textForOutPut.textForByHref(argument, timeSpent);
            } else {
                long timeSpent = System.currentTimeMillis() - start;
                textForOutPut.textForIncorrectByHref(argument, timeSpent);
            }
        }
        if (jsonObj.containsKey("CheckLinkPresentByName")) {
            ja = (JSONArray) jsonObj.get("CheckLinkPresentByName");
            jo = (JSONObject) ja.get(0);
            String argument = (String) jo.get("CheckLinkPresentByName");
            long start = System.currentTimeMillis();
            if (command.checkLinkByName(argument, driver) == true) {

                long timeSpent = System.currentTimeMillis() - start;
                textForOutPut.textForByName(argument, timeSpent);
            } else {
                long timeSpent = System.currentTimeMillis() - start;
                textForOutPut.textForIncorrectByName(argument, timeSpent);
            }

        }

        if (jsonObj.containsKey("CheckPageTitle")) {
            ja = (JSONArray) jsonObj.get("CheckPageTitle");
            jo = (JSONObject) ja.get(0);
            String argument = (String) jo.get("CheckPageTitle");
            long start = System.currentTimeMillis();
            if (command.checkTitle(argument, driver) == true) {
                long timeSpent = System.currentTimeMillis() - start;
                textForOutPut.textForTitle(argument, timeSpent);
            } else {
                long timeSpent = System.currentTimeMillis() - start;
                textForOutPut.textForIncorrectTitle(argument, timeSpent);
            }

        }
        if (jsonObj.containsKey("CheckPageContains")) {
            ja = (JSONArray) jsonObj.get("CheckPageContains");
            jo = (JSONObject) ja.get(0);
            String argument = (String) jo.get("CheckPageContains");
            long start = System.currentTimeMillis();
            if (command.checkPageContains(argument, driver) == true) {
                long timeSpent = System.currentTimeMillis() - start;
                textForOutPut.textForTextContain(argument, timeSpent);
            } else {
                long timeSpent = System.currentTimeMillis() - start;
                textForOutPut.textForIncorrectTextContain(argument, timeSpent);
            }
        }
        driver.close();
    }

}


