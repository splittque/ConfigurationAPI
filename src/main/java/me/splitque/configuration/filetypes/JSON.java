package me.splitque.configuration.filetypes;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JSON implements ConfigurationType {
    JSONObject json;

    @Override
    public void create(Path path) {
        try {
            Files.createFile(path);
            json = new JSONObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load(Path path, BufferedReader reader) {
        try {
            json = new JSONObject(Files.readString(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(BufferedWriter writer) {
        json.write(writer);
    }

    @Override
    public void list() {
        System.out.println(json.toString());
    }

    @Override
    public void putOption(String key, String value) {
        if (json.isNull(key)) {
            json.put(key, value);
        }
    }

    @Override
    public void setOption(String key, String value) {
        json.put(key, value);
    }

    @Override
    public String getString(String key) {
        return json.getString(key);
    }

    @Override
    public Boolean getBoolean(String key) {
        return json.getBoolean(key);
    }

    @Override
    public int getInt(String key) {
        return json.getInt(key);
    }

    @Override
    public Double getDouble(String key) {
        return json.getDouble(key);
    }
}
