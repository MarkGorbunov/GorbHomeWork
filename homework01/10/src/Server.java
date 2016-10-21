import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Random;

/**
 * class that contains ip checker,constructor that get ipAdress and response.
 * @author Gorbunov on 19.10.2016.
 */
public class Server {
    private static int max = 10;
    private static final String IPADDRESS_PATTERN =
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    private String ipAdress;
    private int response;

    /**
     * Constructor gets ipAdress and response
     * @param ipAdress that arrives on the server
     */
    Server(String ipAdress) {
        this.ipAdress = ipAdress;
        ping();
    }

    /**
     * ipAdress getter
     * @return ipAdres
     */
    public String getAddress() {
        return ipAdress;
    }

    /**
     * response getter
     * @return response
     */
    public int getResponse() {
        return response;
    }

    /**
     * method that calculate random value from 10 to 500 and equals it to response
     */
    private void ping() {
        Random random = new Random();
        response = random.nextInt(490) + 10;
    }

    /**
     * method that checks ipAdress for valid
     * @param ipAdress that arrives for checking
     * @return true if ipAdress valid
     */
    public static boolean checkOfIp(String ipAdress) {
        Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
        Matcher matcher = pattern.matcher(ipAdress);
        return matcher.matches();
    }
}

