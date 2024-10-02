package me.splitque.configuratuon;

import me.splitque.configuration.ConfigHandler;
import org.junit.jupiter.api.Test;

public class JSONConfig {
    @Test
    public void JSONConfigCreate() {
        ConfigHandler configHandler = new ConfigHandler(true, null, "jsonconfig", "JSON");

        configHandler.putOption("opt1", "String");
        configHandler.putOption("opt2", "22");

        System.out.println(configHandler.getString("opt1"));
        System.out.println(configHandler.getInt("opt2"));
    }
}
