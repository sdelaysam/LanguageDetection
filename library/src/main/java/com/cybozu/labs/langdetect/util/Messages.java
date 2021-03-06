package com.cybozu.labs.langdetect.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.MissingResourceException;
import java.util.Properties;

/**
 * This is {@link Messages} class generated by Eclipse automatically.
 * Users don't use this class directly.
 * @author Nakatani Shuyo
 */
public class Messages {

    private static Properties RESOURCE_BUNDLE = new Properties();

    static {
        String propertiesFile = "messages.properties";
        InputStream inputStream = Messages.class.getClassLoader().getResourceAsStream(propertiesFile);
        Reader reader = new InputStreamReader(inputStream);
        try {
            RESOURCE_BUNDLE.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getProperty(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
}
