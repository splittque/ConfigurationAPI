package me.splitque.configuratuon;

import me.splitque.configuration.ConfigHandler;

public class CreationConfig extends ConfigHandler {
    public CreationConfig() {
        super(true,null, "config", "PROPERTIES");

        putOption("opt1", "String");
        putOption("opt2", "true");
        putOption("opt3", "20");
        putOption("opt4", "2687.4");
    }
}
