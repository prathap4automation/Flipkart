package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {
    private static Properties properties;
    private static FileReader fileReader;

    public static String getPropertyValue(String fileName,String propertyName) throws IOException {
        String configFilePath = "src" + File.separator + "test" + File.separator + "application files" + File.separator + fileName+".properties";
        fileReader = new FileReader(configFilePath);
        properties = new Properties();
        properties.load(fileReader);
        return properties.getProperty(propertyName);
    }
}
