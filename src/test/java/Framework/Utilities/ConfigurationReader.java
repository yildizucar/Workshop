package Framework.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static final Logger log = LoggerFactory.getLogger(ConfigurationReader.class);

    public static String get(String configKey) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("configuration.properties"));
        } catch (Exception e) {
            log.error("Error reading configuration file with exception :" + e);
        }
        return properties.getProperty(configKey).trim();
    }

}
