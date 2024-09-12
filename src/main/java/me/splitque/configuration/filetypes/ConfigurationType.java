package me.splitque.configuration.filetypes;

import java.io.*;
import java.nio.file.Path;
import java.util.Properties;

public interface ConfigurationType {
    void create(Path path);
    void load(BufferedReader reader);
    void save(BufferedWriter writer);
    void list();

    void putOption(String key, String value);
    void setOption(String key, String value);

    String getString(String key);
    Boolean getBoolean(String key);
    int getInt(String key);
    Double getDouble(String key);
}
