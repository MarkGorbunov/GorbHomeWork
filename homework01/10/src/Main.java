import java.io.IOException;
import java.util.ArrayList;

/**
 * class that have enter point in programm,checks ip for correct,and get max value of response.
 * @author Gorbunov on 19.10.2016.
 */
public class Main {
    /**
     * method that checks ip for correct and get max value of response.
     * @param args ipAdress that checks
     */
    public static void main(String[] args) {
        int max = 10;
        try {
            ArrayList<Server> servers = new ArrayList<>();
            for (int i = 0; i < args.length; i++) {
                if (Server.checkOfIp(args[i])) {
                    servers.add(new Server(args[i]));
                    if(servers.get(i).getResponse()> max){
                        max = servers.get(i).getResponse();
                    }
                }
            }
            CreateHtmlDoc html = new CreateHtmlDoc(servers,max);
            html.writeHtml();
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
