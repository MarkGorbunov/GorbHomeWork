import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
    private long timeSpent;
    private int timeOut;

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
        TextForOutPut textForOutPut = new TextForOutPut();
        for (int i = 0; i < nodes.getLength(); i++) {
            NamedNodeMap map = nodes.item(i).getAttributes();
            String url = map.getNamedItem("attribute1").getNodeValue();
            if (map.getNamedItem("name").getNodeValue().equals("open")) {
                try {
                    timeOut = Integer.parseInt(map.getNamedItem("attribute2").getNodeValue());
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
            if (map.getNamedItem("name").getNodeValue().equals("CheckLinkPresentByHref")) {
                String argument = map.getNamedItem("attribute1").getNodeValue();
                long start = System.currentTimeMillis();
                if (command.checkLinkHref(argument, driver) == true) {
                    long timeSpent = System.currentTimeMillis() - start;
                    textForOutPut.textForByHref(argument, timeSpent);
                } else {
                    long timeSpent = System.currentTimeMillis() - start;
                    textForOutPut.textForIncorrectByHref(argument, timeSpent);
                }
            }
            if (map.getNamedItem("name").getNodeValue().equals("CheckLinkPresentByName")) {
                String argument = map.getNamedItem("attribute1").getNodeValue();
                long start = System.currentTimeMillis();
                if (command.checkLinkByName(argument, driver) == true) {
                    long timeSpent = System.currentTimeMillis() - start;
                    textForOutPut.textForByName(argument, timeSpent);
                } else {
                    long timeSpent = System.currentTimeMillis() - start;
                    textForOutPut.textForIncorrectByName(argument, timeSpent);
                }
            }
            if (map.getNamedItem("name").getNodeValue().equals("CheckPageTitle")) {
                String argument = map.getNamedItem("attribute1").getNodeValue();
                long start = System.currentTimeMillis();
                if (command.checkTitle(argument, driver) == true) {
                    long timeSpent = System.currentTimeMillis() - start;
                    textForOutPut.textForTitle(argument, timeSpent);
                } else {
                    long timeSpent = System.currentTimeMillis() - start;
                    textForOutPut.textForIncorrectTitle(argument, timeSpent);
                }
            }
            if (map.getNamedItem("name").getNodeValue().equals("CheckPageContains")) {
                String argument = map.getNamedItem("attribute1").getNodeValue();
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