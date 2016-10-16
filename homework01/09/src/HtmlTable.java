
import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;

/**
 * Class that consist header and footer of table,also fill html  with information about size,name,date of
 * creation, file or folder.
 *
 * @author Gorbunov on 15.10.2016.
 */
public class HtmlTable {
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

    /**
     * method that fill html  with information about size,name,date of creation, file or folder.
     *
     * @return return all table
     * @throws IOException IOException exception that autogenerated when workin with file
     */
    public String getHtml() throws IOException {

        int count = 0;
        try {
            String userDirectory = System.getProperty("user.dir");
            File dir = new File(userDirectory );
            File[] listOfFiles = dir.listFiles();
            for (File item : listOfFiles) {//cycle across folder
                Path path = item.toPath();
                BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM.dd.yyyy");
                String creationDate = simpleDateFormat.format(attr.creationTime().toMillis());
                if ((count % 2) == 0) {  //if line odd bgcolor="#efefef"
                    if (item.isDirectory()) {  //check for directory(folder)
                        html = html + "<tr bgcolor=\"#efefef\"><td>" + item.getName() +//name
                                "</td><td>DIR</td><td>" + creationDate + "</td><td>" //date
                                + getFolderSize(item)/1024 + "</td></tr>";//size
                        count++;
                    } else {  //check for file
                        html = html + "<tr bgcolor=\"#efefef\"><td>" + item.getName() +//name
                                "</td><td>FILE</td><td>" + creationDate + "</td><td>" +//date
                                getFolderSize(item)/1024 + "</td></tr>";//size
                        count++;
                    }
                } else {  //if line even bgcolor="#f7f7f7"
                    if (item.isDirectory()) {  //check for directory(folder)
                        html = html + "<tr bgcolor=\"#f7f7f7\"><td>" + item.getName() +//name
                                "</td><td>DIR</td><td>" + creationDate + "</td><td>" +//date
                                item.length()/1024 + "</td></tr>";//size
                        count++;
                    } else {  //check for file
                        html = html + "<tr bgcolor=\"#f7f7f7\"><td>" + item.getName() +//name
                                "</td><td>FILE</td><td>" + creationDate + "</td><td>" +//date
                                item.length()/1024 + "</td></tr>";//size
                        count++;
                    }
                }

            }
        } catch (Exception e) {
            System.out.println("Error in input parameters");
        }
        return header + html + footer;
    }

    /**
     * method that goes around the contents of folders and sum size of all content,return sum
     *
     * @param item folder that checked
     * @return size of folder
     */
    private long getFolderSize(File item) {
        long size = 0;
        File[] folderEntries = item.listFiles();
        if (folderEntries != null) {
            for (File entry : folderEntries) {
                if (entry.isFile()) {
                    size += entry.length();
                }
                if (entry.isDirectory()) {
                    size += getFolderSize(entry);
                }
            }
        }
        return size;
    }
}

