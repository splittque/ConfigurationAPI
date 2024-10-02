package me.splitque.configuration;

import me.splitque.configuration.filetypes.ConfigurationType;
import me.splitque.configuration.filetypes.JSON;
import me.splitque.configuration.filetypes.PROPERTIES;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class ConfigHandler extends ConfigAPI {
    private ConfigurationType config;
    private Path configPath;

    public ConfigHandler(Boolean useJarDir, String path, String name, String type) {
        if (path == null) {
            if (useJarDir) {
                this.configPath = Path.of(getJarDir() + "/" + name + "." + type.toLowerCase());
            } else {
                this.configPath = Path.of(name + "." + type.toLowerCase());
            }
        } else {
            if (useJarDir) {
                this.configPath = Path.of(getJarDir() + "/" + path + "/" + name + "." + type.toLowerCase());
            } else {
                this.configPath = Path.of(path + "/" + name + "." + type.toLowerCase());
            }
        }

        switch (type) {
            case "PROPERTIES":
                config = new PROPERTIES();
                if (!Files.exists(configPath)) {
                    config.create(configPath);
                } else {
                    try (BufferedReader reader = getReader(configPath)) {
                        config.load(null, reader);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case "JSON":
                config = new JSON();
                if (!Files.exists(configPath)) {
                    config.create(configPath);
                } else {
                    config.load(configPath, null);
                }
                break;
        }
    }



    public void putOption(String key, String value) {
        config.putOption(key, value);

        try (BufferedWriter writer = getWriter(configPath)) {
            config.save(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setOption(String key, String value) {
        config.setOption(key, value);

        try (BufferedWriter writer = getWriter(configPath)) {
            config.save(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getString(String key) {
        return config.getString(key);
    }
    public Boolean getBoolean(String key) {
        return config.getBoolean(key);
    }
    public int getInt(String key) {
        return config.getInt(key);
    }
    public Double getDouble(String key) {
        return config.getDouble(key);
    }
}
