import java.io.IOException;

/**
 * Class that consist header and footer of table,also fill html  with information about size,name,date of
 * creation, file or folder.
 *
 * @author Gorbunov on 17.10.2016.
 */
public class HtmlDocument {
    //header of table
    private String header = "<html>" +
            "<head>" +
            "<meta charset=\"utf-8\"> " +
            "<title>consists of folder</title>" +
            "</head>" +
            "<bode>" +
            "<table border=\"0\"  align=\"center\" >\n" +
            "<tr bgcolor=\"#cecfce\" align=\"center\" valign=\"top\" >\n" +
            "<th width=\"20%\" >ИМЯ</th>\n" +
            "<th width=\"20%\">ТИП</th>\n" +
            "<th width=\"20%\">ДАТА <br> СОЗДАНИЯ</th>\n" +
            "<th width=\"20%\">РАЗМЕР (в Kb)</th>\n" +
            "</tr>";
    //footer of table
    private String footer = "</table>" +
            "</body>" +
            "</html>";
    //filling of table
    String html = "";
    String color1 = "#efefef";
    String color2 = "#f7f7f7";

    /**
     * * method that fill html  with information about size,name,date of creation, file or folder.
     *
     * @param type of founded file or folder
     * @param size of founded file or folder
     * @param name of founded file or folder
     * @param date of creation  founded file or folder
     * @throws IOException IOException exception that autogenerated when working with file
     */
    public void addLine(String type, long size, String name, String date) throws IOException {
        int count = 0;
        html = html + "<tr bgcolor=" + ((count % 2) == 0 ? color1 : color2) + "><td>" +
                name +//name
                "</td><td>" + type + "</td><td>" +//type
                date + "</td><td>" //date
                + size / 1024 + "</td></tr>";//size
        count++;
    }

    /**
     * method that return html table
     * @return html table
     */
    public String getHtml() {
        return header + html + footer;
    }
}

