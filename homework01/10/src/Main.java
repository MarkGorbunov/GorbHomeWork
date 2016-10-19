import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * class that have enter point in programm,checks ip for correct,and get max value of response.
 *
 * @author Gorbunov on 19.10.2016.
 */
public class Main {
    /**
     * method that checks ip for correct and get max value of response.
     *
     * @param args ipAdress that checks
     */
    public static void main(String[] args) {
        int max = 10;
        try {
            ArrayList<Server> serversList = new ArrayList<>();
            if (args.length == 0) {
                BufferedReader reader = new BufferedReader(new FileReader("servers.txt"));
                String line;
                while ((line = reader.readLine()) != null) {
                    if (Server.checkOfIp(line)) {
                        serversList.add(new Server(line));
                    }
                }
            } else {
                for (int i = 0; i < args.length; i++) {
                    if (Server.checkOfIp(args[i])) {
                        serversList.add(new Server(args[i]));
                    }
                }
            }
            for (Server server : serversList) {
                if (server.getResponse() > max) {
                    max = server.getResponse();
                }
            }
            CreateHtmlDoc html = new CreateHtmlDoc(serversList, max);
            html.writeHtml();
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
