package com.example.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvException;

import java.io.FileReader;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    private static JSONParser jsonParser;

    static {
        try {
            properties = new Properties();
            properties.load(new FileReader("src/test/resources/config.properties")); 

            jsonParser = new JSONParser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ConfigReader() {
        throw new IllegalStateException("Utility class");
    }

    public static String getProperty(String key) {
        return properties.getProperty(key) != null ? properties.getProperty(key) : loadEnv(key);
    }

    public static JSONObject readJsonFile(String fileName) {
        try {
            FileReader reader = new FileReader("src/test/resources/testdata/" + fileName);
            return (JSONObject) jsonParser.parse(reader);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    public static String loadEnv(String variable) {
        Dotenv dotenv = null;
        try {
            dotenv = Dotenv.load();
        } catch (DotenvException e) {
            return null;
        }
        return dotenv.get(variable);
    }
}
