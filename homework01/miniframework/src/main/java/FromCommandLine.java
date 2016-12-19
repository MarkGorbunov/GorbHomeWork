
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

/**
 * class that read arguments from command line,set time out ,return information about test
 */

public class FromCommandLine {

    WebDriver driver;
    private long timeSpent;


    /**
     * method that fill timeSpent,failTest,pasTest information about falled or not test
     *
     * @param s arguments from command line
     */
    public void open(String[] s) throws IOException {
        String url = String.valueOf(s[1]);
        int timeOut = Integer.valueOf(s[2]);
        TextForOutPut textForOutPut = new TextForOutPut();
        Command command = new Command();
        if (String.valueOf(s[0]).equals("open")) {
            driver = new FirefoxDriver();
            driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
            long start = System.currentTimeMillis();
            driver.get(url);
            timeSpent = System.currentTimeMillis() - start;
            textForOutPut.textForOpen(url, timeOut, timeSpent);


            for (int j = 3; j < s.length; j = j + 2) {
                String argument = String.valueOf(s[j + 1]);
                if (s[j].equals("CheckLinkPresentByHref")) {
                    long start1 = System.currentTimeMillis();
                    if (command.checkLinkHref(argument, driver) == true) {
                        long timeSpent1 = System.currentTimeMillis() - start1;
                        textForOutPut.textForByHref(argument, timeSpent1);
                    } else {
                        long timeSpent1 = System.currentTimeMillis() - start1;
                        textForOutPut.textForIncorrectByHref(argument, timeSpent1);
                    }


                }
                if (s[j].equals("CheckLinkPresentByName")) {
                    long start1 = System.currentTimeMillis();
                    if (command.checkLinkByName(argument, driver)) {
                        long timeSpent1 = System.currentTimeMillis() - start1;
                        textForOutPut.textForByName(argument, timeSpent1);
                    } else {
                        long timeSpent1 = System.currentTimeMillis() - start1;
                        textForOutPut.textForIncorrectByName(argument, timeSpent1);
                    }

                }
                if (s[j].equals("CheckPageTitle")) {
                    long start1 = System.currentTimeMillis();
                    if (command.checkTitle(argument, driver) == true) {
                        long timeSpent1 = System.currentTimeMillis() - start1;
                        textForOutPut.textForTitle(argument, timeSpent1);
                    } else {
                        long timeSpent1 = System.currentTimeMillis() - start1;
                        textForOutPut.textForIncorrectTitle(argument, timeSpent1);
                    }
                }
                if (s[j].equals("CheckPageContains")) {
                    long start1 = System.currentTimeMillis();
                    if (command.checkPageContains(argument, driver)) {
                        long timeSpent1 = System.currentTimeMillis() - start1;
                        textForOutPut.textForTextContain(argument, timeSpent1);
                    } else {
                        long timeSpent1 = System.currentTimeMillis() - start1;
                        textForOutPut.textForIncorrectTextContain(argument, timeSpent1);
                    }
                }
            }
        } else {
            textForOutPut.textForIncorrectOpen(url, timeSpent);
        }
        driver.close();
    }
}


