package neon.testautomation.message;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Message {

    private static Properties prop;

    public static Properties getProperties() throws InterruptedException, IOException {

        if (prop != null) {
            return prop;
        }

        prop = new Properties();

        InputStream input = null;

        try {

            input = new FileInputStream("tests-config.properties");

            // load a properties file
            prop.load(input);
            return prop;

        } catch (IOException ex) {
            ex.printStackTrace();
            throw ex;

        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
