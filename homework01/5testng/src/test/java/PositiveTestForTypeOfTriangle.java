import junit.framework.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;



public class PositiveTestForTypeOfTriangle {
    private static final String correct = "correct";
    private static final String side_a = "side_a";
    private static final String side_b = "side_b";
    private static final String side_c = "side_c";
    private static final String phrase = "phrase";

    @DataProvider(name = "correctValue")
    public Object[][] getCorrectValueFromXml() throws Exception {
        File inputFile = new File(System.getProperty("user.dir") + "/Data_Provider.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputFile);
        NodeList nodeList = document.getElementsByTagName(correct);
        Object[][] result = new Object[nodeList.getLength()][];
        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap map = nodeList.item(i).getAttributes();
            result[i] = new Object[]{
                    Double.parseDouble(map.getNamedItem(side_a).getNodeValue()),
                    Double.parseDouble(map.getNamedItem(side_b).getNodeValue()),
                    Double.parseDouble(map.getNamedItem(side_c).getNodeValue()),
                    map.getNamedItem(phrase).getNodeValue(),
            };
        }
        return result;
    }

    @Test(dataProvider = "correctValue")
    public void positiveTestForTypeOfTriangle(double a,double b,double c,String expected) throws Exception {
        TypeChecking typeChecking = new TypeChecking();
        Assert.assertEquals(typeChecking.checkType(a, b, c), expected);
    }



}