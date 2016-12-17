import java.io.IOException;
import java.util.Scanner;


/**
 * Main class in that we choose from where we will get our parameters
 */
public class Main {
    /**
     *  method in that we choose from where we will get our parameters
     * @param args for if we choose 1
     */
    public static void main(String[] args) throws Exception {
        System.out.println("write 1 for ger arguments from commandLine"+
                "write 2 for ger arguments from txt file" +
                "write 3 for ger arguments from xml file" +
                "write 4 for ger arguments from json file" );
        Scanner in = new Scanner(System.in);
        int type = in.nextInt();
        WriterInTxt writerInTxt = new WriterInTxt();
        TextForOutPut textForOutPut = new TextForOutPut();
        switch (type) {
            case 1:
                FromCommandLine fromCommandLineSite = new FromCommandLine();
                fromCommandLineSite.open(args);
                writerInTxt.writeIn(textForOutPut.getInTxt(),textForOutPut.getFailTest(),
                textForOutPut.getPassTestTest(),textForOutPut.getAllTime());
                break;
            case 2:
              FromTxt fromTxt = new FromTxt();
                fromTxt.readFromTxt();
                writerInTxt.writeIn(textForOutPut.getInTxt(),textForOutPut.getFailTest(),
                        textForOutPut.getPassTestTest(),textForOutPut.getAllTime());
                break;
            case 3:
                FromXml fromXml = new FromXml();
                fromXml.readFromXml();
                writerInTxt.writeIn(textForOutPut.getInTxt(),textForOutPut.getFailTest(),
                        textForOutPut.getPassTestTest(),textForOutPut.getAllTime());
                break;
            case 4:
                FromJson fromJson = new FromJson();
                fromJson.readFromJson();
                writerInTxt.writeIn(textForOutPut.getInTxt(),textForOutPut.getFailTest(),
                        textForOutPut.getPassTestTest(),textForOutPut.getAllTime());
                break;
        }
    }
}