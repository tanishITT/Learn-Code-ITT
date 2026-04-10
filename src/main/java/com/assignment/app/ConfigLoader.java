package com.assignment.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static final String DEFAULT_CONFIG_FILE = "config.properties";

    private final Properties properties;

    public ConfigLoader() {
        this(DEFAULT_CONFIG_FILE);
    }

    public ConfigLoader(String fileName) {
        properties = new Properties();
        try (InputStream inputStream = new FileInputStream(fileName)) {
            properties.load(inputStream);
        } catch (IOException ex) {
            System.err.println("Warning: Could not load " + fileName + ". Please verify it exists.");
        }
    }

    public String fetchProperty(String key) {
        return properties.getProperty(key);
    }
}
