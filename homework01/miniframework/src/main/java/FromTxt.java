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
    WebDriver driver;
    private long timeSpent;
    private int timeOut;

    /**
     * method that fill timeSpent,failTest,pasTest information about falled or not test
     */
    public void readFromTxt() throws IOException {
        Path pathToFile = Paths.get("E:/project/miniframework/ArgFromTxt.txt");
        List<String> lines = Files.readAllLines(pathToFile, StandardCharsets.UTF_8);
        Command command = new Command();
        TextForOutPut textForOutPut = new TextForOutPut();
        for (String line : lines) {
            String[] argumentInTxt = line.split(" ");
            String url = String.valueOf(argumentInTxt[1]);
            if (argumentInTxt[0].equals("open")) {
                try {
                    timeOut = Integer.parseInt(argumentInTxt[2]);
                    driver = new FirefoxDriver();
                    driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
                    long start = System.currentTimeMillis();
                    driver.get(url);
                    timeSpent = System.currentTimeMillis() - start;
                    textForOutPut.textForOpen(url, timeOut, timeSpent);
                } catch (Exception e) {
                    textForOutPut.textForIncorrectOpen(url, timeSpent);
                }
            }
            if (argumentInTxt[0].equals("CheckLinkPresentByHref")) {
                String argument = argumentInTxt[1];
                long start = System.currentTimeMillis();
                if (command.checkLinkHref(argument, driver) == true) {
                    long timeSpent = System.currentTimeMillis() - start;
                    textForOutPut.textForByHref(argument, timeSpent);
                } else {
                    long timeSpent = System.currentTimeMillis() - start;
                    textForOutPut.textForIncorrectByHref(argument, timeSpent);
                }
            }
            if (argumentInTxt[0].equals("CheckLinkPresentByName")) {
                String argument = argumentInTxt[1];
                long start = System.currentTimeMillis();
                if (command.checkLinkByName(argument, driver) == true) {
                    long timeSpent = System.currentTimeMillis() - start;
                    textForOutPut.textForByName(argument, timeSpent);
                } else {
                    long timeSpent = System.currentTimeMillis() - start;
                    textForOutPut.textForIncorrectByName(argument, timeSpent);
                }
            }

            if (argumentInTxt[0].equals("CheckPageTitle")) {
                String argument = argumentInTxt[1];
                long start = System.currentTimeMillis();
                if (command.checkTitle(argument, driver) == true) {
                    long timeSpent = System.currentTimeMillis() - start;
                    textForOutPut.textForTitle(argument, timeSpent);
                } else {
                    long timeSpent = System.currentTimeMillis() - start;
                    textForOutPut.textForIncorrectTitle(argument, timeSpent);
                }
            }
            if (argumentInTxt[0].equals("CheckPageContains")) {
                String argument = argumentInTxt[1];
                long start = System.currentTimeMillis();
                if (command.checkPageContains(argument, driver) == true) {
                    long timeSpent = System.currentTimeMillis() - start;
                    textForOutPut.textForTextContain(argument, timeSpent);
                } else {
                    long timeSpent = System.currentTimeMillis() - start;
                    textForOutPut.textForIncorrectTextContain(argument, timeSpent);
                }
            }
        }
        driver.close();
}


}
