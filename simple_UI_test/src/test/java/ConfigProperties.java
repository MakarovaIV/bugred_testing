import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    protected static FileInputStream fileInputStream;
    protected static Properties prop;

    static {
        try {
            //path to configuration file
            fileInputStream = new FileInputStream("src/test/resources/config.properties");
            prop = new Properties();
            prop.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Sorry, unable to find config.properties");
            // exception handling (not exist, etc.)
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    //return string with value from file
    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}
