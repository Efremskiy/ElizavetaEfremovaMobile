package setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import enums.CommonTestData;

/**
 * This class gets property value by its key from chosen property file.
 */
public class TestProperties {
    private static Properties currentProperties = new Properties();
    private static String propertyFileName;

    public static void setPropertyFileName(String fileName) {
        propertyFileName = fileName;
    }

    public static String getProperty(String propKey) throws IOException {
        FileInputStream in = new FileInputStream(CommonTestData.PROPERTIES_PATH.toString() + propertyFileName);
        currentProperties.load(in);
        in.close();

        if(!currentProperties.containsKey(propKey)) {
            return null;
        }
        return currentProperties.getProperty(propKey);
    }
}
