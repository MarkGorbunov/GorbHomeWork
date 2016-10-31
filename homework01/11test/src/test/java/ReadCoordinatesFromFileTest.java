import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mark on 31.10.2016.
 */
public class ReadCoordinatesFromFileTest {
    @Test
    public void read() throws Exception {
        ReadCoordinatesFromFile read = new ReadCoordinatesFromFile();
        assertNotNull(read.read());
    }
}