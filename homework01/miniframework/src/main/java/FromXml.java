import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * class that read arguments from command line,set time out ,return information about test
 */
public class FromXml {
    WebDriver driver;
    private String inTxt = "";
    private long AllTime;
    private long timeSpent;
    private int failTest;
    private int passTest;
    private long timeOut;

    /**
     * method that fill timeSpent,failTest,pasTest information about falled or not test
     */
    public void readFromXml() throws Exception {
        File file = new File(System.getProperty("user.dir") + "\\ArgFromXml.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        NodeList nodes = document.getElementsByTagName("command");
        Command command = new Command();
        for (int i = 0; i < nodes.getLength(); i++) {
            NamedNodeMap map = nodes.item(i).getAttributes();
            String url = map.getNamedItem("attribute1").getNodeValue();
            if (map.getNamedItem("name").getNodeValue().equals("open")) {
                try {
                    timeOut = Long.parseLong(map.getNamedItem("attribute2").getNodeValue());
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
                            + '"' + timeOut + '"' + "]" + timeSpent + System.getProperty("line.separator");
                    failTest++;
                }
            }
            if (map.getNamedItem("name").getNodeValue().equals("CheckLinkPresentByHref")) {
                String argument = map.getNamedItem("attribute1").getNodeValue();
                long start = System.currentTimeMillis();
                if (command.checkLinkHref(argument, driver) == true) {
                    long timeSpent = System.currentTimeMillis() - start;
                    inTxt = inTxt + "+ " + "[" + '"' + "CheckLinkPresentByHref" + '"' + " " +
                            '"' + argument + '"' + "]" + timeSpent + System.getProperty("line.separator");
                    AllTime = AllTime + timeSpent;
                    passTest++;
                } else {
                    long timeSpent = System.currentTimeMillis() - start;
                    inTxt = inTxt + "! " + "[" + '"' + "CheckLinkPresentByHref" + '"' + " " +
                            '"' + argument + '"' + "]" + timeSpent + System.getProperty("line.separator");
                    AllTime = AllTime + timeSpent;
                    failTest++;
                }
            }
            if (map.getNamedItem("name").getNodeValue().equals("CheckLinkPresentByName")) {
                String argument = map.getNamedItem("attribute1").getNodeValue();
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
            if (map.getNamedItem("name").getNodeValue().equals("CheckPageTitle")) {
                String argument = map.getNamedItem("attribute1").getNodeValue();
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
            if (map.getNamedItem("name").getNodeValue().equals("CheckPageContains")) {
                String argument = map.getNamedItem("attribute1").getNodeValue();
                long start = System.currentTimeMillis();
                if (command.checkPageContains(argument, driver) == true) {
                    long timeSpent = System.currentTimeMillis() - start;
                    inTxt = inTxt + "+ " + "[" + '"' + "CheckPageContains" + '"' + " " + '"'
                            + argument + '"' + "]" + timeSpent + System.getProperty("line.separator");
                    AllTime = AllTime + timeSpent;
                    passTest++;
                } else {
                    long timeSpent = System.currentTimeMillis() - start;
                    inTxt = inTxt + "! " + "[" + '"' + "CheckPageContains" + '"' + " " + '"'
                            + argument + '"' + "]" + timeSpent + System.getProperty("line.separator");
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
