package me.splitque.configuratuon;

import me.splitque.configuration.ConfigHandler;
import org.junit.jupiter.api.Test;

public class CreationConfigNotClass {
    @Test
    public void CreationConfig() {
        ConfigHandler configHandler = new ConfigHandler(true,null, "config2", "PROPERTIES");

        configHandler.putOption("opt1", "String");
        configHandler.putOption("opt2", "true");
        configHandler.putOption("opt3", "20");
        configHandler.putOption("opt4", "2687.4");

        System.out.println(configHandler.getString("opt1"));
        System.out.println(configHandler.getBoolean("opt2"));
        System.out.println(configHandler.getInt("opt3"));
        System.out.println(configHandler.getDouble("opt4"));
    }
}
