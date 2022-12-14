package support.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static support.utils.Environments.getEnvironment;

public class GetProperties {

    private static final String DATA_CONFIG = "src/test/resources/";
    private static Properties properties;

    public static String getProp(String value){
        try {
            if(properties == null){
                GetProperties.properties = new Properties();
                GetProperties.properties.load(new FileInputStream(DATA_CONFIG + getEnvironment() + ".properties"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return GetProperties.properties.getProperty(value);
    }
}
