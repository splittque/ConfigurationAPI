# Configuration API

---

This project makes it easy to use configuration files in your project.

### Implementation
1. Download JAR from releases or build yourself
2. Put it in "libs" folder in your project (or any other folder)
##### Gradle
```groovy
repositories {
    flatDir {
        dirs "libs (or your folder)" 
    }
}
dependencies {
    implementation 'me.splitque:configuration-api:VERSION (last: v1.0-alpha)'
}
```
or
```groovy
dependencies {
    implementation fileTree(dir: 'libs (or your folder)', include: '*.jar')
}
```

3. Done

### Examples or How-to-Use

##### Example 1
```java
public class CreationConfig extends ConfigHandler {
    public CreationConfig() {
        super(true, null, "config", "PROPERTIES");

        putOption("opt1", "String");
        putOption("opt2", "true");
        putOption("opt3", "20");
        putOption("opt4", "2687.4");
    }
}
```
```java
public class Main {
    public static void main(String[] args) {
        CreationConfig config = new CreationConfig();
        Boolean opt = config.getBoolean("opt2");
    }
}
```
##### Result:
Directories with jar:
```
- Main.jar
- config.properties
```
config.properties:
```properties
#Thu Sep 12 08:59:25 YEKT 2024
opt1=String
opt2=true
opt3=20
opt4=2687.4
```

##### Example 2
```java
public class Main {
    ConfigHandler configHandler = new ConfigHandler(true, null, "config", "PROPERTIES");
    
    public static void main(String[] args) {
        configHandler.putOption("opt1", "String");
        configHandler.putOption("opt2", "true");
        configHandler.putOption("opt3", "20");
        configHandler.putOption("opt4", "2687.4");
    }
    public static void set(String key, String value) {
        configHandler.setOption(key, value);
    }
    public static Boolean get(String key) {
        return configHandler.getBoolean(key);
    }
}
```

```java
public class Class {
    public void GetOrSetFromConfig() {
        Boolean opt = Main.get("opt2");
        Main.set("opt1", "other_string");
    }
}
```
##### Result:
Directories with jar:
```
- Main.jar
- config.properties
```
config.properties:
```properties
#Thu Sep 12 08:59:25 YEKT 2024
opt1=other_string
opt2=true
opt3=20
opt4=2687.4
```