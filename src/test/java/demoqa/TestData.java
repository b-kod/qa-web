package demoqa;
import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    // VALUES
    public static Faker faker = new Faker();
    public static String firstName = faker.name().firstName(),
                         lastName = faker.name().lastName(),
                         email = lastName.toLowerCase(Locale.ROOT) + "@gmail.com",
                         phoneNumber = faker.phoneNumber().subscriberNumber(10),
                         address = faker.address().streetAddress();

    public static void main(String[] args) {
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(email);
        System.out.println(phoneNumber);
        System.out.println(address);
    }
}
