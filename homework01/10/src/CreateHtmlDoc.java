import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * class that make file and write in it the table.
 * @author Gorbunov on 19.10.2016.
 */
public class CreateHtmlDoc {
    private String header = "<html>" +
            "<head>" +
            "<meta charset=\"utf-8\"> " +
            "<title>consists of folder</title>" +
            "</head>" +
            "<bode>" +
            "<table border=\"0\"  align=\"center\" >\n" +
            "<tr bgcolor=\"#cecfce\" align=\"center\" valign=\"top\" >\n" +
            "<th width=\"20%\" >Server</th>\n" +
            "<th width=\"20%\">Response,ms</th>\n" +
            "</tr>";
    private String footer = "</table>" +
            "</body>" +
            "</html>";
    String html = "";
    String color="";
    String color1 = "#f7f7f7";
    String color2 = "#efefef";
    String color3 = "#ff0000";
    int max;

    /**
     * constructor that call htmlDoc
     * @param servers list of ipAdress
     * @param max value of response
     */
    CreateHtmlDoc(ArrayList<Server> servers,int max) {
        htmlDoc(servers,max);
    }

    /**
     * create file Server.html and write information in it
     * @throws IOException autogenerated when working with file
     */
    public void writeHtml() throws IOException {
        try {
            FileWriter writer = new FileWriter("Servers.html", false);
            writer.write(html);
            writer.flush();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    /**
     * method that fill table illuminate line with max response
     * @param servers list of ipAdress
     * @param max value of response
     */
    public void htmlDoc(ArrayList<Server> servers,int max) {
        for (int i = 0; i < servers.size(); i++) {
            color = (i % 2 == 0) ? color1 :color2;
                html = html + "<tr bgcolor=" + ((servers.get(i).getResponse() == max) ? color3 : color) + "><td>"
                        + servers.get(i).getAddress() + "</td><td>" + servers.get(i).getResponse() + "</td></tr>";
        }
        html =header +html +footer;
    }


}

