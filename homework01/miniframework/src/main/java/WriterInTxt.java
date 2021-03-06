import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * class that write all information in log file
 */
public class WriterInTxt {
    /**
     * method that write all information in log file and convert time to 3 numbers before dot
     * @param s information about test
     * @param failTest number of failed test
     * @param passTest number of passed test
     * @param Alltime time spend for all test
     */
    public void writeIn(String s,int failTest,int passTest,double Alltime) {
        try {
            String pattern = "##0.000";
            DecimalFormat decimalFormat = new DecimalFormat(pattern);
            FileWriter writer = new FileWriter("logfile.txt", false);
            writer.write(s);
            int sum = failTest+passTest;
            double Alltime1 = Alltime/1000;
            String AlltimeBd = decimalFormat.format(Alltime1);
            writer.write("Total test: " + sum + System.getProperty("line.separator"));
            writer.write("Passed/Failed: " + passTest + "/" + failTest + System.getProperty("line.separator"));
            writer.write("Total time: " + AlltimeBd + System.getProperty("line.separator"));
            double avr = Alltime1/sum;
            String avrBd = decimalFormat.format(avr);
            writer.write("Average time: " + avrBd +  System.getProperty("line.separator"));

            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
