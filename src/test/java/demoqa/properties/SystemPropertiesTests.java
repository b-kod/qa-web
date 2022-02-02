package demoqa.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

//    System.getProperty("key");
//    System.setProperty("key", "value");

    @Test
    void someTest1() {
        String someValue = System.getProperty("someKey");
        System.out.println(someValue);

        System.setProperty("someKey", "red");
        someValue = System.getProperty("someKey");
        System.out.println(someValue);
    }

    @Test
    @Tag("properties")
    void someTest2() {
        String browser = System.getProperty("browser", "chrome");
        System.out.println(browser);
    }

    @Test
    @Tag("properties")
    void someTest3() {
        String browser = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "91");
        String browserSize = System.getProperty("browserSize", "300x300");

        System.out.println(browser);
        System.out.println(version);
        System.out.println(browserSize);
    }
}
