package me.splitque.configuration;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Path;

public class ConfigAPI {
    String getJarDir() {
        String jarDir = "";
        try {
            jarDir = new File(ConfigAPI.class
                    .getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .toURI())
                    .getParent();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return jarDir;
    }
    BufferedReader getReader(Path path) throws IOException {
        return new BufferedReader(new FileReader(path.toFile()));
    }
    BufferedWriter getWriter(Path path) throws IOException {
        return new BufferedWriter(new FileWriter(path.toFile()));
    }
}
