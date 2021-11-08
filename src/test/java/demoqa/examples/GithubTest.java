package demoqa.examples;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class GithubTest {
    @Test
    void selenidePageShouldHaveJUnitCodeExample() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-body").shouldHave(text("Soft assertions"));
        $("#wiki-body ul li a", 6).shouldHave(attribute("href", "https://github.com/selenide/selenide/wiki/SoftAssertions"));
        $("#wiki-body ul li a", 6).click();
        $("#wiki-body ol", 3).shouldHave(text("Using JUnit5 extend test class"));
        $("#wiki-body pre", 4).shouldHave(text("@ExtendWith({SoftAssertsExtension.class})"));
    }
}
