package demoqa.JUnitTests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class JUnitParametrizedTests {
    static Stream<Arguments> gitHubPageShouldHaveMultipleValuesMethodTest() {
        return Stream.of(
                Arguments.of("actions", "Actions"),
                Arguments.of("projects", "Projects"),
                Arguments.of("wiki", "Wiki")
        );
    }

    @ValueSource(strings = {"example.csv", "example.txt", "example.zip", "test.jpg"})
    @Tag("blocker")
    @ParameterizedTest(name = "Тесты на загрузку файла {0}")
    void uploadFileTest(String fileName) {
        open("https://the-internet.herokuapp.com/upload");
        $("input[type='file']").uploadFromClasspath(fileName);
        $("#file-submit").click();
        $("#uploaded-files").shouldHave(text(fileName));
    }

    @CsvSource({
            "issues, Issues",
            "pulls, Pull requests",
            "security, Security"
    })
    @Tag("blocker")
    @ParameterizedTest(name = "Тест на содержание в репозитории ключевых разделов {0}")
    void gitHubPageShouldHaveMultipleValuesCsvTest(String value, String expectedText) {
        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("b-kod/qa-web");
        $(".header-search-input").submit();
        $(linkText("b-kod/qa-web")).click();
        $("a[href='/b-kod/qa-web/" + value + "']").shouldHave(Condition.text(expectedText));
    }

    @MethodSource
    @Tag("blocker")
    @ParameterizedTest(name = "Тест на содержание в репозитории ключевых разделов {0}")
    void gitHubPageShouldHaveMultipleValuesMethodTest(String value, String expectedText) {
        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("b-kod/qa-web");
        $(".header-search-input").submit();
        $(linkText("b-kod/qa-web")).click();
        $("a[href='/b-kod/qa-web/" + value + "']").shouldHave(Condition.text(expectedText));
    }

}
