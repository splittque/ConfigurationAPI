package me.splitque.configuratuon;

import org.junit.jupiter.api.Test;

public class CreationConfigStarter {
    @Test
    public void Test() {
        CreationConfig creationConfigTest = new CreationConfig();
        System.out.println(creationConfigTest.getString("opt1"));
        System.out.println(creationConfigTest.getBoolean("opt2"));
        System.out.println(creationConfigTest.getInt("opt3"));
        System.out.println(creationConfigTest.getDouble("opt4"));
    }
}
