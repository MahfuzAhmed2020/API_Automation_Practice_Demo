package com.osa.base;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    public static String readProperty(String key) {
        Properties properties = new Properties();
        try (InputStream input = PropertyReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) throw new IllegalStateException("config.properties not found");
            properties.load(input);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot load configuration", e);
        }
        String value = properties.getProperty(key);
        if (value == null || value.trim().isEmpty()) throw new IllegalArgumentException("Missing configuration: " + key);
        return value.trim();
    }
}
