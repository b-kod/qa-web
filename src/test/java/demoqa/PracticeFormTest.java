package demoqa;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillPracticeFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Test");
        $("#lastName").setValue("Test");
        $("#userEmail").setValue("test@test.com");
        $("[for=gender-radio-2]").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $("[value='2001']").click();
        $(".react-datepicker__month-select").click();
        $("[value='1']").click();
        $("[aria-label='Choose Saturday, February 3rd, 2001']").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("[for=hobbies-checkbox-2]").click();
        $("#uploadPicture").uploadFromClasspath("test.jpg");
        $("#currentAddress").setValue("test");
        $("#state").scrollTo().click();
        $(By.xpath("//*[contains(text(), 'NCR')]")).click();
        $("#city").click();
        $(By.xpath("//*[contains(text(), 'Delhi')]")).click();
        $("#submit").click();
        $(By.tagName("tbody")).shouldHave(text("Test"));
        $(By.tagName("tbody")).shouldHave(text("test@test.com"));
        $(By.tagName("tbody")).shouldHave(text("Female"));
        $(By.tagName("tbody")).shouldHave(text("1234567890"));
        $(By.tagName("tbody")).shouldHave(text("03 February,2001"));
        $(By.tagName("tbody")).shouldHave(text("Maths"));
        $(By.tagName("tbody")).shouldHave(text("Reading"));
        $(By.tagName("tbody")).shouldHave(text("test.jpg"));
        $(By.tagName("tbody")).shouldHave(text("test"));
        $(By.tagName("tbody")).shouldHave(text("NCR Delhi"));
    }
}
