package com.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigureClass {
	
    private static Properties properties;

    static {
        try {
        	FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Configure.properties");
        	
        	properties = new Properties();
            properties.load(fis);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }

    public static String getUsername() {
        return properties.getProperty("username");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(properties.getProperty("headless"));
    }

}