import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

public class NegativeTestForInabilityToBuild {
    private static final String incorrect = "incorrect";
    private static final String side_a = "side_a";
    private static final String side_b = "side_b";
    private static final String side_c = "side_c";

    @DataProvider(name = "incorrectValue")
    public Object[][] getIncorrectValueFromXml() throws Exception {
        File file = new File(System.getProperty("user.dir") + "\\Data_Provider.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        NodeList nodes = document.getElementsByTagName(incorrect);
        Object[][] result = new Object[nodes.getLength()][];
        for (int i = 0; i < nodes.getLength(); i++) {
            NamedNodeMap map = nodes.item(i).getAttributes();
            if ("MAX".equals(map.getNamedItem(side_a))) {
                result[i] = new Object[]{
                        Double.MAX_VALUE,
                        Double.parseDouble(map.getNamedItem(side_b).getNodeValue()),
                        Double.parseDouble(map.getNamedItem(side_c).getNodeValue()),
                };
            }
            if ("MAX".equals(map.getNamedItem(side_c))) {
                result[i] = new Object[]{
                        Double.parseDouble(map.getNamedItem(side_a).getNodeValue()),
                        Double.parseDouble(map.getNamedItem(side_b).getNodeValue()),
                        Double.MAX_VALUE,
                };
            }
            if ("MAX".equals(map.getNamedItem(side_b))) {
                result[i] = new Object[]{
                        Double.parseDouble(map.getNamedItem(side_a).getNodeValue()),
                        Double.MAX_VALUE,
                        Double.parseDouble(map.getNamedItem(side_c).getNodeValue()),
                };
            } else {
                result[i] = new Object[]{
                        map.getNamedItem(side_a) == null ?
                                null : Double.parseDouble(map.getNamedItem(side_a).getNodeValue()),
                        map.getNamedItem(side_b) == null ?
                                null : Double.parseDouble(map.getNamedItem(side_b).getNodeValue()),
                        map.getNamedItem(side_c) == null ?
                                null : Double.parseDouble(map.getNamedItem(side_c).getNodeValue()),
                };
            }
        }
        return result;
    }

    @Test(dataProvider = "incorrectValue", expectedExceptions = Exception.class)
    public void negativeTestForIncorrectData(double a, double b, double c) throws Exception {
        AbilityOfExist abilityOfExist = new AbilityOfExist();
        abilityOfExist.checkExist(a, b, c);
    }

}

