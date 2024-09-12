package me.splitque.configuration.filetypes;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class PROPERTIES implements ConfigurationType {
    Properties properties = new Properties();

    @Override
    public void create(Path path) {
        try {
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load(BufferedReader reader) {
        try {
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(BufferedWriter writer) {
        try {
            properties.store(writer, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void list() {
        System.out.println(properties.toString());
    }

    @Override
    public void putOption(String key, String value) {
        if (!properties.containsKey(key)) {
            properties.put(key, value);
        }
    }

    @Override
    public void setOption(String key, String value) {
        properties.put(key, value);
    }

    @Override
    public String getString(String key) {
        return String.valueOf(properties.get(key));
    }

    @Override
    public Boolean getBoolean(String key) {
        String bool = properties.getProperty(key);
        if (bool.equals("true")) {
            return true;
        } else if (bool.equals("false")) {
            return false;
        }
        return null;
    }

    @Override
    public int getInt(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }

    @Override
    public Double getDouble(String key) {
        return Double.parseDouble(properties.getProperty(key));
    }
}
